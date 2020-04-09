package cn.bdqn.gph.mapper;

import cn.bdqn.gph.entity.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
    int updateProInfo(@Param("id") int id,@Param("num") int num);
}
