package com.nf.flower.service;

import com.nf.flower.dao.UserRoleMapper;
import com.nf.flower.entity.UserRoleEntity;
import com.nf.flower.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserRoleServiceImpl {
    public List<UserRoleEntity> getUserRole() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            final UserRoleMapper mapper = sqlSession.getMapper(UserRoleMapper.class);
            return mapper.getUserRole();
        }
    }

    public static void main(String[] args) {
        final List<UserRoleEntity> userRole = new UserRoleServiceImpl().getUserRole();
        userRole.forEach(s-> System.out.println(s));
    }
}
