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

@WebServlet("/api/cart/status/all")
public class UpdateCartItemStatusAllServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");
        String userId = req.getParameter("userId");
        final ObjectMapper objectMapper = new ObjectMapper();
        if (userId == null) {
            resp.getWriter().println(objectMapper.writeValueAsString(ResultVO.error(-1, "请先登陆")));
            return;
        }


        CartServiceImpl cartService = new CartServiceImpl();
        Cart cart = cartService.getCartByUserId(Integer.parseInt(userId));

        int i = cartService.updateCartStatusAll(cart.getList(), Integer.parseInt(status));

    }
}
