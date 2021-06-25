package com.nf.flower.service.commodity;

import com.nf.flower.dao.FlowerPictureMapper;
import com.nf.flower.entity.commodity.FlowerPictureEntity;
import com.nf.flower.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FlowerPictureServiceImpl {
    public int addFlowerPicture(FlowerPictureEntity entity) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            final FlowerPictureMapper mapper = sqlSession.getMapper(FlowerPictureMapper.class);
            return mapper.addFlowerPicture(entity);
        }
    }

    public List<FlowerPictureEntity> getFlowerPictureListByFlowerId(int flowerId) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            FlowerPictureMapper mapper = sqlSession.getMapper(FlowerPictureMapper.class);
            return mapper.getFlowerPictureListByFlowerId(flowerId);

        }
    }

    public static void main(String[] args) {
        final FlowerPictureEntity entity = new FlowerPictureEntity();
        entity.setImgUrl("xxxx");
        final FlowerPictureServiceImpl flowerPictureService = new FlowerPictureServiceImpl();
        final List<FlowerPictureEntity> flowerPictureListByFlowerId = flowerPictureService
                .getFlowerPictureListByFlowerId(5);
        flowerPictureListByFlowerId.forEach(r -> {
            System.out.println(r);
        });
    }
}
