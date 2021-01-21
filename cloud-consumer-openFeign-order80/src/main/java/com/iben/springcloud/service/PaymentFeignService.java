package com.iben.springcloud.service;

import com.iben.springcloud.msg.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/21 22:08
 */
@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {

    @GetMapping("/cloud-payment/{id}")
    ResponseModel getPayInfo(@PathVariable("id") Long id);
}
