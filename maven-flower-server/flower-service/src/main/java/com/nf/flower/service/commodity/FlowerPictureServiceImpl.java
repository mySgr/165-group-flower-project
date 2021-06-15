package com.nf.flower.service.commodity;

import com.nf.flower.dao.FlowerPictureMapper;
import com.nf.flower.entity.commodity.FlowerPictureEntity;
import com.nf.flower.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class FlowerPictureServiceImpl {
    public int addFlowerPicture(FlowerPictureEntity entity) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            final FlowerPictureMapper mapper = sqlSession.getMapper(FlowerPictureMapper.class);
            return mapper.addFlowerPicture(entity);
        }
    }

    public static void main(String[] args) {
        final FlowerPictureEntity entity = new FlowerPictureEntity();
        entity.setImgUrl("xxxx");
        final FlowerPictureServiceImpl flowerPictureService = new FlowerPictureServiceImpl();
        final int i = flowerPictureService.addFlowerPicture(entity);
        System.out.println(i);
    }
}
