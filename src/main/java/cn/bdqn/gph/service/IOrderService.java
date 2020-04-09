package cn.bdqn.gph.service;

import cn.bdqn.gph.entity.Order;
import cn.bdqn.gph.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
public interface IOrderService extends IService<Order> {
    List<Product> proListByOrderId(Integer orderId);
    List<Order> getOrderByUid(Integer uid);
}
