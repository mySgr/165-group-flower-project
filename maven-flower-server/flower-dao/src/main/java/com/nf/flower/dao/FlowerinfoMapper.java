package com.nf.flower.dao;


import com.nf.flower.entity.commodity.FlowerinfoEntity;


import java.util.List;

public interface FlowerinfoMapper {
    int addFlowerInfo(FlowerinfoEntity entity);

    List<FlowerinfoEntity> hotFlowerInfo();

    FlowerinfoEntity  selectFlowerInfo( int flowerId);
}
