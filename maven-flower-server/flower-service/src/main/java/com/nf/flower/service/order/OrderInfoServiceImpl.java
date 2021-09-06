package com.nf.flower.service.order;

import com.nf.flower.dao.OrderInfoMapper;
import com.nf.flower.entity.order.OrderDetailEntity;
import com.nf.flower.entity.order.OrderMasterEntity;
import com.nf.flower.util.MyBatisUtils;
import com.nf.flower.vo.OrderVo;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderInfoServiceImpl {

    private static OrderInfoServiceImpl orderInfoService = new OrderInfoServiceImpl();


    // 合并订单
    public int addOrder(OrderVo orderVo) {
        OrderInfoServiceImpl orderInfoService = new OrderInfoServiceImpl();
        int orderMasterId = orderInfoService.addOrderMaster(orderVo);
        orderInfoService.addOrderDetails(orderMasterId, orderVo.getGoods());
        return orderMasterId;
    }

    // 添加主订单
    // 返回主订单id
    private int addOrderMaster(OrderVo orderVo) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            OrderInfoMapper mapper = sqlSession.getMapper(OrderInfoMapper.class);

            // 创建主订单对象
            OrderMasterEntity orderMaster = new OrderMasterEntity();
            // 数据赋值
            orderMaster.setPaymentMethod(orderVo.getPaymentMethod());
            orderMaster.setCreateTime(LocalDateTime.now());
            orderMaster.setPayTime(LocalDateTime.now());
            orderMaster.setOrderStatus(2);
            orderMaster.setOrderPoint(0);
            orderMaster.setOrderMoney(orderVo.getOrderMoney());
            orderMaster.setUserId(orderVo.getUserId());
            orderMaster.setAddressId(orderVo.getAddressId());

            mapper.addOrderMaster(orderMaster);
            return orderMaster.getOrderMasterId();

        }

    }

    // 添加订单项
    private int addOrderDetails(Integer orderMasterId, List<OrderDetailEntity> orders) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            OrderInfoMapper mapper = sqlSession.getMapper(OrderInfoMapper.class);
            return mapper.addOrderDetails(orderMasterId, orders);
        }

    }

    // 查询全部订单
    public List<OrderMasterEntity> queryOrderInfoAll(int pageNum, int pageSize, int status) {

        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            OrderInfoMapper mapper = sqlSession.getMapper(OrderInfoMapper.class);
            List<OrderMasterEntity> orderMasterEntities = mapper.queryOrderInfoAll(pageNum, pageSize, status);

            return orderMasterEntities;
        }
    }

    // 根据用户编号查询
    public List<OrderMasterEntity> queryOrderInfoByUserId(int userId) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            OrderInfoMapper mapper = sqlSession.getMapper(OrderInfoMapper.class);
            List<OrderMasterEntity> orderMasterEntities = mapper.queryOrderInfoByUserId(userId);

            return orderMasterEntities;
        }
    }

    // 订单项信息
    public List<OrderDetailEntity> queryOrderDetailByOrderMasterId(int id) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            OrderInfoMapper mapper = sqlSession.getMapper(OrderInfoMapper.class);
            return mapper.queryOrderDetailByOrderMasterId(id);
        }
    }

    public static void main(String[] args) {

        OrderInfoServiceImpl orderInfoService = new OrderInfoServiceImpl();
        List<OrderMasterEntity> orderMasterEntities = orderInfoService.queryOrderInfoAll(1, 5, 0);
        for (OrderMasterEntity v : orderMasterEntities) {
            System.out.println(v);
        }


    }
}
