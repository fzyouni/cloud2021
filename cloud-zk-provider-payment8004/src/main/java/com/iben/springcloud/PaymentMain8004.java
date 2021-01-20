package com.iben.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/20 21:13
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于使用consul和zookeeper作为服务注册中心时使用
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
