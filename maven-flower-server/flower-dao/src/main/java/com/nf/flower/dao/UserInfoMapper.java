package com.nf.flower.dao;

import com.nf.flower.entity.UserInfoEntity;
import com.nf.flower.entity.commodity.FlowerinfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserInfoMapper {
    List<UserInfoEntity> getUser(int id);


    UserInfoEntity userLogin(@Param("phone")String phone, @Param("password") String password);

    UserInfoEntity getUserInfo(int id);

     UserInfoEntity getUserByPhone(String phone);

    int insertUserInfo (UserInfoEntity userInfoEntity);

    int updateUserInfo(UserInfoEntity userInfoEntity);


    List<UserInfoEntity> userInfoAvatar();

     int updateUserInfoAvatar (@Param("avatar")String avatar, @Param("userId") int userId);

     //遍历鲜花
     List<FlowerinfoEntity> userInfoSelect();

     //鲜花查询
    // List<FlowerinfoEntity> userInfoSelectFlowers();

    List<FlowerinfoEntity> selectFlowerLikenameAndprice(@Param("param") String param);
}
