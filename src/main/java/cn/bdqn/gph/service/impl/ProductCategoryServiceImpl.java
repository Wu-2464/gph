package cn.bdqn.gph.service.impl;

import cn.bdqn.gph.entity.Product;
import cn.bdqn.gph.entity.ProductCategory;
import cn.bdqn.gph.mapper.ProductCategoryMapper;
import cn.bdqn.gph.service.IProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
@Service("pcService")
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements IProductCategoryService {

    @Resource
    private ProductCategoryMapper pcMapper;

    @Override
    public List<ProductCategory> listCategory() {
        return pcMapper.listCategory();
    }

    @Override
    public List<ProductCategory> cateList1() {
        return pcMapper.cateList1();
    }

    @Override
    public int getCount(Integer categoryLevel1Id) {
        return pcMapper.getCount(categoryLevel1Id);
    }

    @Override
    public List<Product> getProByPage(int pageNo, int pageSize, Integer categoryLevel1Id) {
        return pcMapper.getProByPage(pageNo,pageSize,categoryLevel1Id);
    }

    @Override
    public List<Product> getProByPageAndThree(int pageNo, int pageSize, Integer categoryLevel3Id) {
        return pcMapper.getProByPageAndThree(pageNo,pageSize,categoryLevel3Id);
    }

    @Override
    public int getCountByThree(Integer categoryLevel3Id) {
        return pcMapper.getCountByThree(categoryLevel3Id);
    }
}
