package com.nf.flower.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        //跨域请求，*代表允许全部类型
        resp.setHeader("Access-Control-Allow-Origin", "*"); // 允许某个域名的网站跨域
        //请求包含的字段内容，如有多个可用哪个逗号分隔如下
        resp.setHeader("Access-Control-Allow-Headers", "content-type,x-requested-with,Authorization, x-ui-request,lang");

        //resp.setHeader("Access-Control-Allow-Credentials", "true");   // 允许发送 cookie
        //允许请求方式
        // resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
