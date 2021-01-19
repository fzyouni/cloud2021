package com.iben.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/19 20:47
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain7001.class, args);
    }
}
