package com.nf.flower.vo;

import com.nf.flower.entity.order.OrderDetailEntity;

import java.math.BigDecimal;
import java.util.List;

public class OrderVo {
    private Integer userId;
    private Integer addressId;
    private Integer paymentMethod;
    private BigDecimal orderMoney;
    private List<OrderDetailEntity> goods;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public List<OrderDetailEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<OrderDetailEntity> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "userId=" + userId +
                ", addressId=" + addressId +
                ", paymentMethod=" + paymentMethod +
                ", orderMoney=" + orderMoney +
                ", goods=" + goods +
                '}';
    }
}
