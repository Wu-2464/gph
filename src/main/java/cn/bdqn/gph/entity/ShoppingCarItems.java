package cn.bdqn.gph.entity;

import java.io.Serializable;

public class ShoppingCarItems implements Serializable {
    private Product proInfo;	//商品详情
    private int num;            //购买数量

    public Product getProInfo() {
        return proInfo;
    }

    public void setProInfo(Product proInfo) {
        this.proInfo = proInfo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ShoppingCarItems() {
    }

    public ShoppingCarItems(Product proInfo, int num) {
        this.proInfo = proInfo;
        this.num = num;
    }
}
