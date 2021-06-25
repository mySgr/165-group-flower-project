package com.nf.flower.web.commodity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.commodity.FLowerInfoSelectShoppingEntity;
import com.nf.flower.service.commodity.FlowerShoppingImpl;
import com.nf.flower.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/shopping/flower")
public class FlowerShoppingServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        List<FLowerInfoSelectShoppingEntity> list = new FlowerShoppingImpl().selectShopping(Integer.parseInt(userId));
        ObjectMapper objectMapper = new ObjectMapper();
        String shopping = objectMapper.writeValueAsString(ResultVO.success(list, "成功"));
        resp.getWriter().println(shopping);
    }
}
