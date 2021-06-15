package com.nf.flower.service.commodity;

import com.nf.flower.dao.FlwoerPurposeMapper;
import com.nf.flower.entity.commodity.FlowerPurposeEntity;
import com.nf.flower.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FlowerPurposeServiceImpl {

    public List<FlowerPurposeEntity> getPurposeList() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            FlwoerPurposeMapper mapper = sqlSession.getMapper(FlwoerPurposeMapper.class);
            List<FlowerPurposeEntity> purposeList = mapper.getPurposeList();
            return purposeList;
        }
    }

    public static void main(String[] args) {
        System.out.println(new FlowerPurposeServiceImpl().getPurposeList());
    }
}
