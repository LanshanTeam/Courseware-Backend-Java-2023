package com.example.order.controller;


import com.example.order.dto.req.PayReqDTO;
import com.example.order.service.OrderService;
import com.exmple.common.convention.result.Result;
import com.exmple.common.convention.result.Results;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @auther zzyy
 * @create 2023-11-04 16:00
 */
@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController{
    private OrderService orderService;

    @PostMapping("/add")
    public Result addOrder(@RequestBody PayReqDTO payDTO){
        return Results.success(orderService.addOrder(payDTO));
    }
}