package com.nf.flower.service;

import com.nf.flower.dao.UserInfoMapper;
import com.nf.flower.entity.UserInfoEntity;
import com.nf.flower.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

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

    // 判断是否有该手机号存在
    public UserInfoEntity getUserByPhone(String phone) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
            return mapper.getUserByPhone(phone);
        }
    }

    // 添加注册的用户
    public UserInfoEntity insertUserInfo(UserInfoEntity entity) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            // default
            entity.setUserId(getUserID());
            entity.setRoleId(1);
            entity.setStatus(1);
            entity.setAvatar("avatar/default-avatar.jpg");
            entity.setCreated(LocalDateTime.now());


       UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
            mapper.insertUserInfo(entity);
            return entity;
        }
    }

    public static Integer getUserID() {
        int maxid = 100000000;
        int minid = 10000;
        Random random = new Random();
        while (true) {
            int userId = random.nextInt(maxid - minid) + minid;
            UserInfoEntity userInfo = new UserInfoServiceImpl().getUserInfo(userId);
            if (userInfo == null) {
                return userId;
            }
        }

    }

    public static void main(String[] args) {
        UserInfoEntity userInfoEntity1 = new UserInfoEntity();

        userInfoEntity1.setUserName("cc");
        userInfoEntity1.setPassword("123123");
        userInfoEntity1.setPhone("4555");

        UserInfoEntity userInfoEntity = new UserInfoServiceImpl().insertUserInfo(userInfoEntity1);
        System.out.println(userInfoEntity);
    }


}
