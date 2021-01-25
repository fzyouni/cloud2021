package com.iben.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/25 22:14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8101 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8101.class, args);
    }
}
