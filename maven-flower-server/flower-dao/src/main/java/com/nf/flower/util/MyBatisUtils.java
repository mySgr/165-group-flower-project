package com.nf.flower.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

// mybatis 的工具类
public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    public static final String MYBATIS_CONFIG_FILE = "mybatis-config.xml";

    static {
       try (  InputStream resourceAsStream = Resources.getResourceAsStream(MYBATIS_CONFIG_FILE)){
           sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true); // 设置自动提交
    }

    public static void main(String[] args) {
        System.out.println(getSqlSession());
    }
}
