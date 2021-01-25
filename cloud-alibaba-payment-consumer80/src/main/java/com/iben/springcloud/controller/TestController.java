package com.iben.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/25 22:37
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${config.info}")
    private String info;

    @GetMapping("getConfigInfo")
    public String getConfigInfo() {
        return info;
    }
}
