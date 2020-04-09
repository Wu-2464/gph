package cn.bdqn.gph.mapper;

import cn.bdqn.gph.entity.Useraddress;
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
public interface UseraddressMapper extends BaseMapper<Useraddress> {
    int Addaddress(Useraddress useraddress);
    List<Useraddress> selectAll(@Param("userId") Integer userId);
    int updateUserInfo(Useraddress useraddress);
    int deleteUserAddress(@Param("id") Integer id);
}
