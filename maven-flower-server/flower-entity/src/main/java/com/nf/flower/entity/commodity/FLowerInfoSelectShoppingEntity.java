package com.nf.flower.entity.commodity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.nf.flower.entity.UserInfoEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FLowerInfoSelectShoppingEntity {
    private Integer cartId;
    private Integer userId;
    private Integer flowerId;
    private Integer productAmount;
    private BigDecimal price;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime addTime;

    private UserInfoEntity userInfoEntity;
    private FlowerinfoEntity flowerinfoEntity;

    public FLowerInfoSelectShoppingEntity() {

    }

    public FLowerInfoSelectShoppingEntity(Integer cartId, Integer userId, Integer flowerId, Integer productAmount, BigDecimal price, LocalDateTime addTime, UserInfoEntity userInfoEntity, FlowerinfoEntity flowerinfoEntity) {
        this.cartId = cartId;
        this.userId = userId;
        this.flowerId = flowerId;
        this.productAmount = productAmount;
        this.price = price;
        this.addTime = addTime;
        this.userInfoEntity = userInfoEntity;
        this.flowerinfoEntity = flowerinfoEntity;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(Integer flowerId) {
        this.flowerId = flowerId;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public UserInfoEntity getUserInfoEntity() {
        return userInfoEntity;
    }

    public void setUserInfoEntity(UserInfoEntity userInfoEntity) {
        this.userInfoEntity = userInfoEntity;
    }

    public FlowerinfoEntity getFlowerinfoEntity() {
        return flowerinfoEntity;
    }

    public void setFlowerinfoEntity(FlowerinfoEntity flowerinfoEntity) {
        this.flowerinfoEntity = flowerinfoEntity;
    }

    @Override
    public String toString() {
        return "FLowerInfoSelectShoppingEntity{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", flowerId=" + flowerId +
                ", productAmount=" + productAmount +
                ", price=" + price +
                ", addTime=" + addTime +
                ", userInfoEntity=" + userInfoEntity +
                ", flowerinfoEntity=" + flowerinfoEntity +
                '}';
    }
}
