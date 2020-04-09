package cn.bdqn.gph.service;

import cn.bdqn.gph.entity.Product;
import cn.bdqn.gph.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
public interface IUserService extends IService<User> {
    List<Product> getAllProducts();
    //按登录方式登录
    User getUserByLoginModeAndPwd(@RequestParam("loginmode")String loginmode, @RequestParam("userPassword")String userPassword);
    //按注册方式注册
    boolean addUserByRegistModeAndPwd(@RequestParam("registmode")String registmode,@RequestParam("userPassword")String userPassword);
    //注册完查询用户并登录
    User getUserByRegistMode(String registmode);
    //修改用户信息
    boolean changeUserByInfo(User user);
    //修改用户密码
    boolean changeUserPassword(@RequestParam("id")int id,@RequestParam("userPassword")String userPassword,@RequestParam("newPassword")String newPassword);

    //查询用户收藏夹的所有商品
    List<Product> getAllProductsByFavorites(int id);


    //添加收藏夹
    boolean addFavorites(@RequestParam("productId")int productId,@RequestParam("userId")int userId);
    //删除收藏夹商品
    boolean deleteFavorites(int id);


}
