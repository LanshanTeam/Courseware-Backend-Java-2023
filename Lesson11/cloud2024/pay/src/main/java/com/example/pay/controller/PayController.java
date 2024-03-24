package com.example.pay.controller;


import com.example.pay.service.PayService;
import com.exmple.common.convention.result.Result;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 70ash
 * @Date 2024/3/16 18:28
 * @Description:
 */
@RestController
@RequestMapping("/pay")
@AllArgsConstructor
@Slf4j
public class PayController {
    @Resource
    private PayService payService;
    @PostMapping(value = "/add")
    public Result<String> addPay(@RequestParam("amount") double amount)
    {
        return payService.add(amount);
    }
}
