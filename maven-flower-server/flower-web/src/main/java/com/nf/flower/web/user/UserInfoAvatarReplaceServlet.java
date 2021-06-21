package com.nf.flower.web.user;

import cn.hutool.core.io.resource.InputStreamResource;
import cn.hutool.http.HttpUtil;
import com.nf.flower.service.UserInfoServiceImpl;
import com.nf.flower.tools.Common;
import com.nf.flower.util.JsonUtil;
import com.nf.flower.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@WebServlet("/api/user/AvatarReplace")
@MultipartConfig
public class UserInfoAvatarReplaceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part part = req.getPart("avatar");
        String userId = req.getParameter("userId");
        // name
        String avatar = "avatar/" + UUID.randomUUID() + "_" + part.getSubmittedFileName();
        // file
        InputStream inputStream = part.getInputStream();
        System.out.println(avatar);
        //必须指定文件名
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream, avatar);

        Map<String, Object> map = new HashMap<>();
        map.put("avatar", inputStreamResource);

        HttpUtil.post(Common.IP_ADDRESS + "avatar/", map);
        // sql
        int i = new UserInfoServiceImpl().updateUserInfoAvatar(avatar, Integer.parseInt(userId));
        if (i <= 0) {
            resp.getWriter().println(JsonUtil.object2String(ResultVO.error(-1, "修改err")));
        } else {
            resp.getWriter().println(JsonUtil.object2String(ResultVO.success(null, "修改成功")));

        }


    }
}
