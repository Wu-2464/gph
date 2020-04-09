package cn.bdqn.gph.service.impl;

import cn.bdqn.gph.entity.Useraddress;
import cn.bdqn.gph.mapper.UseraddressMapper;
import cn.bdqn.gph.service.IUseraddressService;
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
@Service("iUseraddressService")
public class UseraddressServiceImpl extends ServiceImpl<UseraddressMapper, Useraddress> implements IUseraddressService {
    @Resource
    private UseraddressMapper useraddressMapper;

    @Override
    public int Insertaddress(Useraddress useraddress) {
        return useraddressMapper.Addaddress(useraddress);
    }

    @Override
    public List<Useraddress> findAll(Integer userId) {
        return useraddressMapper.selectAll(userId);
    }


    @Override
    public int modifyUserInfo(Useraddress useraddress) {
        return useraddressMapper.updateUserInfo(useraddress);
    }

    @Override
    public int deleteUserAddress(Integer id) {
        return useraddressMapper.deleteUserAddress(id);
    }

}
