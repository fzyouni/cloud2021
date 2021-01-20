package com.iben.springcloud.controller;

import com.iben.springcloud.msg.ResponseModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/20 21:16
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("createPayment")
    public ResponseModel createPayment() {
        return ResponseModel.success("请求成功，端口为：" + port);
    }

}
