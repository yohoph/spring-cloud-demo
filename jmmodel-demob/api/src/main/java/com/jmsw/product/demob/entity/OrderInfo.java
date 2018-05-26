package com.jmsw.product.demob.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/5/25 11:40
 * @Description 订单信息
 */
public class OrderInfo implements Serializable{


    private String orderId;

    private String userId;

    private Long price;

    private String productId;

    private Date createTime;

    private Date updateTime;

    public OrderInfo(){

    }

    public OrderInfo(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
