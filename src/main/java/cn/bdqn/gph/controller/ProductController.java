package cn.bdqn.gph.controller;


import cn.bdqn.gph.entity.Brand;
import cn.bdqn.gph.entity.ImgFile;
import cn.bdqn.gph.entity.Product;
import cn.bdqn.gph.entity.ProductCategory;
import cn.bdqn.gph.service.IProductService;
import cn.bdqn.gph.service.QiniuService;
import cn.bdqn.gph.service.impl.ProductServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
@Controller
//@RequestMapping("/product")
public class ProductController {

    @Resource(name = "proServive")
    private IProductService pros;

    @Resource(name = "QiniuService")
    private QiniuService qiniuService;

    @RequestMapping("/home")
    public String index(){
        return "home/home3";
    }

    @RequestMapping("/add")
    public String index(Model model, Product product, Integer parentId) {

        List<Brand> Brand = pros.findBrandName();
        model.addAttribute("Brand", Brand);
        product.setStatus(0);
        model.addAttribute("product", product);
        return "person/Commodityshelves";
    }


    @RequestMapping("/AddProduct")
    public String add(Product p, ImgFile i, BindingResult result, MultipartFile[] imgFile, Model model, HttpSession session) throws IOException {
        int insertProduct = pros.insertProduct(p);

        if (insertProduct != 0) {
            int newInfo = pros.findNewInfo();
            if (newInfo != 0) {
                for (MultipartFile imgfile : imgFile) {
                    if (!imgfile.isEmpty()) {
//                        String Filename = imgfile.getOriginalFilename();
                        String fileUrl = qiniuService.saveImage(imgfile);
                        String suffix = fileUrl.substring(fileUrl.lastIndexOf(".") + 1);
                        if (suffix.equals("png") || suffix.equals("jpg") || suffix.equals("bmp") || suffix.equals("gif")) {
                            /*File file = new File("https://portal.qiniu.com/kodo/bucket/resource?bucketName=gph-image", Filename);
                            imgfile.transferTo(file);*/
                            i.setImgFile(fileUrl);
                            i.setProductId(newInfo);
                            pros.insertImg(i);
                        }
                    }
                }
            }
        }
        return "redirect:add";
    }

    /**
     * 三级分类名称
     * @param parentId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getName")
    public Object getName(int parentId){
        List<ProductCategory> productCategories = pros.findNameByParentId(parentId);
        System.out.println(productCategories);
        return productCategories;
    }

    /*@RequestMapping("/page")
    public String page(String pageNumber,Model model,Integer level1Id){
        String spPage=pageNumber;
        //设置每页条数
        int pageSize=5;
        //页数
        int pageNo=0;
        if(spPage==null){
            pageNo=1;
        }else {
            pageNo = Integer.valueOf(spPage);
            if (pageNo < 1) {
                pageNo = 1;
            }
        }
        //设置最大页数
        int totalCount=0;
        int count=pros.getCount(level1Id);
        if(count>0){
            totalCount=count;
        }
        int maxPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        if(pageNo>maxPage){
            pageNo=maxPage;
        }
        Integer tempPageNo=(pageNo-1)*pageSize;
        //计算总数量
        //分页查询
        Map map=new HashMap();
        map.put("pageNo",tempPageNo);
        map.put("pageSize",pageSize);
        map.put("phone",level1Id);
        List<Map> list=pros.getListByPage(map);
        //最后把信息放入model转发到页面把信息带过去
        model.addAttribute("list",list);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("maxPage",maxPage);
        return "home/search";
    }*/

}
