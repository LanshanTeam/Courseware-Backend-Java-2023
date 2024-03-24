package com.example.order.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.example.order.dao.entity.Pay;
import com.example.order.dao.mapper.OrderMapper;
import com.example.order.dto.req.PayReqDTO;
import com.example.order.service.OrderService;
import com.exmple.common.util.RandomNumberGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author 70ash
 * @Date 2024/3/23 13:55
 * @Description:
 */
@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;
    @Override
    public Integer addOrder(PayReqDTO payDTO) {
        int i = RandomNumberGenerator.generateSixDigitNumber();
        String orderNo = "order-" + i;
        payDTO.setOrderNo(orderNo);
        log.info("订单号：" + orderNo);
        //TODO 后续从网关中获得用户id
        int i1 = RandomNumberGenerator.generateRandomNumber();
        payDTO.setUserId(i1);

        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO, pay);
        return orderMapper.insert(pay);
    }
}
