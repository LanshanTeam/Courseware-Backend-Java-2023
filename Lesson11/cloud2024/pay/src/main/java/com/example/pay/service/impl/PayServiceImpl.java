package com.example.pay.service.impl;

import com.example.pay.dto.req.PayReqDTO;
import com.example.pay.service.PayService;
import com.exmple.common.convention.result.Result;
import com.exmple.common.util.RandomNumberGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
@AllArgsConstructor
public class PayServiceImpl implements PayService
{
    // public static final String PaymentSrv_URL = "http://localhost:8001";
    public static final String PaymentSrv_URL = "http://order8001";// 先写死
    private RestTemplate restTemplate;

    @Override
    public Result add(Double amount)
    {
        PayReqDTO payReqDTO = new PayReqDTO();
        int i = RandomNumberGenerator.generateSixDigitNumber();
        String payNo = "pay-" + i;
        log.info("支付服务流水号：" +  payNo);
        payReqDTO.setPayNo(payNo);
        payReqDTO.setAmount(amount);
        return restTemplate.postForObject(PaymentSrv_URL + "/order/add", payReqDTO, Result.class);
    }

}
