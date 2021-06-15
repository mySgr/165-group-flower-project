package com.nf.flower.web.user;

import com.nf.flower.entity.UserInfoEntity;
import com.nf.flower.service.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/api/user/avatar")
@MultipartConfig
public class UserInfoAvatarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part=req.getPart("avatar");
        String avatar= part.getSubmittedFileName();

        String avatardizhi="D:\\flowergitbigbig\\165-group-flower-project\\user-client\\src\\assets\\image";
        new File(avatardizhi + avatar);

        part.write(avatardizhi+avatar);
        System.out.println( avatardizhi+avatar);

    }
}
