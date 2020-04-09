package cn.bdqn.gph.service.impl;

import cn.bdqn.gph.entity.OrderDetail;
import cn.bdqn.gph.mapper.OrderDetailMapper;
import cn.bdqn.gph.service.IOrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
@Service("orderDeService")
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {

    @Resource
    private OrderDetailMapper odm;

    @Override
    public int updateProInfo(int id, int num) {
        return odm.updateProInfo(id,num);
    }
}
