package com.iben.springcloud.controller;

import com.iben.springcloud.config.LoadBalanced;
import com.iben.springcloud.enums.ReturnCodeType;
import com.iben.springcloud.msg.ResponseModel;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/18 22:54
 */
@RestController
@RequestMapping("/consumer/order")
public class OrderController {

    private static final String URL = "http://CLOUD-PAYMENT-SERVICE/cloud-payment";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalanced loadBalanced;

    @PostMapping
    public ResponseModel generateOrder(String payUser, Double money) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("payUser", payUser);
        params.add("money", money.toString());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        return this.restTemplate.postForEntity(URL, request, ResponseModel.class).getBody();
    }

    @GetMapping("{id}")
    public ResponseModel getOrderInfo(@PathVariable Long id) {
        return this.restTemplate.getForObject(URL + "/" + id, ResponseModel.class);
    }

    @GetMapping("selfGetOrder")
    public ResponseModel selfGetOrder(Long id) {
        List<ServiceInstance> services = this.discoveryClient.getInstances("cloud-payment-service");
        if (CollectionUtils.isEmpty(services)) {
            return ResponseModel.error(ReturnCodeType.RETURN_NULL_ERROR, "未查找到可用的服务！");
        }
        ServiceInstance service = this.loadBalanced.instance(services);
        String url = service.getUri() + "/cloud-payment/" + id;
        System.out.println(url);
        RestTemplate restTemplate1 = new RestTemplate();
        return restTemplate1.getForObject(url, ResponseModel.class);
    }
}
