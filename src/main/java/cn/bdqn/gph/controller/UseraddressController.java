package cn.bdqn.gph.controller;


import cn.bdqn.gph.entity.Useraddress;
import cn.bdqn.gph.service.IUseraddressService;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
//@RequestMapping("/useraddress")
public class UseraddressController {
    @Resource(name = "iUseraddressService")
    private IUseraddressService iUseraddressService;

    /**
     * 地址显示
     * @param session
     * @return
     */
   /* @RequestMapping("/show")
    public String show(HttpSession session){
        List<Useraddress> byuserName = iUseraddressService.findAll();
        session.setAttribute("user",byuserName);
        return "person/address";
    }*/

    /**
     * 添加新地址
     * @param useraddress
     * @param bindingResult
     * @return
     */
    @RequestMapping("/address")
    public String address(Useraddress useraddress, BindingResult bindingResult){
        Integer userId = useraddress.getUserId();
        iUseraddressService.Insertaddress(useraddress);
        return "redirect:show?userId="+userId;
    }

    /**
     * 修改地址
     * @param request
     * @param useraddress
     * @param bindingResult
     * @return
     */
    @RequestMapping("/update")
    public String update(HttpServletRequest request, Useraddress useraddress,Integer userId, BindingResult bindingResult){
//        QueryWrapper<Useraddress> queryWrapper = new QueryWrapper<Useraddress>();
//        Integer id = Integer.valueOf(request.getParameter("id"));
//        queryWrapper.eq("userId",id);
        useraddress.setUserId(userId);
        iUseraddressService.modifyUserInfo(useraddress);
        return "redirect:show?userId="+userId;
    }

    /**
     * 删除地址
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(HttpServletRequest request,Integer id, HttpServletResponse response){
        boolean flag =  false;
        int re = iUseraddressService.deleteUserAddress(id);
        if(re>0){
            flag = true;
        }
        return JSONArray.toJSONString(flag);
    }
}
