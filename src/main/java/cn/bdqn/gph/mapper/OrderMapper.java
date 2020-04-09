package cn.bdqn.gph.mapper;

import cn.bdqn.gph.entity.Order;
import cn.bdqn.gph.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
public interface OrderMapper extends BaseMapper<Order> {
    //查询订单下的商品集合
    List<Product> proListByOrderId(@Param("orderId") Integer orderId);
    //根据用户id查询订单
    List<Order> getOrderByUid(@Param("uid") Integer uid);

}
