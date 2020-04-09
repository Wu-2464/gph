package cn.bdqn.gph.service;

import cn.bdqn.gph.entity.Product;
import cn.bdqn.gph.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */

public interface IProductCategoryService extends IService<ProductCategory> {
    List<ProductCategory> listCategory();
    List<ProductCategory> cateList1();
    int getCount(Integer categoryLevel1Id);
    List<Product> getProByPage(int pageNo,int pageSize,Integer categoryLevel1Id);

    List<Product> getProByPageAndThree(int pageNo,int pageSize,Integer categoryLevel3Id);
    int getCountByThree(Integer categoryLevel3Id);
}
