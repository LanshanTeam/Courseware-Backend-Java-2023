package com.example.order.dto.req;

import lombok.Data;
import lombok.ToString;

/**
 * @Author 70ash
 * @Date 2024/3/23 14:02
 * @Description:
 */
@Data
@ToString
public class PayReqDTO {
    //支付流水号
    private String payNo;
    //订单流水号
    private String orderNo;
    // 用户id
    private Integer userId;
    //交易金额
    private Double amount;
}
