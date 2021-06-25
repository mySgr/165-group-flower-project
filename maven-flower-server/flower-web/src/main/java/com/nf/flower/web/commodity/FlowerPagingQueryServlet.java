package com.nf.flower.web.commodity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.nf.flower.entity.commodity.FlowerinfoEntity;
import com.nf.flower.service.commodity.FlowerInfoServiceImpl;
import com.nf.flower.vo.ResultVO;
import com.nf.flower.web.MyHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/flower/paging")
public class FlowerPagingQueryServlet extends MyHttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");
        String query = req.getParameter("query");



        if (pageNum == null) pageNum = "1";

        if (pageSize == null) pageNum = "5";

        FlowerInfoServiceImpl flowerInfoService = new FlowerInfoServiceImpl();
        List<FlowerinfoEntity> flowerinfoList = flowerInfoService.flowerInfoQueryList(query, Integer.parseInt(pageNum), Integer.parseInt(pageSize));

        PageInfo<FlowerinfoEntity> flowerinfoEntityPageInfo = new PageInfo<>(flowerinfoList);

        ObjectMapper objectMapper = new ObjectMapper();

        String s = objectMapper.writeValueAsString(ResultVO.success(flowerinfoEntityPageInfo, "ok"));

        resp.getWriter().println(s);


    }
}
