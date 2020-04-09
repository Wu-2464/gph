package cn.bdqn.gph.service.impl;

import cn.bdqn.gph.entity.Order;
import cn.bdqn.gph.entity.Product;
import cn.bdqn.gph.mapper.OrderMapper;
import cn.bdqn.gph.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Resource
    private OrderMapper om;

    @Override
    public List<Product> proListByOrderId(Integer orderId) {
        return om.proListByOrderId(orderId);
    }

    @Override
    public List<Order> getOrderByUid(Integer uid) {
        return om.getOrderByUid(uid);
    }
}
