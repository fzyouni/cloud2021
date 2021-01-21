package com.iben.springcloud.controller;

import com.iben.springcloud.msg.ResponseModel;
import com.iben.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/21 22:11
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("{id}")
    public ResponseModel getOrderInfo(@PathVariable("id") Long id) {
        return this.paymentFeignService.getPayInfo(id);
    }
}
