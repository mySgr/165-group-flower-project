package com.nf.flower.web.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.dao.UserInfoMapper;
import com.nf.flower.entity.UserInfoEntity;
import com.nf.flower.service.UserInfoServiceImpl;
import com.nf.flower.util.JsonUtil;
import com.nf.flower.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/api/getuser")
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");




        UserInfoEntity user = new UserInfoServiceImpl().getUserInfo(Integer.parseInt(userId));
        System.out.println(user);
        resp.getWriter().println(JsonUtil.object2String(ResultVO.success(user, "ok")));


    }
}
