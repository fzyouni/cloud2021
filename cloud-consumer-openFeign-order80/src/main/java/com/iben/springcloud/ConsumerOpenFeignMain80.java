package com.iben.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/21 22:07
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerOpenFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenFeignMain80.class, args);
    }
}
