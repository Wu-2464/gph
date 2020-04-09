package cn.bdqn.gph.controller;


import cn.bdqn.gph.entity.Order;
import cn.bdqn.gph.entity.OrderDetail;
import cn.bdqn.gph.entity.Product;
import cn.bdqn.gph.service.impl.OrderServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
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
//@RequestMapping("/order")
public class OrderController {

    @Resource(name = "orderService")
    private OrderServiceImpl orderService;

    @RequestMapping("/allOrderByUid")
    public String order(HttpSession session,Integer userId,Integer userRole){

        List<Order> orderList = new ArrayList<Order>();
        Order order = null;
        if(userId!=null){
             orderList = orderService.getOrderByUid(userId);
        }
        for(int i=0;i<orderList.size();i++){
            order = orderList.get(i);
            List<Product> proList = orderService.proListByOrderId(order.getId());
            order.setOrderList(proList);
        }
        session.setAttribute("allOrderList",orderList);
        return "person/order";
    }

}
