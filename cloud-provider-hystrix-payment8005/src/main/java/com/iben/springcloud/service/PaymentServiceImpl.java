package com.iben.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 支付逻辑
 *
 * @author Ben <fzyouni@163.com>
 * @create 2021-01-22 15:00
 **/
@Service
@DefaultProperties(defaultFallback = "globalPayInfoFallback")
public class PaymentServiceImpl implements PaymentService {

    @Value("${server.port}")
    private String port;

    @Override
    public String payInfoOk() {
        return "线程池： " + Thread.currentThread().getName()
                + ",port:" + port + " 正常访问！";
    }

    @Override
    /*@HystrixCommand(fallbackMethod = "payInfoFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })*/
    @HystrixCommand
    public String payInfoTimeOut() {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName()
                + "   paymentInfo_OK,port:" + port + " 耗时(秒):" + timeNumber;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),              //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //错误率达到多少跳闸
    })
    public String payInfoCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("****id 不能为负数");
        }
        return String.format("当前线程池:%s,流水号：%s", Thread.currentThread().getName(), UUID.randomUUID());
    }

    public String payInfoFallback() {
        return String.format("当前线程池:%s,当前服务不可用，请稍后再进行尝试！！", Thread.currentThread().getName());
    }

    public String globalPayInfoFallback() {
        return String.format("global当前线程池:%s,当前服务不可用，请稍后再进行尝试！！", Thread.currentThread().getName());
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return String.format("参数不能为负数，id:%d", id);
    }
}
