package com.nf.flower.web.commodity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.commodity.FlowerPurposeEntity;
import com.nf.flower.service.commodity.FlowerPurposeServiceImpl;
import com.nf.flower.vo.ResultVO;
import com.nf.flower.web.MyHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/purpose/list")
public class FlowerPurposeListServlet extends MyHttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FlowerPurposeServiceImpl flowerPurposeService = new FlowerPurposeServiceImpl();
        List<FlowerPurposeEntity> purposeList = flowerPurposeService.getPurposeList();
        ObjectMapper jackson = new ObjectMapper();
        String str = jackson.writeValueAsString(ResultVO.success(purposeList, "ok"));
        resp.getWriter().println(str);
    }
}
