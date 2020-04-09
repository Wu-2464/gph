package cn.bdqn.gph.entity;

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
@TableName("gph_useraddress")
public class Useraddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    /**
     * 收货人
     */
    @TableField("userName")
    private String userName;

    private long phone;

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    /**
     * 所在地区
     */
    private String area;

    private String address;

    /**
     * 备注
     */
/*    private String remark;*/

    /**
     * 用户id
     */
    @TableField("userId")
    private int userId;

    @TableField("addressDetail")
    private String addressDetail;

    private String beat;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBeat() {
        return beat;
    }

    public void setBeat(String beat) {
        this.beat = beat;
    }

    public Useraddress() {
    }

    public Useraddress(int id, String userName, int phone, String area, String address, int userId, String addressDetail, String beat) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.area = area;
        this.address = address;
        this.userId = userId;
        this.addressDetail = addressDetail;
        this.beat = beat;
    }
}
