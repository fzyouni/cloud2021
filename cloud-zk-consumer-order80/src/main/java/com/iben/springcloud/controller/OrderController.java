package com.iben.springcloud.controller;

import com.iben.springcloud.msg.ResponseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/20 22:35
 */
@RestController
@RequestMapping("order")
public class OrderController {


    private static final String URL = "http://cloud-zk-provider-payment/payment/createPayment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("orderPay")
    public ResponseModel orderPay() {
        return this.restTemplate.getForObject(URL, ResponseModel.class);
    }
}
