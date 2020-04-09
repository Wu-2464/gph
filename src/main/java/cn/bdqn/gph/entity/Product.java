package cn.bdqn.gph.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
@TableName("gph_product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("productName")
    private String productName;

    private String description;

    private Float price;

    /**
     * 库存
     */
    private Integer stock;

//    private Integer type;

    @TableField("categoryLevel1Id")
    private Integer categoryLevel1Id;

    @TableField("categoryLevel2Id")
    private Integer categoryLevel2Id;

    @TableField("categoryLevel3Id")
    private Integer categoryLevel3Id;

    private BigDecimal weight;

    /**
     * 包装数量
     */
    private String num;

    /**
     * 货期
     */
    private String delivery;

    /**
     * 商品状态
     */
    private int status;

    /**
     * 收藏id
     */
    private Integer favoriteId;

    public Integer getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Product() {
    }

    public Product(Integer id, String productName, String description, Float price, Integer stock, int status, Integer categoryLevel1Id, Integer categoryLevel2Id, Integer categoryLevel3Id, BigDecimal weight, String num, String delivery, String orderNumber, String productModel, Integer brandId) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.status = status;
        this.categoryLevel1Id = categoryLevel1Id;
        this.categoryLevel2Id = categoryLevel2Id;
        this.categoryLevel3Id = categoryLevel3Id;
        this.weight = weight;
        this.num = num;
        this.delivery = delivery;
        this.orderNumber = orderNumber;
        this.productModel = productModel;
        this.brandId = brandId;
    }

    /**
     * 订货号
     */
    @TableField("orderNumber")
    private String orderNumber;

    /**
     * 商品型号
     */
    @TableField("productModel")
    private String productModel;

    /**
     * 品牌id
     */
    @TableField("brandId")
    private Integer brandId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getCategoryLevel1Id() {
        return categoryLevel1Id;
    }

    public void setCategoryLevel1Id(Integer categoryLevel1Id) {
        this.categoryLevel1Id = categoryLevel1Id;
    }

    public Integer getCategoryLevel2Id() {
        return categoryLevel2Id;
    }

    public void setCategoryLevel2Id(Integer categoryLevel2Id) {
        this.categoryLevel2Id = categoryLevel2Id;
    }

    public Integer getCategoryLevel3Id() {
        return categoryLevel3Id;
    }

    public void setCategoryLevel3Id(Integer categoryLevel3Id) {
        this.categoryLevel3Id = categoryLevel3Id;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
