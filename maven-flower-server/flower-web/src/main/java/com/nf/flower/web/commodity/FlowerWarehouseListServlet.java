package com.nf.flower.web.commodity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.commodity.FlowerWarehouseEntity;
import com.nf.flower.service.commodity.FlowerWarehouseServiceImpl;
import com.nf.flower.vo.ResultVO;
import com.nf.flower.web.MyHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/warehouse/list")
public class FlowerWarehouseListServlet extends MyHttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FlowerWarehouseServiceImpl flowerWarehouseService = new FlowerWarehouseServiceImpl();
        List<FlowerWarehouseEntity> flowerWarehouseList = flowerWarehouseService.getFlowerWarehouseList();

        ObjectMapper jackson = new ObjectMapper();
        String str = jackson.writeValueAsString(ResultVO.success(flowerWarehouseList, "ok"));

        resp.getWriter().println(str);

    }
}
