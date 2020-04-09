package cn.bdqn.gph.mapper;

import cn.bdqn.gph.entity.Product;
import cn.bdqn.gph.entity.ProductCategory;
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

public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {
    List<ProductCategory> listCategory();
    List<ProductCategory> cateList1();

    //更多商品分页
    List<Product> getProByPage(@Param("pageNo") int pageNo,@Param("pageSize") int pageSize,@Param("categoryLevel1Id") Integer categoryLevel1Id);
    int getCount(@Param("categoryLevel1Id") Integer categoryLevel1Id);


    //三级菜单下的商品分页
    List<Product> getProByPageAndThree(@Param("pageNo") int pageNo,@Param("pageSize") int pageSize,@Param("categoryLevel3Id") Integer categoryLevel3Id);
    int getCountByThree(@Param("categoryLevel3Id") Integer categoryLevel3Id);
}
