package com.nf.flower.dao;

import com.nf.flower.entity.order.OrderDetailEntity;
import com.nf.flower.entity.order.OrderMasterEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoMapper {
    int addOrderMaster(OrderMasterEntity orderMasterEntity);

    int addOrderDetails(@Param("orderMasterId") int orderMasterId, @Param("orders") List<OrderDetailEntity> orderDetails);

    List<OrderMasterEntity> queryOrderInfoAll(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("status") int status);

    List<OrderMasterEntity> queryOrderInfoByUserId(int userId);

    List<OrderDetailEntity> queryOrderDetailByOrderMasterId(int id);
}
