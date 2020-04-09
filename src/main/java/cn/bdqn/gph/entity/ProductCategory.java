package cn.bdqn.gph.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("gph_product_category")
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getLevel1Type() {
        return level1Type;
    }

    public void setLevel1Type(String level1Type) {
        this.level1Type = level1Type;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public List<ProductCategory> getSubCategorys() {
        return subCategorys;
    }

    public void setSubCategorys(List<ProductCategory> subCategorys) {
        this.subCategorys = subCategorys;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    @TableField("parentId")
    private Integer parentId;

    /**
     * 等级一类型
     */
    @TableField("level1Type")
    private String level1Type;

    /**
     * 分类类型
     */
    @TableField("categoryType")
    private Integer categoryType;

    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 商品分类集合
     */
    private List<ProductCategory> subCategorys;

    private List<Product> proList;

    public List<Product> getProList() {
        return proList;
    }

    public void setProList(List<Product> proList) {
        this.proList = proList;
    }
}
