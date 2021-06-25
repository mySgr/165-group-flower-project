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

@WebServlet("/api/flower/info/edit")
@MultipartConfig
public class EditFlowerInfoServlet extends MyHttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String flowerinfo = req.getParameter("flowerinfo");
        ObjectMapper objectMapper = new ObjectMapper();

        FlowerinfoEntity entity = objectMapper.readValue(flowerinfo, FlowerinfoEntity.class);


        // 获取 鲜花正图 对象
        Part cover = req.getPart("cover");
        // 将图片存储到 hfs
        if (cover != null) {
            // 保存图片的名字
            String imgName = "flower/" + UUID.randomUUID() + "_" + cover.getSubmittedFileName();

            // 保存到数据库的名字
            entity.setCover(imgName);
            //必须指定文件名
            InputStreamResource inputStreamResource = new InputStreamResource(cover.getInputStream(), imgName);

            Map<String, Object> map = new HashMap<>();
            map.put("myfile", inputStreamResource);
            HttpUtil.post(Common.IP_ADDRESS + "flower/", map);
        }
        // 将鲜花数据存到数据库
        int count = new FlowerInfoServiceImpl().updateFlowerInfo(entity);
        if (count > 0) {
            resp.getWriter().println(JsonUtil.object2String(ResultVO.success(count, "修改成功")));
        } else {
            resp.getWriter().println(new ObjectMapper().writeValueAsString(ResultVO.error(300, "修改出错")));
        }
    }
}
