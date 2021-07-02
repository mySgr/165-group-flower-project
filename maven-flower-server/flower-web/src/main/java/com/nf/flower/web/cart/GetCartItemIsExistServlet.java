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


/**
 * 查询用户购物车是否有该商品
 */
@WebServlet("/api/cart/item/exist")
public class GetCartItemIsExistServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String flowerId = req.getParameter("flowerId");

        CartServiceImpl cartService = new CartServiceImpl();
        Cart cart = cartService.getCartByUserId(Integer.parseInt(userId));
        boolean isCart = false;

        for (int i = 0; i < cart.getList().size(); i++) {
            if (cart.getList().get(i).getFlowerId() == Integer.parseInt(flowerId)) {
                isCart = true;
            }
        }
        resp.getWriter().println(new ObjectMapper().writeValueAsString(ResultVO.success(isCart, "ok")));
    }
}
