package com.iben.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Ben <fzyouni@163.com>
 * @create 2021-01-22 14:43
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixPaymentMain8005 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentMain8005.class, args);
    }
}
