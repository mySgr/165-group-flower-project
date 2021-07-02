package com.nf.flower.web.cart;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.commodity.Cart;
import com.nf.flower.entity.commodity.CartItem;
import com.nf.flower.service.cart.CartServiceImpl;
import com.nf.flower.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/api/cart/item/add")
public class AddCartItemServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String flowerId = req.getParameter("flowerId");
        String productAmount = req.getParameter("productAmount");
        BigDecimal price = new BigDecimal(req.getParameter("price"));

        ObjectMapper object = new ObjectMapper();
        if (userId == null) {
            resp.getWriter().println(object.writeValueAsString(ResultVO.error(-1, "请先登陆")));
            return;
        }
        final CartServiceImpl cartService = new CartServiceImpl();
        Cart cart = cartService.getCartByUserId(Integer.parseInt(userId));
        if (cart == null) {
            cartService.addCartMaster(Integer.parseInt(userId));
            cart = cartService.getCartByUserId(Integer.parseInt(userId));
        }
        CartItem cartItem = new CartItem();
        cartItem.setFlowerId(Integer.parseInt(flowerId));
        cartItem.setCartCount(Integer.parseInt(productAmount));
        cartItem.setCartPrice(price);
        cartItem.setCartMasterId(cart.getCartMasterId());

        final int count = cartService.addCartItem(cartItem);
        if (count > 0) {
            resp.getWriter().println(object.writeValueAsString(ResultVO.success(null, "ok")));
        }
    }
}
