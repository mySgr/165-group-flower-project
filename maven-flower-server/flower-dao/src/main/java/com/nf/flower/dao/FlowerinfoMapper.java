package com.nf.flower.dao;


import com.nf.flower.entity.commodity.FLowerInfoSelectShoppingEntity;
import com.nf.flower.entity.commodity.FlowerinfoEntity;
import org.apache.ibatis.annotations.Param;


import java.math.BigDecimal;
import java.util.List;

public interface FlowerinfoMapper {
    int addFlowerInfo(FlowerinfoEntity entity);

    List<FlowerinfoEntity> hotFlowerInfo();

    FlowerinfoEntity  selectFlowerInfo( int flowerId);





}
