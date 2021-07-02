package com.nf.flower.entity.order;

import com.nf.flower.entity.UserAddressEntity;
import com.nf.flower.entity.UserInfoEntity;
import com.nf.flower.entity.UserMemberEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderMasterEntity {
    private Integer orderMasterId;
    private Integer paymentMethod;
    private LocalDateTime createTime;
    private LocalDateTime payTime;
    private LocalDateTime shippingTime;
    private LocalDateTime receivedTime;
    private Integer orderStatus;
    private Integer orderPoint;
    private BigDecimal orderMoney;
    private Integer userId;
    private Integer memberId;
    private  Integer addressId;

    private UserInfoEntity userInfo;
    private UserMemberEntity userMember;
    private UserAddressEntity userAddress;


    public Integer getOrderMasterId() {
        return orderMasterId;
    }

    public void setOrderMasterId(Integer orderMasterId) {
        this.orderMasterId = orderMasterId;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public LocalDateTime getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(LocalDateTime shippingTime) {
        this.shippingTime = shippingTime;
    }

    public LocalDateTime getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(LocalDateTime receivedTime) {
        this.receivedTime = receivedTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderPoint() {
        return orderPoint;
    }

    public void setOrderPoint(Integer orderPoint) {
        this.orderPoint = orderPoint;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public UserInfoEntity getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoEntity userInfo) {
        this.userInfo = userInfo;
    }

    public UserMemberEntity getUserMember() {
        return userMember;
    }

    public void setUserMember(UserMemberEntity userMember) {
        this.userMember = userMember;
    }

    public UserAddressEntity getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddressEntity userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "OrderMasterEntity{" +
                "orderMasterId=" + orderMasterId +
                ", paymentMethod=" + paymentMethod +
                ", createTime=" + createTime +
                ", payTime=" + payTime +
                ", shippingTime=" + shippingTime +
                ", receivedTime=" + receivedTime +
                ", orderStatus=" + orderStatus +
                ", orderPoint=" + orderPoint +
                ", orderMoney=" + orderMoney +
                ", userId=" + userId +
                ", memberId=" + memberId +
                ", addressId=" + addressId +
                ", userInfo=" + userInfo +
                ", userMember=" + userMember +
                ", userAddress=" + userAddress +
                '}';
    }
}
