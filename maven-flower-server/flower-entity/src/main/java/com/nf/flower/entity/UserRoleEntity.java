package com.nf.flower.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * -- 用户角色表
 * CREATE TABLE user_role
 * (
 * 	role_id INT AUTO_INCREMENT COMMENT '角色id 主键自增',
 * 	role_identity VARCHAR(30) NOT NULL COMMENT '身份 1网站用户 2管理员 3管理员',
 * 	PRIMARY KEY(role_id)
 * );
 */
public class UserRoleEntity {
    private Integer roleId;
    private String roleIdentity;

    private List<UserInfoEntity> userInfoEntity ;



    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleIdentity() {
        return roleIdentity;
    }

    public void setRoleIdentity(String roleIdentity) {
        this.roleIdentity = roleIdentity;
    }

    public List<UserInfoEntity> getUserInfoEntity() {
        return userInfoEntity;
    }

    public void setUserInfoEntity(List<UserInfoEntity> userInfoEntity) {
        this.userInfoEntity = userInfoEntity;
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "roleId=" + roleId +
                ", roleIdentity='" + roleIdentity + '\'' +
                ", userInfoEntity=" + userInfoEntity +
                '}';
    }

    public static void main(String[] args) {
//        final UserRoleEntity userRoleEntity = new UserRoleEntity();
//         List<UserInfoEntity> userInfoEntity = new ArrayList<>();
//        final UserInfoEntity userInfoEntity1 = new UserInfoEntity();
//        userInfoEntity1.setUserName("hello");
//        userInfoEntity.add(userInfoEntity1);
//
//        userRoleEntity.setUserInfoEntity(userInfoEntity);
//        System.out.println(userRoleEntity);
    }
}
