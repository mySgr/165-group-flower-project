package com.nf.flower.dao;

import com.nf.flower.entity.commodity.FlowerinfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlowerinfoMapper {
    int addFlowerInfo(FlowerinfoEntity entity);

    List<FlowerinfoEntity> hotFlowerInfo();

    FlowerinfoEntity selectFlowerInfo(int flowerId);


    int updateFlowerStatus(@Param("id") int id, @Param("status") int status);

    int updateFlowerInfoById(FlowerinfoEntity entity);

    FlowerinfoEntity qeruyFlowerInfoById(@Param("flowerId") int flowerId);

    List<FlowerinfoEntity> flowerInfoQueryList(@Param("query") String query,
                                               @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
