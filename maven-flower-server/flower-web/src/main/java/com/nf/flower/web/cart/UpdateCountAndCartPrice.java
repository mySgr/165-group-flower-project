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

@WebServlet("/api/cart/reckon")
public class UpdateCountAndCartPrice extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String cartListId = req.getParameter("cartListId");
        String price = req.getParameter("price");
        String count = req.getParameter("count");

        // 更新的数据
        CartItem cartItem = new CartItem();
        // 计算购物小计
        BigDecimal bigDecimal = new BigDecimal(Integer.parseInt(count) * Double.parseDouble(price));

        // 传入数据
        cartItem.setCartListId(Integer.parseInt(cartListId));
        cartItem.setCartCount(Integer.parseInt(count));
        cartItem.setCartPrice(bigDecimal);

        //  开始更新
        CartServiceImpl cartService = new CartServiceImpl();
        cartService.updateCountAndCartPrice(cartItem);

        resp.getWriter().println(new ObjectMapper().writeValueAsString(ResultVO.success(null, "ok")));


    }
}
