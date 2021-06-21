package com.nf.flower.service;

import com.nf.flower.dao.UserInfoMapper;
import com.nf.flower.entity.UserInfoEntity;
import com.nf.flower.entity.commodity.FlowerinfoEntity;
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
            UserInfoEntity userInfo = mapper.getUserInfo(id);
            return userInfo;
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
           // 默认的值
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

    //搭配随机数生成数据库随机用户编号
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

    //修改用户的信息，修改用户名，签名，出生时间
    public int updateUserInfo(UserInfoEntity userInfoEntity) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
           return mapper.updateUserInfo(userInfoEntity);
        }
    }

    //修改用户头像
    public int updateUserInfoAvatar(String avatar,int userId) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
            return mapper.updateUserInfoAvatar(avatar,userId);
        }
    }
    //遍历鲜花图片
    public List<FlowerinfoEntity> userInfoSelect() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        List<FlowerinfoEntity> list = userInfoMapper.userInfoSelect();
        return  list;
    }
    //鲜花查询

    public List<FlowerinfoEntity> selectFlowerLikenameAndprice(String parmen){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        List<FlowerinfoEntity> list = userInfoMapper.selectFlowerLikenameAndprice(parmen);
        return list;
    }

    //更换用户的图片并保存
    public List<UserInfoEntity> userInfoAvatar(){
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
            return mapper.userInfoAvatar();
        }
    }

    public static void main(String[] args) {
        UserInfoServiceImpl userInfoService = new UserInfoServiceImpl();
        List<FlowerinfoEntity> list =  userInfoService.selectFlowerLikenameAndprice("牛");
//        System.out.println(list);

        System.out.println(list);
    }

}
