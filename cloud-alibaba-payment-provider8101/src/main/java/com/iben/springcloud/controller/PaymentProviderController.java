package com.iben.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/27 22:07
 */
@RestController
public class PaymentProviderController {

    @GetMapping("testA")
    public String testA() {
        return "this is testA";
    }
}
