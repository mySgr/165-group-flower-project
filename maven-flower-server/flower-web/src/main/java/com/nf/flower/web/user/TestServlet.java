package com.nf.flower.web.user;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;


@WebServlet("/api/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        final BufferedReader reader = req.getReader();
//         String s = reader.readLine();
//        System.out.println(reader);
//        System.out.println(s);
//
//        final User user = new Gson().fromJson(s, new User().getClass());
//        System.out.println(user);

        final BufferedReader reader = req.getReader();
        String s = reader.readLine();

        HashMap<String, Object> map = new HashMap<>();
        map = new Gson().fromJson(s, map.getClass());
        System.out.println(map);


        final User user = new Gson().fromJson(s, User.class);
        System.out.println(reader.readLine());
        System.out.println(user);

        System.out.println("----");


//        String name = req.getParameter("name");
//        System.out.println(name);
    }
}
