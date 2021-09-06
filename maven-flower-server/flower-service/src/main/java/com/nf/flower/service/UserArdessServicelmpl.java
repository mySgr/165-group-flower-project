package com.nf.flower.service;

import com.nf.flower.dao.OrderAddressMapper;
import com.nf.flower.entity.UserAddressEntity;
import com.nf.flower.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserArdessServicelmpl {
    // 根据传入的用户编号，查询到此用户地址
    public List<UserAddressEntity> getUserAddressEntity(int id) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            OrderAddressMapper mapper = sqlSession.getMapper(OrderAddressMapper.class);
            List<UserAddressEntity> userAddressEntity = mapper.getUserAddressEntity(id);
            return userAddressEntity;
        }
    }

    public static void main(String[] args) {
        UserArdessServicelmpl userAddressEntity = new UserArdessServicelmpl();
        System.out.println(userAddressEntity.getUserAddressEntity(10001));

    }
}
