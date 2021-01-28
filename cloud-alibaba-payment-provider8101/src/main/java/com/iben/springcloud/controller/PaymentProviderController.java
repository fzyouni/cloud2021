package com.iben.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 测试sentinel的热点限流
     *
     * @param key
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        System.out.println("testHotKey");
        return "----testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        System.out.println("deal_testHotKey");
        return "----deal_testHotKey, o(╥﹏╥)o"; // sentinel的默认提示都是： Blocked by Sentinel (flow limiting)
    }
}
