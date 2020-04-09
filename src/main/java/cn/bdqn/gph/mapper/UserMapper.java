package cn.bdqn.gph.mapper;

import cn.bdqn.gph.entity.Product;
import cn.bdqn.gph.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
@Component
public interface UserMapper extends BaseMapper<User> {
    List<Product> selectAllProducts();
    //按手机号登录
    User selectUserByPhoneAndPwd(@RequestParam("loginmode")String loginmode, @RequestParam("userPassword")String userPassword);
    //按邮箱号登录
    User selectUserByEmailAndPwd(@RequestParam("loginmode")String loginmode,@RequestParam("userPassword")String userPassword);
    //用手机号注册
    int insertUserByPhone(@RequestParam("registmode")String registmode,@RequestParam("userPassword")String userPassword);
    //用邮箱号注册
    int insertUserByEmail(@RequestParam("registmode")String registmode,@RequestParam("userPassword")String userPassword);
    //按注册方式查询用户(注册完登录使用)
    User selectUserByPhoneRegist(String registmode);
    //按注册方式查询用户(注册完登录使用)
    User selectUserByEmailRegist(String registmode);
    //修改用户基本信息
    int modifyUserByInfo(User user);
    //修改用户密码
    int modifyUserPassword(@RequestParam("id")int id,@RequestParam("userPassword")String userPassword,@RequestParam("newPassword")String newPassword);
    //根据用户id查询收藏夹中的商品
    List<Product> selectAllProductsByFavorites(int id);
    //添加收藏夹
    int insertFavorites(@RequestParam("productId")int productId,@RequestParam("userId")int userId);
    //删除收藏夹商品
    int delFavorites(int id);


}
