package com.nf.flower.service;

import com.nf.flower.dao.UserInfoMapper;
import com.nf.flower.entity.UserInfoEntity;
import com.nf.flower.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserInfoServiceImpl {
    public List<UserInfoEntity> getUserInfo() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            final UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
            return mapper.getUser(10002);
        }
    }

    // 登录实现, 返回传入的手机号跟密码相匹配的一条信息
    public UserInfoEntity userLogin(String phone, String password) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
            return mapper.userLogin(phone, password);

        }
    }

    // 根据传入的用户编号，返回该编号的信息
    public UserInfoEntity getUserInfo(int id) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
            return mapper.getUserInfo(id);
        }
    }



}
