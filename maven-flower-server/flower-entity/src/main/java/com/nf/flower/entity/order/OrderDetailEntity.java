package com.nf.flower.entity.order;

import com.nf.flower.entity.commodity.FlowerinfoEntity;

import java.math.BigDecimal;

public class OrderDetailEntity {
    private Integer orderDetailId;
    private Integer orderMasterId;
    private Integer productCount;
    private BigDecimal productPrice;
    private Integer flowerId;

    private OrderMasterEntity orderMaster;
    private FlowerinfoEntity flowerInfo;

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(Integer flowerId) {
        this.flowerId = flowerId;
    }

    public Integer getOrderMasterId() {
        return orderMasterId;
    }

    public void setOrderMasterId(Integer orderMasterId) {
        this.orderMasterId = orderMasterId;
    }

    public OrderMasterEntity getOrderMaster() {
        return orderMaster;
    }

    public void setOrderMaster(OrderMasterEntity orderMaster) {
        this.orderMaster = orderMaster;
    }

    public FlowerinfoEntity getFlowerInfo() {
        return flowerInfo;
    }

    public void setFlowerInfo(FlowerinfoEntity flowerInfo) {
        this.flowerInfo = flowerInfo;
    }
}
