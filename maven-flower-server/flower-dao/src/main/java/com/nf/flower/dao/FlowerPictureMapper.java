package com.nf.flower.dao;

import com.nf.flower.entity.commodity.FlowerPictureEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlowerPictureMapper {
    int addFlowerPicture(FlowerPictureEntity entity);
    List<FlowerPictureEntity> getFlowerPictureListByFlowerId(@Param("flowerId") int flowerId);
}
