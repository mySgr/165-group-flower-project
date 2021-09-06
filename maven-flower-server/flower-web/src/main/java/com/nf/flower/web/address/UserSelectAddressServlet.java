package com.nf.flower.web.address;

import com.nf.flower.entity.UserAddressEntity;
import com.nf.flower.service.UserArdessServicelmpl;
import com.nf.flower.util.JsonUtil;
import com.nf.flower.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/selectAddress")
public class UserSelectAddressServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        UserArdessServicelmpl user=new UserArdessServicelmpl();
         List<UserAddressEntity> userAddressEntity = user.getUserAddressEntity(Integer.parseInt(userId));
        resp.getWriter().println(JsonUtil.object2String(ResultVO.success(userAddressEntity, "ok")));
    }
}
