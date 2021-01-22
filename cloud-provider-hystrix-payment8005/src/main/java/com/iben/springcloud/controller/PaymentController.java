package com.iben.springcloud.controller;

import com.iben.springcloud.msg.ResponseModel;
import com.iben.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 支付前端控制器
 *
 * @author Ben <fzyouni@163.com>
 * @create 2021-01-22 14:53
 **/
@RestController
public class PaymentController {


    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/payInfoOk")
    public ResponseModel payInfoOk() {
        return ResponseModel.success(this.paymentService.payInfoOk());
    }

    @GetMapping("/payment/payInfoTimeOut")
    public ResponseModel payInfoTimeOut() {
        return ResponseModel.success(this.paymentService.payInfoTimeOut());
    }

    @GetMapping("/payment/circuit/payInfo/{id}")
    public ResponseModel payInfoCircuitBreaker(@PathVariable("id") Integer id) {
        return ResponseModel.success(this.paymentService.payInfoCircuitBreaker(id));
    }
}
