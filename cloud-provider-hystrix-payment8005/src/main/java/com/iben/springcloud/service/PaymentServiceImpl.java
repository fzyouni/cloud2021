package com.iben.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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


    public String payInfoFallback() {
        return String.format("当前线程池:%s,当前服务不可用，请稍后再进行尝试！！", Thread.currentThread().getName());
    }

    public String globalPayInfoFallback() {
        return String.format("global当前线程池:%s,当前服务不可用，请稍后再进行尝试！！", Thread.currentThread().getName());
    }
}
