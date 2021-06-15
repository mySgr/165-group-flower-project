package com.nf.flower.service.commodity;

import com.nf.flower.dao.FlowerinfoMapper;
import com.nf.flower.entity.commodity.FlowerinfoEntity;
import com.nf.flower.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class FlowerInfoServiceImpl {

    public FlowerinfoEntity addFlowerInfo(FlowerinfoEntity entity) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            FlowerinfoMapper mapper = sqlSession.getMapper(FlowerinfoMapper.class);

            int count = mapper.addFlowerInfo(entity);
            if (count <= 0) {
                return null;
            } else
                return entity;
        }
    }
}
