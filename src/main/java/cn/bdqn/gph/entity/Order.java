package cn.bdqn.gph.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;
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
@TableName("gph_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("userId")
    private Integer userId;

    /**
     * 0-待付款，1-待发货，2-待收货，3-已收货
     */
    private Integer type;

    /**
     * 订单编号
     */
    @TableField("orderNum")
    private String orderNum;

/*
    */
/**
     * 订货号
     *//*

    @TableField("orderProNum")
    private Integer orderProNum;
*/

    /**
     * 交易日期
     */
    @TableField("transactionDate")
    private Date transactionDate;

    @TableField("userName")
    private String userName;

/*
    @TableField("productId")
    private Integer productId;
*/

    @TableField("cost")
    private float cost;

    @TableField("isDelete")
    private Integer isDelete;

    private List<Product> orderList;	//订单信息列表

    public List<Product> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Product> orderList) {
        this.orderList = orderList;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Order() {
    }

    public Order(Integer id, Integer userId, Integer type, String orderNum, Date transactionDate, String userName, float cost, Integer isDelete, List<Product> orderList) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.orderNum = orderNum;
        this.transactionDate = transactionDate;
        this.userName = userName;
        this.cost = cost;
        this.isDelete = isDelete;
        this.orderList = orderList;
    }
}
