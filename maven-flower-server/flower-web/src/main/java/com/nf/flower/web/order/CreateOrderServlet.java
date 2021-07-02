package com.nf.flower.web.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.order.OrderDetailEntity;
import com.nf.flower.entity.order.OrderMasterEntity;
import com.nf.flower.web.MyHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/api/order/create")
public class CreateOrderServlet extends MyHttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getReader().readLine();

        Map<String, Object> objectMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(s, objectMap.getClass());

        // 组装订单数据
        OrderMasterEntity orderMaster = new OrderMasterEntity();
        orderMaster.setUserId(Integer.parseInt(map.get("userId") + ""));
        orderMaster.setAddressId(Integer.parseInt(map.get("addressId") + ""));
        orderMaster.setOrderMoney(new BigDecimal(map.get("orderMoney") + ""));
        orderMaster.setPaymentMethod(Integer.parseInt(map.get("paymentMethod") + ""));
        orderMaster.setOrderStatus(2);
        orderMaster.setCreateTime(LocalDateTime.now());
        orderMaster.setPayTime(LocalDateTime.now());


        // 订单详细信息
        Map<String, Object> orderDetailMap = (Map<String, Object>) map.get("orderDetail");
        OrderDetailEntity orderDetail = new OrderDetailEntity();
        orderDetail.setFlowerId(Integer.parseInt(orderDetailMap.get("flowerId") + ""));
        orderDetail.setProductCount(Integer.parseInt(orderDetailMap.get("count") + ""));
        orderDetail.setProductPrice(new BigDecimal(orderDetailMap.get("subTotal") + ""));


        System.out.println(orderMaster);
        System.out.println(orderDetail);
        System.out.println(map);
    }
}
