package cn.bdqn.gph.service.impl;

import cn.bdqn.gph.entity.Product;
import cn.bdqn.gph.entity.User;
import cn.bdqn.gph.mapper.UserMapper;
import cn.bdqn.gph.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Product> getAllProducts() {
        return userMapper.selectAllProducts();
    }

    //判断登录方式为手机号登录或邮箱登录
    @Override
    public User getUserByLoginModeAndPwd(@RequestParam("loginmode") String loginmode, @RequestParam("userPassword") String userPassword) {
        //判断是否为邮箱登录，否则按手机登录
        if (loginmode.contains("@")) {
            return userMapper.selectUserByEmailAndPwd(loginmode, userPassword);
        }
        return userMapper.selectUserByPhoneAndPwd(loginmode, userPassword);
    }

    //按注册方式判断注册方法,并按方法返回值返回布尔值
    @Override
    public boolean addUserByRegistModeAndPwd(@RequestParam("registmode") String registmode, @RequestParam("userPassword") String userPassword) {
        boolean b =false;
        if (registmode.contains("@")) {
            int i = userMapper.insertUserByEmail(registmode, userPassword);
            if (i > 0) {
                b=true;
                return b;
            } else {
                b=false;
                return b;
            }
        }
        int i1 = userMapper.insertUserByPhone(registmode, userPassword);
        if (i1 > 0) {
            b=true;
            return b;
        } else {
            b=false;
            return b;
        }
    }

    @Override
    public User getUserByRegistMode(String registmode) {
        if(registmode.contains("@")){
            return userMapper.selectUserByEmailRegist(registmode);
        }
        return userMapper.selectUserByPhoneRegist(registmode);
    }
    @Override
    public boolean changeUserByInfo(User user) {
        int i = userMapper.modifyUserByInfo(user);
        if(i>0){return  true;}
        return false;
    }

    @Override
    public boolean changeUserPassword(int id, String userPassword, String newPassword) {
        int i = userMapper.modifyUserPassword(id, userPassword, newPassword);
        if(i>0){return true;}
        return false;
    }


    @Override
    public boolean addFavorites(int productId, int userId) {
        int i = userMapper.insertFavorites(productId, userId);
        if(i>0){return true;}
        return false;
    }

    @Override
    public boolean deleteFavorites(int id) {
        int i = userMapper.delFavorites(id);
        if(i>0){return true;}
        return false;
    }

    @Override
    public List<Product> getAllProductsByFavorites(int id) {
        return userMapper.selectAllProductsByFavorites(id);
    }



}
