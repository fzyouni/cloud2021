package com.iben.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/20 22:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZKOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ZKOrderMain80.class, args);
    }
}
