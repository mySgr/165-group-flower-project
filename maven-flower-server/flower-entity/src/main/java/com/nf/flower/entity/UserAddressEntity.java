package com.nf.flower.entity;

public class UserAddressEntity {
    private Integer addressId;
    private Integer userId;
    private String receiver;
    private String phone;
    private String address;

    private UserInfoEntity userInfoEntity;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserInfoEntity getUserInfoEntity() {
        return userInfoEntity;
    }

    public void setUserInfoEntity(UserInfoEntity userInfoEntity) {
        this.userInfoEntity = userInfoEntity;
    }


    @Override
    public String toString() {
        return "UserAddressEntity{" +
                "addressId=" + addressId +
                ", userId=" + userId +
                ", receiver='" + receiver + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userInfoEntity=" + userInfoEntity +
                '}';
    }
}
