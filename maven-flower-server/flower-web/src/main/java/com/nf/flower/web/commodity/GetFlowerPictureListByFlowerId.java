package com.nf.flower.web.commodity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.commodity.FlowerPictureEntity;
import com.nf.flower.service.commodity.FlowerPictureServiceImpl;
import com.nf.flower.vo.ResultVO;
import com.nf.flower.web.MyHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/flower/picture/list")
public class GetFlowerPictureListByFlowerId extends MyHttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flowerId = req.getParameter("flowerId");
        ObjectMapper objectMapper = new ObjectMapper();
        if (flowerId == null) {
            resp.getWriter().println(objectMapper.writeValueAsString(ResultVO.error(400, "参数为空")));
            return;
        }
        FlowerPictureServiceImpl flowerPictureService = new FlowerPictureServiceImpl();
        List<FlowerPictureEntity> flowerPictureList = flowerPictureService.getFlowerPictureListByFlowerId(Integer.parseInt(flowerId));

        resp.getWriter().println(objectMapper.writeValueAsString(ResultVO.success(flowerPictureList, "ok")));
    }
}
