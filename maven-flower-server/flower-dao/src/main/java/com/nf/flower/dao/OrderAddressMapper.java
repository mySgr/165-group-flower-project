package com.nf.flower.dao;

import com.nf.flower.entity.UserAddressEntity;

import java.util.List;

public interface OrderAddressMapper {
    List<UserAddressEntity> getUserAddressEntity(int userId);
}
