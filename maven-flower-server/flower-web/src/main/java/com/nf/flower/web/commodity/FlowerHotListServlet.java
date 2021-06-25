package com.nf.flower.web.commodity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.commodity.FlowerinfoEntity;
import com.nf.flower.service.commodity.FlowerInfoServiceImpl;
import com.nf.flower.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/flower/hot")
public class FlowerHotListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FlowerInfoServiceImpl flowerInfoService=new FlowerInfoServiceImpl();
        List<FlowerinfoEntity> flowerinfoEntityList=flowerInfoService.hotFlowerInfo();
        ObjectMapper objectMapper=new ObjectMapper();
        String  hot = objectMapper.writeValueAsString(ResultVO.success(flowerinfoEntityList,"成功"));
        resp.getWriter().println(hot);
        System.out.println(hot);

    }
}
