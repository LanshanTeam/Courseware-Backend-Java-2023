package com.example.order.service;

import com.example.order.dto.req.PayReqDTO;

/**
 * @Author 70ash
 * @Date 2024/3/23 13:55
 * @Description:
 */
public interface OrderService {
    Integer addOrder(PayReqDTO payDTO);
}
