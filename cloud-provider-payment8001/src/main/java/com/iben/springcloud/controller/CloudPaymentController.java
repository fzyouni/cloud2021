package com.iben.springcloud.controller;


import com.iben.springcloud.entity.CloudPayment;
import com.iben.springcloud.enums.ReturnCodeType;
import com.iben.springcloud.msg.ResponseModel;
import com.iben.springcloud.service.ICloudPaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * <p>
 * 支付表 前端控制器
 * </p>
 *
 * @author fz
 * @since 2021-01-18
 */
@RestController
@RequestMapping("/cloud-payment")
@RefreshScope
public class CloudPaymentController {

    @Resource
    private ICloudPaymentService cloudPaymentService;

    @Value("${server.port}")
    private String port;

    @Value("${config.info}")
    private String info;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping
    public ResponseModel createPayment(String payUser, Double money) {
        int i = this.cloudPaymentService.createPay(payUser, money);
        if (Objects.equals(i, 1)) {
            return ResponseModel.success("支付成功！端口：" + port);
        } else {
            return ResponseModel.error(ReturnCodeType.PARAMETER_VALIDATE_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseModel getPayInfo(@PathVariable Long id) {
        CloudPayment pay = this.cloudPaymentService.getPaymentById(id);
        if (Objects.isNull(pay)) {
            return ResponseModel.error(ReturnCodeType.PARAMETER_VALIDATE_ERROR);
        }
        return ResponseModel.success("查询成功，端口：" + port, pay);
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = this.discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        List<ServiceInstance> instance = this.discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : instance) {
            System.out.println(serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + ":" + serviceInstance.getUri());
        }
        return this.discoveryClient;
    }

    /**
     * 测试是否能拿到配置中心注册的配置
     *
     * @return
     */
    @GetMapping("getConfigValue")
    public ResponseModel getConfigValue() {
        return ResponseModel.success(info + "---UUid:" + UUID.randomUUID());
    }
}
