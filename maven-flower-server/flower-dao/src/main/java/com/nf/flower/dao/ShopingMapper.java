package com.nf.flower.dao;

import com.nf.flower.entity.commodity.FLowerInfoSelectShoppingEntity;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ShopingMapper {

    int deleteFlower(int cartId);

    List<FLowerInfoSelectShoppingEntity> selectShopping(@Param("userId") int userId);

    void  addShopping(@Param("userId") int userId,
                      @Param("flowerID") int flowerID,
                      @Param("productAmount") int productAmount,
                      @Param("price") BigDecimal price);


}
