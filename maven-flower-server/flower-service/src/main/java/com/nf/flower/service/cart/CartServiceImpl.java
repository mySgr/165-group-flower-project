package com.nf.flower.service.cart;

import com.nf.flower.dao.ShopingMapper;
import com.nf.flower.entity.commodity.Cart;
import com.nf.flower.entity.commodity.CartItem;
import com.nf.flower.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl {

    public List<CartItem> getCartItem(int id) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            final ShopingMapper mapper = sqlSession.getMapper(ShopingMapper.class);
            return mapper.getCartItemByCartMasterId(id);
        }
    }

    //根据用户编号查看他的购物车
    public Cart getCartByUserId(int userId) {
        CartServiceImpl cartService = new CartServiceImpl();
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {

            final ShopingMapper mapper = sqlSession.getMapper(ShopingMapper.class);
            Cart cart = mapper.getCartByUserId(userId);
            // 用户购物车不存在创建一个给他
            if (cart == null) {
                cartService.addCartMaster(userId);
                cart = mapper.getCartByUserId(userId);
            }
            cart.setList(cartService.getCartItem(cart.getCartMasterId()));

            return cart;

        }
    }

    public int addCartMaster(int userId) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            final ShopingMapper mapper = sqlSession.getMapper(ShopingMapper.class);
            return mapper.addCartMaster(userId);
        }
    }

    public int addCartItem(CartItem cartItem) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            final ShopingMapper mapper = sqlSession.getMapper(ShopingMapper.class);

            return mapper.addCartItem(cartItem);
        }
    }


    public int updateCountAndCartPrice(CartItem cartItem) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            ShopingMapper mapper = sqlSession.getMapper(ShopingMapper.class);
            return mapper.updateCountAndCartPrice(cartItem);
        }
    }


    public int updateCartStatus(int status, int id) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            ShopingMapper mapper = sqlSession.getMapper(ShopingMapper.class);
            return mapper.updateCartStatus(status, id);
        }
    }

    // 查询结算的购物项
    public Cart getCartInfoByCartId(int[] ids) {
        Cart cart = new Cart();
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            ShopingMapper mapper = sqlSession.getMapper(ShopingMapper.class);

            List<CartItem> cartItems = mapper.getCartInfoByCartId(ids);
            BigDecimal price = new BigDecimal("0");
            for (int i = 0; i < cartItems.size(); i++) {
                price = price.add(cartItems.get(i).getCartPrice());
            }
            cart.setList(cartItems);
            cart.setTotalPrice(price);

            return cart;
        }
    }

    // 全部的
    public int updateCartStatusAll(List<CartItem> list, int status) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            ShopingMapper mapper = sqlSession.getMapper(ShopingMapper.class);
            return mapper.updateCartStatusAll(list, status);
        }
    }

    public static void main(String[] args) {
        final CartServiceImpl cartService = new CartServiceImpl();



    }
}
