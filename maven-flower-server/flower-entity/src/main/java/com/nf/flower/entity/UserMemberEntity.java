package com.nf.flower.entity;

import java.math.BigDecimal;

/**
 * -- 会员表
 * CREATE TABLE user_member
 * (
 * 	member_id INT AUTO_INCREMENT COMMENT '会员编号，自增',
 * 	member_level INT NOT NULL DEFAULT 1 COMMENT '会员等级，最低等级1，最高等级5',
 * 	discount DECIMAL(2,1) NOT NULL DEFAULT 9.5 COMMENT '会员折扣，会员等级1 9.5折...',
 * 	integral DECIMAL(7,2) NOT NULL DEFAULT 0 COMMENT '会员积分',
 *
 * 	`status` INT DEFAULT 1 COMMENT '会员状态 1正常，2 退出会员',
 *
 * 	user_id INT COMMENT '用户编号，外键',
 * 	PRIMARY KEY(member_id),
 * 	FOREIGN KEY(user_id) REFERENCES user_info(user_id)
 * )
 */
public class UserMemberEntity {
    private Integer memberId;
    private Integer memberLevel;
    private BigDecimal discount;
    private BigDecimal integral;
    private Integer status;

    private Integer userId;
    private UserInfoEntity userInfo;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserInfoEntity getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoEntity userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "UserMemberEntity{" +
                "memberId=" + memberId +
                ", memberLevel=" + memberLevel +
                ", discount=" + discount +
                ", integral=" + integral +
                ", status=" + status +
                ", userId=" + userId +
                ", userInfo=" + userInfo +
                '}';
    }
}
