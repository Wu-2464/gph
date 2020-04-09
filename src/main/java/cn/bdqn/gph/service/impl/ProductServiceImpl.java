package cn.bdqn.gph.service.impl;

import cn.bdqn.gph.entity.Brand;
import cn.bdqn.gph.entity.ImgFile;
import cn.bdqn.gph.entity.Product;
import cn.bdqn.gph.entity.ProductCategory;
import cn.bdqn.gph.mapper.ProductMapper;
import cn.bdqn.gph.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
@Service("proServive")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Resource
    private ProductMapper proMapper;


    @Override
    public List<ImgFile> selectPic(Integer pId) {
        return proMapper.selectPic(pId);
    }

    @Override
    public List<Product> listByPrice() {
        return proMapper.listByPrice();
    }

    @Override
    public List<Product> getListBy1() {
        return proMapper.getListBy1();
    }

    @Override
    public List<Product> getListBy2() {
        return proMapper.getListBy2();
    }

    @Override
    public List<Product> getListBy3() {
        return proMapper.getListBy3();
    }

    @Override
    public List<Product> getListBy4() {
        return proMapper.getListBy4();
    }

    @Override
    public List<Product> getListBy5() {
        return proMapper.getListBy5();
    }

    @Override
    public List<Product> getListBy6() {
        return proMapper.getListBy6();
    }

    @Override
    public List<Product> getListBy7() {
        return proMapper.getListBy7();
    }

    @Override
    public List<Product> getListBy8() {
        return proMapper.getListBy8();
    }

    @Override
    public List<Product> getListBy9() {
        return proMapper.getListBy9();
    }

//    @Override
//    public List<Product> getListByCate1(List<Integer> item) {
//        return proMapper.getListByCate1(item);
//    }

    @Override
    public int findNewInfo() {
        return proMapper.selectNewInfo();
    }

    @Override
    public int insertProduct(Product product) {
        return proMapper.AddProduct(product);
    }

    @Override
    public int insertImg(ImgFile imgFile) {
        return proMapper.AddImg(imgFile);
    }

    @Override
    public List<ProductCategory> findNameByParentId(int parentId) {
        return proMapper.selectNameByParentId(parentId);
    }

    @Override
    public List<Brand> findBrandName() {
        return proMapper.selectBrandName();
    }

    @Override
    public List<Product> getProByName(int pageNo, int pageSize, String proName) {
        return proMapper.getProByName(pageNo,pageSize,proName);
    }

    @Override
    public int getCountByName(String proName) {
        return proMapper.getCountByName(proName);
    }
    @Override
    public List<Product> getAllByL3Id() {
        return proMapper.selectAllByL3Id();
    }

    @Override
    public Product getProById(Integer proId) {
        return proMapper.getProById(proId);
    }

}
