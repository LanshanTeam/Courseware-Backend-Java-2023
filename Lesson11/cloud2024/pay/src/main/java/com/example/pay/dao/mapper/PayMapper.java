package com.example.pay.dao.mapper;

import com.example.pay.dao.entity.Pay;

/**
 * @Author 70ash
 * @Date 2024/3/16 12:27
 * @Description:
 */
public interface PayMapper {
    int insertSelective(Pay pay);
}
