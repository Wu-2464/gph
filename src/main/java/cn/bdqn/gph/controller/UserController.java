package cn.bdqn.gph.controller;


import cn.bdqn.gph.entity.*;
import cn.bdqn.gph.service.IProductCategoryService;
import cn.bdqn.gph.service.IProductService;
import cn.bdqn.gph.service.IUserService;
import cn.bdqn.gph.service.IUseraddressService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
@Controller
//@RequestMapping("/user")
public class UserController {
    @Resource(name = "iUseraddressService")
    private IUseraddressService iUseraddressService;
    @Resource(name="userService")
    private IUserService iUserService;
    @Resource(name = "pcService")
    private IProductCategoryService ipcs;

    @Resource(name = "proServive")
    private IProductService ipro;
    //进入首页
    @RequestMapping(value = "/index",method = {RequestMethod.GET,RequestMethod.POST})
    public String  index(HttpSession session, HttpServletRequest request,Model model,Integer pid){
        CategoryUtil cu = new CategoryUtil();
        List<ProductCategory> list = ipcs.listCategory();
        List<ProductCategory> categories = cu.createCategory(list);

        /*QueryWrapper<Product> queryWrapper = new QueryWrapper<Product>();
        queryWrapper.eq("categoryLevel3Id",1);
        List<Product> productList = ipro.list(queryWrapper);*/
        List<Product> productList = ipro.getAllByL3Id();


        List<Product> byPrice = ipro.listByPrice();
        model.addAttribute("price",byPrice);

        List<Product> listBy1 = ipro.getListBy1();
        model.addAttribute("listBy1",listBy1);
        List<Product> listBy2 = ipro.getListBy2();
        model.addAttribute("listBy2",listBy2);
        List<Product> listBy3 = ipro.getListBy3();
        model.addAttribute("listBy3",listBy3);
        List<Product> listBy4 = ipro.getListBy4();
        model.addAttribute("listBy4",listBy4);
        List<Product> listBy5 = ipro.getListBy5();
        model.addAttribute("listBy5",listBy5);
        List<Product> listBy6 = ipro.getListBy6();
        model.addAttribute("listBy6",listBy6);
        List<Product> listBy7 = ipro.getListBy7();
        model.addAttribute("listBy7",listBy7);
        List<Product> listBy8 = ipro.getListBy8();
        model.addAttribute("listBy8",listBy8);
        List<Product> listBy9 = ipro.getListBy9();
        model.addAttribute("listBy9",listBy9);

//        QueryWrapper<Product> queryWrapper1 = new QueryWrapper<Product>();
//        List<ProductCategory> categories1 = ipcs.cateList1();
//        List<Integer> ids = new ArrayList<>();
//
//        for (ProductCategory pro : categories1) {
//            ids.add(pro.getId());
//        }
//        List<Product> productList1 = ipro.getListByCate1(ids);
//        queryWrapper1.eq("categoryLevel1Id",pid);
        model.addAttribute("categories",categories);
        model.addAttribute("productList",productList);
//        model.addAttribute("list1",productList1);
//        model.addAttribute("pColl",productCollection);
        return "home/home3";
    }

    @RequestMapping("/show")
    public String show(HttpSession session,Integer userId){
        List<Useraddress> byuserName = iUseraddressService.findAll(userId);
        session.setAttribute("user1",byuserName);
        return "person/address";
    }

    @RequestMapping("/pro")
    public String p(){
        return "";
    }

    //用户登录
    @RequestMapping("/userlogin")
    public String userLogin(HttpSession session ,
                            @RequestParam("loginmode")String loginmode, @RequestParam("userPassword")String userPassword){
        User user1 = iUserService.getUserByLoginModeAndPwd(loginmode,userPassword);
        if(user1==null){
            System.out.println("not ok");
            return "home/login";
        }
        session.setAttribute("user",user1);
        System.out.println("ok");
        return "redirect:index";
    }
    //进入注册页面
    @RequestMapping("/regist")
    public String regist() {
        return "home/register";
    }

    /**
     * 发送短信验证码 number接收手机号码
     * @param
     */
    @RequestMapping("/sendSms")
    @ResponseBody
    public String sendSms(HttpServletRequest request,@RequestParam("number")String number) {
        System.out.println(number);
        boolean flag = false;
        JSONObject json = null;
        try {
            // JSONObject json = null;
            //生成6位验证码
            String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
            //发送短信
            ZhenziSmsClient client = new ZhenziSmsClient
                    ("https://sms_developer.zhenzikj.com", "105010","ef99fd96-bd0f-410c-8ba9-2c626ea9990c");
            Map<String,String> params = new HashMap<String,String>();
            params.put("number",number);
            params.put("message","工品汇验证码为:"+verifyCode);

            String result = client.send(params);
            json = JSONObject.parseObject(result);
            if(json.getIntValue("code") != 0){
                //发送短信失败
                flag = false;
                System.out.print(json.getString("data"));
                System.out.print(json.getString("message"));
                System.out.print(json.getIntValue("code"));
            }else{
                //将验证码存到session中,同时存入创建时间
                //以json存放，这里使用的是阿里的fastjson
                HttpSession session = request.getSession();
                json = new JSONObject();
                json.put("verifyCode", verifyCode);
                json.put("createTime", System.currentTimeMillis());
                // 将认证码存入SESSION
                request.getSession().setAttribute("verifyCode", json);
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONArray.toJSONString(flag);
    }
    //注册用户,如注册成功则登录并进入主页，如注册失败则返回注册页
    @RequestMapping("/registuser")
    @ResponseBody
    public String registuser(HttpSession session,
                             String number,String userPassword,
                             HttpServletRequest request,String verifyCode) {
        JSONObject jsonResult = null;
        JSONObject json = (JSONObject)request.getSession().getAttribute("verifyCode");
        HashMap<String,String> resultMap=new HashMap<String,String>();
        System.out.println(123);
        System.out.println(json.getString("verifyCode"));
        //判断是否发送验证码及验证码是否正确
        if(json.getString("verifyCode").isEmpty()){
            resultMap.put("name","nocode");
            return jsonResult.toJSONString(resultMap);
        }else {
            if(!json.getString("verifyCode").equals(verifyCode)){
                resultMap.put("name","wrong");
                return jsonResult.toJSONString(resultMap);
            }
        }

        //判断是否超时
        if((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 5){
            resultMap.put("name","passed");
            return jsonResult.toJSONString(resultMap);
        }
        //查看是否为已注册用户
        User checkuser = iUserService.getUserByRegistMode(number);
        if(checkuser!=null){
            resultMap.put("name","exists");
            return  jsonResult.toJSONString(resultMap);
        }
        //添加用户
        boolean b = iUserService.addUserByRegistModeAndPwd(number,userPassword);
        if(b==true){
            //添加用户成功则登录用户
            User user = iUserService.getUserByRegistMode(number);
            session.setAttribute("user",user);
            resultMap.put("name","Finish");
            return jsonResult.toJSONString(resultMap);
        }else{
            resultMap.put("name","registwrong");

        }
        return jsonResult.toJSONString(resultMap);
    }


    //进入用户中心(用户信息页)
    @RequestMapping("/userBack")
    public String userBack() {
        return "/person/information";
    }

    //修改用户信息
    @RequestMapping("/modifyinfo")
    public String modifyinfo(HttpSession session,User user) {
        boolean b = iUserService.changeUserByInfo(user);
        if(b==true){
            //修改成功将修改过的用户信息存入session
            User u = iUserService.getById(user.getId());
            session.setAttribute("user",u);
            return "/person/information";
        }
        //修改失败返回哪里？
        return "/person/information";
    }


    //修改用户密码
    @RequestMapping("/changepassword")
    public String changepassword(HttpSession session,@RequestParam("id")int id,
                                 @RequestParam("userPassword")String userPassword,@RequestParam("newPassword")String newPassword) {
        boolean b = iUserService.changeUserPassword(id, userPassword, newPassword);
        if(b==true){
            //修改密码成功则注销用户重新登录
            session.invalidate();
            return "/home/login";
        }
        return "/person/password";
    }
    //注销用户
    @RequestMapping("/logoff")
    public String logoff(HttpSession session) {
        session.invalidate();
        return "redirect:index";
    }

    //绑定用户手机号
    @RequestMapping("bindphonereq")
    @ResponseBody
    public String bindphonereq (HttpSession session, HttpServletRequest request,
                                String number,String id,String verifyCode){
        JSONObject jsonResult = null;
        JSONObject json = (JSONObject)request.getSession().getAttribute("verifyCode");
        HashMap<String,String> resultMap=new HashMap<String,String>();
        System.out.println("bbbbbbbbb");
        System.out.println(json.getString("verifyCode"));
        System.out.println("verifyCode"+verifyCode);
        //判断是否发送验证码及验证码是否正确

        if(!json.getString("verifyCode").equals(verifyCode)){
            resultMap.put("name","wrong");
            return jsonResult.toJSONString(resultMap);
        }

        // if(!json.getString("verifyCode").equals(verifyCode)){
        //     System.out.println("ccc");
        //         resultMap.put("name","wrong");
        //         return jsonResult.toJSONString(resultMap);
        //     }
        System.out.println("aaa");
        //判断验证码是否超时
        if((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 5){
            resultMap.put("name","passed");
            return jsonResult.toJSONString(resultMap);
        }
        //查看手机号是否存在
        User checkuser = iUserService.getUserByRegistMode(number);
        if(checkuser!=null){
            resultMap.put("name","exists");
            return  jsonResult.toJSONString(resultMap);
        }
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.set("phone",number);
        userUpdateWrapper.eq("id",id);
        //修改用户手机号
        boolean b = iUserService.update(userUpdateWrapper);
        if(b==true){
            //修改成功则登陆(注销用户并将修改过的用户登录)
            User u = iUserService.getUserByRegistMode(number);
            session.removeAttribute("user");
            session.setAttribute("user",u);
            resultMap.put("name","finish");
            return jsonResult.toJSONString(resultMap);
        }else{
            //修改出错
            resultMap.put("name","changewrong");
        }
        return jsonResult.toJSONString(resultMap);
    }

    //改绑用户手机号
    @RequestMapping("changephonereq")
    @ResponseBody
    public String changephonereq (HttpSession session, HttpServletRequest request,
                                  String number,String id,String verifyCode){
        JSONObject jsonResult = null;
        JSONObject json = (JSONObject)request.getSession().getAttribute("verifyCode");
        HashMap<String,String> resultMap=new HashMap<String,String>();
        String check = json.getString("verifyCode");
        //判断是否发送验证码及验证码是否正确
        if(check==null){
            resultMap.put("name","nocode");
            return jsonResult.toJSONString(resultMap);
        }
        if(!json.getString("verifyCode").equals(verifyCode)){
            resultMap.put("name","wrong");
            return jsonResult.toJSONString(resultMap);
        }
        //判断验证码是否超时
        if((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 5){
            resultMap.put("name","passed");
            return jsonResult.toJSONString(resultMap);
        }
        //查看手机号是否存在
        QueryWrapper<User> checkwrapper = new QueryWrapper<>();
        checkwrapper.eq("phone",number);
        User checkUser = iUserService.getOne(checkwrapper);
        if(checkUser!=null){
            resultMap.put("name","exists");
            return  jsonResult.toJSONString(resultMap);
        }
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.set("phone",number);
        userUpdateWrapper.eq("id",id);
        //修改用户手机号
        boolean b = iUserService.update(userUpdateWrapper);
        if(b==true){
            //修改成功则登陆(注销用户并将修改过的用户登录)
            User u = iUserService.getOne(checkwrapper);
            session.removeAttribute("user");
            session.setAttribute("user",u);
            resultMap.put("name","finish");
            return jsonResult.toJSONString(resultMap);
        }else{
            //修改出错
            resultMap.put("name","changewrong");
        }
        return jsonResult.toJSONString(resultMap);
    }

    //进入收藏夹页面
    @RequestMapping("/favorites")
    public String collection (HttpSession session,Integer userId){
        System.out.println("123123213");
        List<Product> favoritesProducts = iUserService.getAllProductsByFavorites(userId);
        session.setAttribute("favoritePro",favoritesProducts);
        return "home/favorites";
    }

    //添加进收藏夹
    @RequestMapping("/collect")
    @ResponseBody
    public String collect (int productId,int userId){
        boolean b = iUserService.addFavorites(productId, userId);
        return JSON.toJSONString(b);
    }
    //删除收藏商品
    @RequestMapping("/delFavorites")
    public String delFavorites (int id){
        boolean b = iUserService.deleteFavorites(id);
        return "home/favorites";
    }


    //进入绑定手机页面
    @RequestMapping("bindphone")
    public String bindphone (){
        return "/person/bindphone";
    }
    //进入改绑手机页面
    @RequestMapping("changephone")
    public String changephone (){
        return "/person/changephone";
    }
    //进入绑定邮箱页面
    @RequestMapping("bindemail")
    public String bindemail (){
        return "/person/bindemail";
    }
    //进入改绑邮箱页面
    @RequestMapping("changeemail")
    public String changeemail (){
        return "/person/changeemail";
    }

    //进入登录页
    @RequestMapping("/login")
    public String login(){
        return "home/login";
    }

    //进入个人信息页面
    @RequestMapping("/info")
    public String info(){
        return "person/information";
    }

    //进入安全设置页面
    @RequestMapping("/safetysetting")
    public String safetysetting() {
        return "/person/safety";
    }
    //进入修改密码页面
    @RequestMapping("/password")
    public String password() {
        return "/person/password";
    }

    //绑定用户邮箱
    @RequestMapping("bindemailreq")
    @ResponseBody
    public String bindemailreq (){
        return "/person/bindphone";
    }

    //改绑用户邮箱
    @RequestMapping("changeemailreq")
    @ResponseBody
    public String changeemailreq (){
        return "/person/bindphone";
    }
}
