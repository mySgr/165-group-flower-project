package com.nf.flower.web.shopping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.commodity.FLowerInfoSelectShoppingEntity;
import com.nf.flower.service.commodity.FlowerShoppingImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/delete/shopping")
public class ShoppingByIdDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       int ss=Integer.parseInt(req.getParameter("cartId"));
        FlowerShoppingImpl flowerShopping = new FlowerShoppingImpl();
        flowerShopping.deleteFlower(ss);

    }
}
