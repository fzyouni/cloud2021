package com.iben.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/18 21:16
 */
@SpringBootApplication
@MapperScan("com.iben.springcloud.mapper")
public class PaymentMain001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain001.class, args);
    }
}
