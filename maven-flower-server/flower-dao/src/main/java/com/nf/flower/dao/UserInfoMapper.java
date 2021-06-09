package com.nf.flower.dao;

import com.nf.flower.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserInfoMapper {
    List<UserInfoEntity> getUser(int id);

    UserInfoEntity userLogin(@Param("phone")String phone, @Param("password") String password);

    UserInfoEntity getUserInfo(int id);

     UserInfoEntity getUserByPhone(String phone);

    int insertUserInfo (UserInfoEntity userInfoEntity);






}
