package com.nf.flower.service.commodity;

import com.nf.flower.dao.FlowerinfoMapper;
import com.nf.flower.dao.ShopingMapper;
import com.nf.flower.entity.commodity.FLowerInfoSelectShoppingEntity;
import com.nf.flower.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.util.List;

public class FlowerShoppingImpl {
    //拿取三表的左表连接数据，查询到购物车
    public List<FLowerInfoSelectShoppingEntity> selectShopping(int userId){
        try(SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            ShopingMapper mapper=sqlSession.getMapper(ShopingMapper.class);
            List<FLowerInfoSelectShoppingEntity> list=mapper.selectShopping(userId);
            return list;
        }
    }
//添加购物车
public void addShopping(int userId, int flowerID, int productAmount, BigDecimal price){
    try(SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
        ShopingMapper mapper=sqlSession.getMapper(ShopingMapper.class);
        mapper.addShopping(userId,flowerID,productAmount,price);
    }
}
//根据购物车id来删除购物车当中的物品
    public int deleteFlower(int cartId){
        try(SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            ShopingMapper mapper=sqlSession.getMapper(ShopingMapper.class);
            mapper.deleteFlower(cartId);
          return cartId;
        }
    }
    public static void main(String[] args) {
        FlowerShoppingImpl flowerShopping=new FlowerShoppingImpl();
        flowerShopping.deleteFlower(1);
    }
}
