package com.nf.flower.web.commodity;

import cn.hutool.core.io.resource.InputStreamResource;
import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.commodity.FlowerinfoEntity;
import com.nf.flower.service.commodity.FlowerInfoServiceImpl;
import com.nf.flower.tools.Common;
import com.nf.flower.util.JsonUtil;
import com.nf.flower.vo.ResultVO;
import com.nf.flower.web.MyHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet("/api/flower/add")
@MultipartConfig
public class AddFlowerinfoServlet extends MyHttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取 鲜花基本信息
        String formData = req.getParameter("flowerinfo");
        FlowerinfoEntity flower = new ObjectMapper().readValue(formData, FlowerinfoEntity.class);
        System.out.println(flower);
        // 获取 鲜花正图 对象
        Part cover = req.getPart("cover");

        // 保存图片的名字
        String imgName = "flower/" + UUID.randomUUID() + "_" + cover.getSubmittedFileName();

        // 将图片存储到 hfs
        if (cover.getSubmittedFileName() != null) {
            flower.setCover(imgName);
            //必须指定文件名
            InputStreamResource inputStreamResource = new InputStreamResource(cover.getInputStream(), imgName);

            Map<String, Object> map = new HashMap<>();
            map.put("myfile", inputStreamResource);
            HttpUtil.post(Common.IP_ADDRESS + "flower/", map);
        }
        // 将鲜花数据存到数据库
        FlowerinfoEntity flowerinfoEntity = new FlowerInfoServiceImpl().addFlowerInfo(flower);
        if (flowerinfoEntity != null) {
            resp.getWriter().println(JsonUtil.object2String(ResultVO.success(flowerinfoEntity, "添加成功")));
        } else {
            resp.getWriter().println(new ObjectMapper().writeValueAsString(ResultVO.error(300, "添加出错")));
        }

    }
}
