package com.nf.flower.web.commodity;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.nf.flower.service.commodity.FlowerShoppingImpl;
import com.nf.flower.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/api/add/shopping/flower")
public class FlowerAddShoppingCartServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId =req.getParameter("userId");
        String flowerId = req.getParameter("flowerId");
        String productAmount = req.getParameter("productAmount");
        BigDecimal price = new BigDecimal(req.getParameter("price"));

        System.out.println(userId);
        System.out.println(flowerId);
        System.out.println(productAmount);
        System.out.println(price);

        ObjectMapper object = new ObjectMapper();
        if (userId==null){

            resp.getWriter().println(object.writeValueAsString(ResultVO.error(-1,"请先登陆")));
        }

        FlowerShoppingImpl flowerShopping=new FlowerShoppingImpl();
       flowerShopping.addShopping(Integer.parseInt(userId),Integer.parseInt(flowerId),Integer.parseInt(productAmount),price);
    }
}
