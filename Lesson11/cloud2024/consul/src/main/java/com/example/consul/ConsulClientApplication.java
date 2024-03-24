package com.example.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 70ash
 * @Date 2024/3/23 19:36
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient //代表这是服务注册中心的一个客户端，通用的服务注册注解 可以表示consul、zk、nacos 具体根据导入的依赖判断
public class ConsulClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulClientApplication.class,args);
    }
}

