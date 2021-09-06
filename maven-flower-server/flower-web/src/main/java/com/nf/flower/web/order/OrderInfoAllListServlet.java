package com.nf.flower.web.order;

import com.github.pagehelper.PageInfo;
import com.nf.flower.entity.order.OrderMasterEntity;
import com.nf.flower.service.order.OrderInfoServiceImpl;
import com.nf.flower.util.JsonUtil;
import com.nf.flower.vo.ResultVO;
import com.nf.flower.web.MyHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/order/all")
public class OrderInfoAllListServlet extends MyHttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String status = req.getParameter("status");
        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");
        int int_status;

        if (status == null || status == "") {
            int_status = 0;
        } else {
            int_status = Integer.parseInt(status);

        }


        OrderInfoServiceImpl orderInfoService = new OrderInfoServiceImpl();
        List<OrderMasterEntity> orderMasterEntities = orderInfoService.queryOrderInfoAll(Integer.parseInt(pageNum), Integer.parseInt(pageSize), int_status);
        PageInfo<OrderMasterEntity> orderMasterEntityPageInfo = new PageInfo<>(orderMasterEntities);

        String ok = JsonUtil.object2String(ResultVO.success(orderMasterEntityPageInfo, "ok"));
        System.out.println(ok);
        resp.getWriter().println(ok);
    }
}
