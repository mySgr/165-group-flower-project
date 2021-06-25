package com.nf.flower.web.commodity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.service.commodity.FlowerInfoServiceImpl;
import com.nf.flower.vo.ResultVO;
import com.nf.flower.web.MyHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/flower/update/status")
public class FlowerUpdateStatusServlet extends MyHttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String status = req.getParameter("status");

        ObjectMapper objectMapper = new ObjectMapper();
        if (id == null || status == null) {
            resp.getWriter().println(objectMapper.writeValueAsString(ResultVO.error(400, "参数不能为空")));
            return;
        }

        FlowerInfoServiceImpl flowerInfoService = new FlowerInfoServiceImpl();
        int i = flowerInfoService.updateFlowerStatus(Integer.parseInt(id), Integer.parseInt(status));
        if (i > 0) {
            resp.getWriter().println(objectMapper.writeValueAsString(ResultVO.success(null, "ok")));
        } else {
            resp.getWriter().println(objectMapper.writeValueAsString(ResultVO.error(400, "状态更新出错")));
        }
    }
}
