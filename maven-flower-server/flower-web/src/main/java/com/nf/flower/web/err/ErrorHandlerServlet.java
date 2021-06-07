package com.nf.flower.web.err;

import com.nf.flower.util.JsonUtil;
import com.nf.flower.vo.ResultVO;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet
public class ErrorHandlerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK); //200的http状态码
        resp.setContentType("application/json;charset=UTF-8");
        Throwable throwable = (Throwable)
                req.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer)
                req.getAttribute("javax.servlet.error.status_code");
        String servletName = (String)
                req.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String)
                req.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }
        String msg = "请求servlet：" + servletName + " 出错，请求地址为：" + requestUri + " 错误消息:" + throwable.getMessage();
        ResultVO responseVO = ResultVO.error(500, msg);

        String s = JsonUtil.object2String(responseVO);
        resp.getWriter().println(s);
    }
}
