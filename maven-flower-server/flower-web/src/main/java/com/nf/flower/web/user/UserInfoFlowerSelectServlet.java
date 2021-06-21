package com.nf.flower.web.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.commodity.FlowerinfoEntity;
import com.nf.flower.service.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/FlowerSelects")
public class UserInfoFlowerSelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       String ss=req.getParameter("prams");
        List<FlowerinfoEntity> flowerinfoEntities=new UserInfoServiceImpl().selectFlowerLikenameAndprice(ss);
        ObjectMapper mapper= new ObjectMapper();
        String jsonList=mapper.writeValueAsString(flowerinfoEntities);
        resp.getWriter().println(jsonList);

    }
}
