package com.nf.flower.web.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.commodity.Cart;

import com.nf.flower.service.cart.CartServiceImpl;
import com.nf.flower.service.commodity.FlowerShoppingImpl;
import com.nf.flower.service.order.OrderInfoServiceImpl;
import com.nf.flower.vo.OrderVo;
import com.nf.flower.vo.ResultVO;
import com.nf.flower.web.MyHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@WebServlet("/api/order/create")
public class CreateOrderServlet extends MyHttpServlet {
    private int[] cartIds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("ids");
        String[] split = ids.split(",");

        cartIds = Arrays.stream(split).mapToInt(v -> Integer.parseInt(v)).toArray();

        CartServiceImpl cartService = new CartServiceImpl();
        Cart cartInfo = cartService.getCartInfoByCartId(cartIds);

        ObjectMapper json = new ObjectMapper();
        final String s = json.writeValueAsString(ResultVO.success(cartInfo, "ok"));
        resp.getWriter().println(s);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper json = new ObjectMapper();
        // 获取订单信息
        String s = req.getReader().readLine();
        OrderVo orderVo = json.readValue(s, OrderVo.class);


        // 添加订单
        OrderInfoServiceImpl orderInfoService = new OrderInfoServiceImpl();
        int orderId = orderInfoService.addOrder(orderVo);
        resp.getWriter().println(json.writeValueAsString(ResultVO.success(orderId, "ok")));

        // 订单添加完成后，删除购物项
        FlowerShoppingImpl flowerShopping = new FlowerShoppingImpl();

        for (int i = 0; i < cartIds.length; i++) {
            flowerShopping.deleteFlower(cartIds[i]);
        }
    }
}
