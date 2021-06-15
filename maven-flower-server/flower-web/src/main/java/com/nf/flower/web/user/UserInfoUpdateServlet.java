package com.nf.flower.web.user;

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

@WebServlet("/api/UpdateUserInfo")
public class UserInfoUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String s = req.getReader().readLine();
        UserInfoEntity userParams = JsonUtil.string2Object(s, UserInfoEntity.class);

        System.out.println(userParams);


        int i = new UserInfoServiceImpl().updateUserInfo(userParams);
        if (i <= 0) {
            resp.getWriter().println(JsonUtil.object2String(ResultVO.error(-1, "修改err")));
        } else {
            resp.getWriter().println(JsonUtil.object2String(ResultVO.success(null, "修改成功")));

        }


    }
}
