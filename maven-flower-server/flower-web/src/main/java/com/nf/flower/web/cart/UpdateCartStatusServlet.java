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

@WebServlet("/api/cart/status/update")
public class UpdateCartStatusServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String status = req.getParameter("status");
        String id = req.getParameter("id");

        // 更新状态
        CartServiceImpl cartService = new CartServiceImpl();
        cartService.updateCartStatus(Integer.parseInt(status), Integer.parseInt(id));
        resp.getWriter().println(new ObjectMapper().writeValueAsString(ResultVO.success(null, "ok")));


    }
}
