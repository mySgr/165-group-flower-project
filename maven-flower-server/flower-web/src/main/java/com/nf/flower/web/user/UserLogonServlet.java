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

@WebServlet("/api/user/logon")
public class UserLogonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String s = req.getReader().readLine();
        UserInfoEntity userParams = JsonUtil.string2Object(s, UserInfoEntity.class);

        UserInfoEntity userInfoEntity = new UserInfoServiceImpl().getUserByPhone(userParams.getPhone());
        if (userInfoEntity==null){
            new UserInfoServiceImpl().insertUserInfo(userParams);
            resp.getWriter().println(JsonUtil.object2String(ResultVO.success(200,"注册成功")));
        }else {
            resp.getWriter().println(JsonUtil.object2String(ResultVO.error(100,"已存在该用户")));
        }

    }
}
