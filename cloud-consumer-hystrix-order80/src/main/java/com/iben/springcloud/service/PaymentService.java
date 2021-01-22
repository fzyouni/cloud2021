package com.iben.springcloud.service;


import com.iben.springcloud.msg.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "cloud-provider-hystrix-payment")
public interface PaymentService {

    @GetMapping("/payment/payInfoOk")
    ResponseModel payInfoOk();

    @GetMapping("/payment/payInfoTimeOut")
    ResponseModel payInfoTimeOut();
}
