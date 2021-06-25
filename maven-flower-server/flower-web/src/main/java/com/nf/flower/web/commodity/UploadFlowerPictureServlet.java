package com.nf.flower.web.commodity;

import cn.hutool.core.io.resource.InputStreamResource;
import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.entity.commodity.FlowerPictureEntity;
import com.nf.flower.service.commodity.FlowerPictureServiceImpl;
import com.nf.flower.tools.Common;
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

@WebServlet("/api/upload/picture")
@MultipartConfig
public class UploadFlowerPictureServlet extends MyHttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String flowerId = req.getParameter("flowerId");
        Part picture = req.getPart("picture");

        // 保存数据
        // 将图片存储到 hfs
        if (picture.getSubmittedFileName() != null) {

            // 保存图片的名字
            String saveName = "flower/" + UUID.randomUUID() + "_" + picture.getSubmittedFileName();
            //必须指定文件名
            InputStreamResource inputStreamResource = new InputStreamResource(picture.getInputStream(), saveName);

            Map<String, Object> map = new HashMap<>();
            map.put("myfile", inputStreamResource);
            HttpUtil.post(Common.IP_ADDRESS + "flower/", map);

            // 添加数据库记录
            FlowerPictureEntity entity = new FlowerPictureEntity();
            entity.setFlowerId(Integer.parseInt(flowerId));
            entity.setImgUrl(saveName);

            int count = new FlowerPictureServiceImpl().addFlowerPicture(entity);
            if (count >= 0)
                resp.getWriter().println(new ObjectMapper().writeValueAsString(ResultVO.success(null, "详细图片上传成功")));
            else
                resp.getWriter().println(new ObjectMapper().writeValueAsString(ResultVO.error(400, "图片上传失败")));
        }

    }
}
