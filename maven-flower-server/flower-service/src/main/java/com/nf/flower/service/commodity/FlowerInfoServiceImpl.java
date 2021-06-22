package com.nf.flower.service.commodity;

import com.nf.flower.dao.FlowerinfoMapper;
import com.nf.flower.entity.commodity.FlowerinfoEntity;
import com.nf.flower.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.security.PublicKey;
import java.util.List;

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
    //分页查询热销榜的鲜花
    public List<FlowerinfoEntity> hotFlowerInfo(){
        try (  SqlSession sqlSession =MyBatisUtils.getSqlSession()){

            FlowerinfoMapper mapper=sqlSession.getMapper(FlowerinfoMapper.class);
            List<FlowerinfoEntity> list =mapper.hotFlowerInfo();
            return  list;
        }
    }
    //查询鲜花的详细信息
    public FlowerinfoEntity selectFlowerInfo(int flowerId){
        try (  SqlSession sqlSession =MyBatisUtils.getSqlSession()){
            FlowerinfoMapper mapper=sqlSession.getMapper(FlowerinfoMapper.class);
          return  mapper.selectFlowerInfo(flowerId);
        }
    }

    public static void main(String[] args) {
        FlowerInfoServiceImpl flowerInfoService=new FlowerInfoServiceImpl();
        flowerInfoService.selectFlowerInfo(5);
    }
}
