package com.nf.flower.web.commodity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.commodity.FlowerinfoEntity;
import com.nf.flower.service.UserInfoServiceImpl;
import com.nf.flower.service.commodity.FlowerInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/detailed/flower")
public class FlowerDetailedListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ss=req.getParameter("flowerId");
        FlowerinfoEntity flowerinfoEntity=
                new FlowerInfoServiceImpl().selectFlowerInfo(Integer.parseInt(ss));
        ObjectMapper objectMapper=new ObjectMapper();
        String josn=objectMapper.writeValueAsString(flowerinfoEntity);
        resp.getWriter().println(josn);


    }
}
