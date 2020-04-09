package cn.bdqn.gph.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.ArrayList;
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
@TableName("gph_shopping_car")
public class ShoppingCar implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("productId")
    private Integer productId;

    @TableField("userId")
    private Integer userId;

    private String name;

    private float price;

    private int num;

    public List<ShoppingCarItems> getCarItems() {
        return carItems;
    }

    public void setCarItems(List<ShoppingCarItems> carItems) {
        this.carItems = carItems;
    }

    private List<ShoppingCarItems> carItems;	//购物车具体信息

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ShoppingCar() {
    }

    public ShoppingCar(Integer id, Integer productId, Integer userId, String name, Float price, int num, List<ShoppingCarItems> carItems) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.name = name;
        this.price = price;
        this.num = num;
        this.carItems = carItems;
    }
    public boolean addItems(Product pro,int num){
        boolean flag=false;//判断商品是否存在
        if(carItems==null){
            carItems=new ArrayList<ShoppingCarItems>();
        }
        for (int i = 0; i < carItems.size(); i++) {
            if(pro.getId()==carItems.get(i).getProInfo().getId()){//如果存在该商品
                if(carItems.get(i).getNum()+num<pro.getStock()){	//如果购买数量小于商品库存
                    carItems.get(i).setNum(carItems.get(i).getNum()+num);//则当前商品数量为购物车数量
                    flag=true;
                }else{
                    return false;
                }
            }
        }
        if(!flag){
            carItems.add(new ShoppingCarItems(pro, num));
        }
        return true;
    }
    public void updateNum(int index,Integer Num){
        carItems.get(index).setNum(Num);
    }

    public void delete(int index){
        carItems.remove(index);
    }
}
