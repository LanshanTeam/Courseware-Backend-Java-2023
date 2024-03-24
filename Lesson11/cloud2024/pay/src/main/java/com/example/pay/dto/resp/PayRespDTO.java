package com.example.pay.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 70ash
 * @Date 2024/3/16 12:29
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayRespDTO {
        private Integer id;
        //支付流水号
        private String payNo;
        //订单流水号
        private String orderNo;
        //用户账号ID
        private Integer userId;
        //交易金额
        private Double amount;
}
