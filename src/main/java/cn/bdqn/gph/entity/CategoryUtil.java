package cn.bdqn.gph.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 三级分类util
 */
public class CategoryUtil {


    public List<ProductCategory> common;

    public List<ProductCategory> list = new ArrayList<ProductCategory>();

    List<Product> list1 = new ArrayList<Product>();

    /**
     * 创建三级菜单
     * @param categories
     * @return
     */
    public List<ProductCategory> createCategory(List<ProductCategory> categories ) {
        this.common = categories;
        for (ProductCategory c : categories){
            ProductCategory category = new ProductCategory();
            if(c.getParentId() == 0){
                category.setParentId(c.getParentId());
                category.setId(c.getId());
                category.setName(c.getName());
                category.setSubCategorys(treeChild(c.getId()));
                list.add(category);
            }
        }
        return list;
    }

    /**
     * 分类子类
     * @param id
     * @return
     */
    public List<ProductCategory> treeChild(Integer id){
        List<ProductCategory> list = new ArrayList<ProductCategory>();
        for(ProductCategory c : common){
            ProductCategory category = new ProductCategory();
            if(c.getParentId() == id){
                category.setParentId(c.getParentId());
                category.setId(c.getId());
                category.setName(c.getName());
                category.setSubCategorys(treeChild(c.getId()));//递归循环
                list.add(category);
            }
        }
        return list;
    }
}