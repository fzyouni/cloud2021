package com.iben.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/22 23:03
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardMain9001.class, args);
    }
}
