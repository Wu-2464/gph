package cn.bdqn.gph.controller;


import cn.bdqn.gph.entity.*;
import cn.bdqn.gph.service.IProductCategoryService;
import cn.bdqn.gph.service.IProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
@Controller
//@RequestMapping("/product-category")
public class ProductCategoryController {
    @Resource(name = "pcService")
    private IProductCategoryService ipcs;



    @Resource(name = "proServive")
    private IProductService ipro;

    /**
     * 三级分类
     * @param model
     * @param session
     * @return
     */
    /*@RequestMapping("/")
    public String index(Model model,HttpSession session){
        CategoryUtil cu = new CategoryUtil();
        List<ProductCategory> list = ipcs.listCategory();
        List<ProductCategory> categories = cu.createCategory(list);
        QueryWrapper<Product> queryWrapper = new QueryWrapper<Product>();
        queryWrapper.eq("categoryLevel3Id",1);
        List<Product> productList = ipro.list(queryWrapper);
        model.addAttribute("categories",categories);
        model.addAttribute("productList",productList);
        return "home/home3";
    }*/

    /**
     * 查询三级菜单下的商品
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public String detail(Model model, HttpServletRequest request,Integer id, Integer proId,HttpSession session){
/*        List<ImgFile> imgFile = ipro.selectPic(proId);
        Integer id = Integer.parseInt(request.getParameter("id"));
        QueryWrapper<Product> queryWrapper = new QueryWrapper<Product>();
        queryWrapper.eq("categoryLevel3Id",id);
        List<Product> productList = ipro.list(queryWrapper);
        model.addAttribute("proByPage",productList);*/
        int pageNum=0;
        int pageSize=12;
        String currentPage =request.getParameter("currentPage");
        if(currentPage!=null){
            pageNum = Integer.parseInt(currentPage);
        }
        if(pageNum<0){
            pageNum = 0;
        }
        int pageTotal = ipcs.getCountByThree(id);
        Page page = new Page(pageTotal,pageSize,pageNum);
        List<Product> proByPage = ipcs.getProByPageAndThree(pageNum, pageSize, id);
        session.setAttribute("page",page);
        session.setAttribute("proByPage",proByPage);
        session.setAttribute("pid",id);

        return "home/search";
    }

    /**
     * 商品详情
     * @param session
     * @param request
     * @param proId
     * @return
     */
    @RequestMapping("/introduction")
    public String introduction(HttpSession session,HttpServletRequest request,Integer proId){
        List<ImgFile> imgFile = ipro.selectPic(proId);
        QueryWrapper<Product> queryWrapper = new QueryWrapper<Product>();
        /*proId = Integer.valueOf(request.getParameter("proId"));*/
        Product product = ipro.getProById(proId);
        session.setAttribute("product",product);
        session.setAttribute("imgFile1",imgFile.get(0));

        session.setAttribute("imgFile2",imgFile.get(1));
        return "home/introduction";
    }

    @RequestMapping("/find")
    public String search(@RequestParam("str") String str, Model model,HttpSession session,HttpServletRequest request){
       /* QueryWrapper<Product> queryWrapper = new QueryWrapper<Product>();
        queryWrapper.like("productName",str);
        List<Product> productList = ipro.list(queryWrapper);*/
        int pageNum=0;

        int pageSize=12;
        String currentPage =request.getParameter("currentPage");
        if(currentPage!=null){
            pageNum = Integer.parseInt(currentPage);
        }
        if(pageNum<0){
            pageNum = 0;
        }
        int pageTotal = ipro.getCountByName(str);
        Page page = new Page(pageTotal,pageSize,pageNum);
        List<Product> proByName = ipro.getProByName(pageNum,pageSize,str);
        session.setAttribute("proByPage",proByName);
//        model.addAttribute("productList",proByName);
        return "home/search";
    }

    /**
     * 更多商品
     */
    @RequestMapping("/more")
    public String more(HttpServletRequest request,HttpSession session,Integer pid,Model model){
//        IPage<Product> page = new Page<>();
//        page.setCurrent(curr);
//        page.setSize(size);
//        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("categoryLevel1Id",pid);
//        IPage<Product> proIPage = ipro.page(page,queryWrapper);
//        List<Product> mList = ipro.list(queryWrapper);
        int pageNum=0;
        int pageSize=12;
        String currentPage =request.getParameter("currentPage");
        if(currentPage!=null){
            pageNum = Integer.parseInt(currentPage);
        }
        if(pageNum<0){
            pageNum = 0;
        }
        int pageTotal = ipcs.getCount(pid);
        Page page = new Page(pageTotal,pageSize,pageNum);
        List<Product> proByPage = ipcs.getProByPage(pageNum, pageSize, pid);
        session.setAttribute("page",page);
        session.setAttribute("proByPage",proByPage);
        session.setAttribute("pid",pid);

//        model.addAttribute("productList",proByPage);
        return "home/search";
    }
}
