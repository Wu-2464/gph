package cn.bdqn.gph.controller;


import cn.bdqn.gph.entity.*;
import cn.bdqn.gph.service.IProductService;
import cn.bdqn.gph.service.IUseraddressService;
import cn.bdqn.gph.service.impl.OrderDetailServiceImpl;
import cn.bdqn.gph.service.impl.OrderServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
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
//@RequestMapping("/shopping-car")
public class ShoppingCarController {

    @Resource(name = "orderDeService")
    private OrderDetailServiceImpl ods;
    @Resource(name = "orderService")
    private OrderServiceImpl os;
    @Resource(name = "iUseraddressService")
    private IUseraddressService ius;
    @Resource(name = "proServive")
    private IProductService ips;
    @RequestMapping("/shopCart")
    public String shopCart(){
        return "home/shopCart";
    }

    /**
     * 删除
     *
     * @param request
     * @return
     */
    @RequestMapping("/delinfo")
    public String delInfo(@RequestParam("index") int index,HttpServletRequest request){
        ShoppingCar car = getshoppingCar(request);
        index = Integer.parseInt(request.getParameter("index"));
        int num = car.getCarItems().get(index).getNum();
        float price = car.getCarItems().get(index).getProInfo().getPrice();
        car.setPrice(car.getPrice()-(num*price));
        car.delete(index);
        return "redirect:shopCart";
    }
    @RequestMapping("/addCar")
    @ResponseBody
    public String addCar(HttpServletRequest request){

        boolean flag = true;
        int num = 1;
        String id = request.getParameter("id");
        String numSize = request.getParameter("numSize");
        if(numSize != null){
            num = Integer.parseInt(numSize);
        }
        Product pro = ips.getProById(Integer.parseInt(id));

        if(num>pro.getStock()){
            flag = false;
        }
        ShoppingCar car = getshoppingCar(request);
        flag = car.addItems(pro,num);

        float p = car.getPrice()+(pro.getPrice()*num);
        DecimalFormat df = new DecimalFormat("#.##");
        df.format(p);
        if(flag) {
            car.setPrice(p);
        }

        return JSONArray.toJSONString(flag);
    }
    public ShoppingCar getshoppingCar(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ShoppingCar car =(ShoppingCar) session.getAttribute("car");
        if(car==null){
            car = new ShoppingCar();
            session.setAttribute("car", car);
        }
        return car;
    }

    /**
     * 支付成功跳转页面
     */
    @RequestMapping("/success")
    public String success(){
        return "home/success";
    }

    @RequestMapping("/adr")
    public String adr(Integer userId,HttpSession session){
        QueryWrapper<Useraddress> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId",userId);
        List<Useraddress> list = ius.list(queryWrapper);
        session.setAttribute("alist",list.get(0));
        return "home/success";
    }

    /**
     * 结算时显示用户地址
     * @param userId
     * @param session
     * @return
     */
    @RequestMapping("/getAddress")
    public String getAdd(Integer userId,HttpSession session){
        QueryWrapper<Useraddress> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId",userId);
        List<Useraddress> useraddressList = ius.list(queryWrapper);
        session.setAttribute("uaList",useraddressList);
        return "home/pay";
    }


    @RequestMapping("/addOrder")
    @ResponseBody       /*,float cost*/
    public String order(Integer userId,String userName,@RequestParam("cost") Float cost,HttpServletRequest request,HttpSession session){
        System.out.print("cost:"+cost);
 /*       String cost = request.getParameter("cost");*/
//        float price = Float.valueOf(cost);
        Order order = new Order();
        OrderDetail orderDe = new OrderDetail();
        order.setUserId(userId);
        order.setUserName(userName);
        order.setType(1);
        order.setIsDelete(0);
        order.setCost(cost);
        int ss = (int)(Math.random()*1000000);
        order.setOrderNum("1651846135165orGPH"+ss);
        order.setTransactionDate(new Date());
        boolean flag = os.save(order);
        if(flag==true){
            orderDe.setOrderId(order.getId());
            ShoppingCar scar = getshoppingCar(request);
            for(int i=0;i<scar.getCarItems().size();i++){
                ShoppingCarItems items = scar.getCarItems().get(i);
                orderDe.setProductId(items.getProInfo().getId());
                orderDe.setNum(items.getNum());
                orderDe.setCost((float) (items.getNum())*(items.getProInfo().getPrice()));
                ods.save(orderDe);
                ods.updateProInfo(items.getProInfo().getId(),items.getNum());
            }
            System.out.print("cost:"+order.getCost());
            session.setAttribute("myOrder",order);
            session.removeAttribute("car");
        }else{
            flag = false;
        }
        return JSONArray.toJSONString(flag);
    }
}
