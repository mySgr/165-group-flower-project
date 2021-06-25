package com.nf.flower.web.commodity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.commodity.FlowerinfoEntity;
import com.nf.flower.service.commodity.FlowerInfoServiceImpl;
import com.nf.flower.vo.ResultVO;
import com.nf.flower.web.MyHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/flower/info")
public class FlowerInfoByIdServlet extends MyHttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flowerId = req.getParameter("flowerId");

        ObjectMapper objectMapper = new ObjectMapper();
        if (flowerId == null) {
            resp.getWriter().println(objectMapper.writeValueAsString(ResultVO.error(400, "参数为空")));
            return;
        }

        FlowerInfoServiceImpl flowerInfoService = new FlowerInfoServiceImpl();
        FlowerinfoEntity entity = flowerInfoService.qeruyFlowerInfoById(Integer.parseInt(flowerId));
        String entityString = objectMapper.writeValueAsString(ResultVO.success(entity, "ok"));
        resp.getWriter().println(entityString);
    }
}
