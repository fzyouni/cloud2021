package com.iben.springcloud.controller;

import com.iben.springcloud.msg.ResponseModel;
import com.iben.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 消费者controller
 *
 * @author Ben <fzyouni@163.com>
 * @create 2021-01-22 16:54
 **/
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("payInfoOk")
    public ResponseModel payInfoOk() {
        return this.paymentService.payInfoOk();
    }

    @GetMapping("payInfoTimeOut")
    public ResponseModel payInfoTimeOut() {
        return this.paymentService.payInfoTimeOut();
    }

}
