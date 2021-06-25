package com.nf.flower.service.commodity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.flower.dao.FlowerinfoMapper;
import com.nf.flower.entity.commodity.FlowerinfoEntity;
import com.nf.flower.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

<<<<<<< HEAD
import java.security.PublicKey;
=======
>>>>>>> upstream/master
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

    public int updateFlowerStatus(int id, int status) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            FlowerinfoMapper mapper = sqlSession.getMapper(FlowerinfoMapper.class);
            return mapper.updateFlowerStatus(id, status);
        }
    }

    // 修改鲜花信息
    public int updateFlowerInfo(FlowerinfoEntity entity) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            FlowerinfoMapper mapper = sqlSession.getMapper(FlowerinfoMapper.class);
            return mapper.updateFlowerInfoById(entity);
        }
    }

    public FlowerinfoEntity qeruyFlowerInfoById(int flowerId) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            FlowerinfoMapper mapper = sqlSession.getMapper(FlowerinfoMapper.class);
            return mapper.qeruyFlowerInfoById(flowerId);
        }
    }

    public List<FlowerinfoEntity> flowerInfoQueryList(String query, int pageNum, int pageSize) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            FlowerinfoMapper mapper = sqlSession.getMapper(FlowerinfoMapper.class);
            return mapper.flowerInfoQueryList(query, pageNum, pageSize);
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        FlowerInfoServiceImpl flowerInfoService = new FlowerInfoServiceImpl();
        FlowerinfoEntity entity = flowerInfoService.qeruyFlowerInfoById(4);


        System.out.println(new ObjectMapper().writeValueAsString(entity));
    }
}
