package com.nf.flower.web.cart;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.commodity.Cart;
import com.nf.flower.service.cart.CartServiceImpl;
import com.nf.flower.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * user 的购物车
 */
@WebServlet("/api/cart/list")
public class GetCartMasterByUserId extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        System.out.println(userId);
        final ObjectMapper objectMapper = new ObjectMapper();
        if (userId == null) {
            resp.getWriter().println(objectMapper.writeValueAsString(ResultVO.error(-1, "请先登陆")));
            return;
        }

        final CartServiceImpl cartService = new CartServiceImpl();
        Cart cart = cartService.getCartByUserId(Integer.parseInt(userId));

        double total = 0;
        for (int i = 0; i < cart.getList().size(); i++) {
            if (cart.getList().get(i).getCartStatus() == 1) {
                total += cart.getList().get(i).getCartPrice().doubleValue();
            }
        }
        cart.setTotalPrice(new BigDecimal(total));
        resp.getWriter().println(objectMapper.writeValueAsString(ResultVO.success(cart, "ok")));


    }
}
