package com.iben.springcloud.controller;

import com.iben.springcloud.msg.ResponseModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/18 22:54
 */
@RestController
@RequestMapping("/consumer/order")
public class OrderController {

    private static final String URL = "http://localhost:8001/cloud-payment";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseModel generateOrder(String payUser, Double money) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> params = new HashMap<>();
        params.put("payUser", payUser);
        params.put("money", money);
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(params, headers);
        return this.restTemplate.postForEntity(URL, request, ResponseModel.class).getBody();
    }

    @GetMapping("{id}")
    public ResponseModel getOrderInfo(@PathVariable Long id) {
        return this.restTemplate.getForObject(URL + "/" + id, ResponseModel.class);
    }
}
