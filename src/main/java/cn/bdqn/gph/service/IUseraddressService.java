package cn.bdqn.gph.service;

import cn.bdqn.gph.entity.Useraddress;
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
public interface IUseraddressService extends IService<Useraddress> {
    int Insertaddress(Useraddress useraddress);
    List<Useraddress> findAll(Integer userId);
    int modifyUserInfo(Useraddress useraddress);
    int deleteUserAddress(Integer id);
}
