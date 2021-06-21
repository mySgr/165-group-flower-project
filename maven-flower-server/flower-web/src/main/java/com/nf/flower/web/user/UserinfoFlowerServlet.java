package com.nf.flower.web.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.UserInfoEntity;
import com.nf.flower.entity.commodity.FlowerinfoEntity;
import com.nf.flower.service.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/user/selectFlower")
public class UserinfoFlowerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlowerinfoEntity> userInfoEntities=new UserInfoServiceImpl().userInfoSelect();
        ObjectMapper mapper=new ObjectMapper();
        String jsonList = mapper.writeValueAsString(userInfoEntities);
        resp.getWriter().println(jsonList);
        System.out.println(jsonList);
    }
}
