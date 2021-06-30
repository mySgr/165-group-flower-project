package com.nf.flower.entity.commodity;

import java.math.BigDecimal;

public class CartItem {
    private Integer cartListId;
    private Integer cartMasterId;
    private Integer flowerId;

    private Integer cartCount;
    private BigDecimal cartPrice;
    private Integer cartStatus;

    private FlowerinfoEntity flower;

    public Integer getCartListId() {
        return cartListId;
    }

    public void setCartListId(Integer cartListId) {
        this.cartListId = cartListId;
    }

    public Integer getCartMasterId() {
        return cartMasterId;
    }

    public void setCartMasterId(Integer cartMasterId) {
        this.cartMasterId = cartMasterId;
    }

    public Integer getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(Integer flowerId) {
        this.flowerId = flowerId;
    }

    public Integer getCartCount() {
        return cartCount;
    }

    public void setCartCount(Integer cartCount) {
        this.cartCount = cartCount;
    }

    public BigDecimal getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(BigDecimal cartPrice) {
        this.cartPrice = cartPrice;
    }

    public FlowerinfoEntity getFlower() {
        return flower;
    }

    public void setFlower(FlowerinfoEntity flower) {
        this.flower = flower;
    }

    public Integer getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(Integer cartStatus) {
        this.cartStatus = cartStatus;

    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartListId=" + cartListId +
                ", cartMasterId=" + cartMasterId +
                ", flowerId=" + flowerId +
                ", cartCount=" + cartCount +
                ", cartPrice=" + cartPrice +
                ", cartStatus=" + cartStatus +
                ", flower=" + flower +
                '}';
    }
}
