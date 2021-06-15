package com.nf.flower.web.user;

import com.nf.flower.entity.UserInfoEntity;
import com.nf.flower.service.UserInfoServiceImpl;
import com.nf.flower.util.JsonUtil;
import com.nf.flower.vo.ResultVO;
import com.nf.flower.web.MyHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录的 api
 * 接受两个请求参数 phone 与 password
 * <p>
 * 响应数据：userId,userName,status,roleId
 */

@WebServlet("/api/user/login")
public class UserLoginServlet extends MyHttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         String s = req.getReader().readLine();

        UserInfoEntity userParams = JsonUtil.string2Object(s, UserInfoEntity.class);
        System.out.println(s);
        UserInfoEntity userInfoEntity = new UserInfoServiceImpl().userLogin(userParams.getPhone(), userParams.getPassword());

        if (userInfoEntity != null) {
            resp.getWriter().println(JsonUtil.object2String(ResultVO.success(userInfoEntity, "登陆成功")));
        } else {
            resp.getWriter().println(JsonUtil.object2String(ResultVO.error(400,"登陆失败，请确保帐号或密码没有输错")));
        }

    }
}
