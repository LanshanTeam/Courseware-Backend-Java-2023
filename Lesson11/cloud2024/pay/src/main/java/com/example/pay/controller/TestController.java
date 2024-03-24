package com.example.pay.controller;

import cn.hutool.core.date.DateUtil;
import com.exmple.common.convention.result.Result;
import com.exmple.common.convention.result.Results;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Enumeration;

/**
 * @Author 70ash
 * @Date 2024/3/23 21:21
 * @Description:
 */
@RestController
public class TestController {
    @GetMapping("/gateway/test")
    public Result testGateway() {
        return Results.success(new Date());
    }

    @GetMapping(value = "/pay/gateway/filter")
    public Result<String> getGatewayFilter(HttpServletRequest request)
    {
        String result = "";
        Enumeration<String> headers = request.getHeaderNames();
        while(headers.hasMoreElements())
        {
            String headName = headers.nextElement();
            String headValue = request.getHeader(headName);
            System.out.println("请求头名: " + headName +"\t\t\t"+"请求头值: " + headValue);
            if(headName.equalsIgnoreCase("color1")
                    || headName.equalsIgnoreCase("color2")) {
                result = result+headName + "\t " + headValue +" ";
            }
        }
        return Results.success("getGatewayFilter 过滤器: "+result+ "\t" + DateUtil.now());
    }
}
