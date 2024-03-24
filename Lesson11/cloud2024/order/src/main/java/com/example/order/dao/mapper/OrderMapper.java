package com.example.order.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.order.dao.entity.Pay;
import com.example.order.dto.req.PayReqDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 70ash
 * @Date 2024/3/23 14:00
 * @Description:
 */
@Mapper
public interface OrderMapper extends BaseMapper<Pay>{
    Integer insertSelective(PayReqDTO payDTO);
}
