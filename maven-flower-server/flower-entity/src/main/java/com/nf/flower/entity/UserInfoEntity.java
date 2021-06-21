package com.nf.flower.entity;

import com.nf.flower.tools.Common;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * -- 用户信息表
 * CREATE TABLE user_info
 * (
 * user_id INT COMMENT '用户编号，主键',
 * user_name VARCHAR(200) NOT NULL COMMENT '用户昵称',
 * phone CHAR(11) NOT NULL COMMENT '手机号',
 * `password` VARCHAR(16) NOT NULL COMMENT '用户密码',
 * <p>
 * avatar VARCHAR(100) NOT NULL COMMENT '头像图片路径',
 * birthdate DATE  COMMENT '出生日期',
 * autograph VARCHAR(500) COMMENT '签名',
 * `status` INT NOT NULL DEFAULT 1 COMMENT '用户状态 1正常，0异常',
 * created DATETIME NOT NULL DEFAULT NOW() COMMENT '注册时间',
 * <p>
 * role_id INT COMMENT '角色id',
 * PRIMARY KEY(user_id),
 * FOREIGN KEY(role_id) REFERENCES user_role(role_id)
 * <p>
 * )
 */
public class UserInfoEntity {
    private Integer userId;
    private String userName;
    private String phone;
    private String password;
    private String avatar;
    private String avatarSrc;
    private String autograph;
    private LocalDate birthdate;
    private Integer status;
    private LocalDateTime created;


    private Integer roleId;
    private UserRoleEntity userRole;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {

        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarSrc() {
        return Common.IP_ADDRESS + avatar;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public UserRoleEntity getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleEntity userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserInfoEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", avatarSrc='" + avatarSrc + '\'' +
                ", autograph='" + autograph + '\'' +
                ", birthdate=" + birthdate +
                ", status=" + status +
                ", created=" + created +
                ", roleId=" + roleId +
                ", userRole=" + userRole +
                '}';
    }
}
