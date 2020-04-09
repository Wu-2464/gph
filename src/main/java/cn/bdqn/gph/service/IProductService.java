package cn.bdqn.gph.service;

import cn.bdqn.gph.entity.Brand;
import cn.bdqn.gph.entity.ImgFile;
import cn.bdqn.gph.entity.Product;
import cn.bdqn.gph.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
public interface IProductService extends IService<Product> {
    List<ImgFile> selectPic(Integer pId);
//    List<Product> getListByCate1(List<Integer> item);
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


    int findNewInfo();

    int insertProduct(Product product);

    int insertImg(ImgFile imgFile);
    List<ProductCategory> findNameByParentId(int parentId);
    List<Brand> findBrandName();

    List<Product> getProByName(int pageNo,int pageSize,String proName);
    int getCountByName(String proName);
    //根据三级id查询所有商品
    List<Product>  getAllByL3Id();
    //根据商品id查询商品
    Product getProById(Integer proId);
}
