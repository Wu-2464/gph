package cn.bdqn.gph.service;

import cn.bdqn.gph.entity.OrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
public interface IOrderDetailService extends IService<OrderDetail> {
    int updateProInfo(int id,int num);
}
