package com.nf.flower.service.commodity;

import com.nf.flower.dao.FlowerWarehouseMapper;
import com.nf.flower.entity.commodity.FlowerWarehouseEntity;
import com.nf.flower.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;


import java.util.List;

public class FlowerWarehouseServiceImpl {

    public List<FlowerWarehouseEntity> getFlowerWarehouseList() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            FlowerWarehouseMapper mapper = sqlSession.getMapper(FlowerWarehouseMapper.class);
            List<FlowerWarehouseEntity> flowerWarehouseList = mapper.getFlowerWarehouseList();
            return flowerWarehouseList;
        }
    }

    public static void main(String[] args) {
        System.out.println(new FlowerWarehouseServiceImpl().getFlowerWarehouseList());
    }
}
