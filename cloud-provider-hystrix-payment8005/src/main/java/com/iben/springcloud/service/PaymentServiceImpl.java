package com.iben.springcloud.service;

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
public class PaymentServiceImpl implements PaymentService {

    @Value("${server.port}")
    private String port;

    @Override
    public String payInfoOk() {
        return "线程池： " + Thread.currentThread().getName()
                + ",port:" + port + " 正常访问！";
    }

    @Override
    @HystrixCommand(fallbackMethod = "payInfoFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
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
        return "当前访问服务超时，请稍后再尝试！！！";
    }
}
