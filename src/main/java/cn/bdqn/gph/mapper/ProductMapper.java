package cn.bdqn.gph.mapper;

import cn.bdqn.gph.entity.Brand;
import cn.bdqn.gph.entity.ImgFile;
import cn.bdqn.gph.entity.Product;
import cn.bdqn.gph.entity.ProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
public interface ProductMapper extends BaseMapper<Product> {
    //查询图片根据商品id
    List<ImgFile> selectPic(@Param("pId") Integer pId);
/*    List<Product> getListByCate1(List<Integer> item);*/
    //今日推荐
    List<Product> listByPrice();
    List<Product> getListBy1();
    List<Product> getListBy2();
    List<Product> getListBy3();
    List<Product> getListBy4();
    List<Product> getListBy5();
    List<Product> getListBy6();
    List<Product> getListBy7();
    List<Product> getListBy8();
    List<Product> getListBy9();

    //添加商品
    int AddProduct(Product product);


    int selectNewInfo();

    //查询商品品牌名称
    List<Brand> selectBrandName();
    //查询分类名称
    List<ProductCategory> selectNameByParentId(int parentId);

    //上传图片
    int AddImg(ImgFile imgFile);

    //根据名称模糊查询
    List<Product> getProByName(@Param("pageNo") int pageNo,@Param("pageSize") int pageSize,@Param("proName")String proName);
    int getCountByName(@Param("proName") String proName);

    //根据三级id查询所有商品
    List<Product>  selectAllByL3Id();

    //根据商品id查询商品
    Product getProById(@Param("proId") Integer proId);
}
