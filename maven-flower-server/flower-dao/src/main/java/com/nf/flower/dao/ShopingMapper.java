package com.nf.flower.dao;

import com.nf.flower.entity.commodity.Cart;
import com.nf.flower.entity.commodity.CartItem;
import com.nf.flower.entity.commodity.FLowerInfoSelectShoppingEntity;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ShopingMapper {

    int deleteFlower(int cartId);

    List<FLowerInfoSelectShoppingEntity> selectShopping(@Param("userId") int userId);

    void addShopping(@Param("userId") int userId,
                     @Param("flowerID") int flowerID,
                     @Param("productAmount") int productAmount,
                     @Param("price") BigDecimal price);


    Cart getCartByUserId(@Param("userId") int userId);

    List<CartItem> getCartItemByCartMasterId(int id);

    int addCartMaster(int userId);

    int addCartItem(CartItem cartItem);


    int updateCountAndCartPrice(CartItem cartItem);


    int updateCartStatus(@Param("status") int status, @Param("id") int id);

    int updateCartStatusAll(@Param("list") List<CartItem> list, @Param("status") int status);
}
