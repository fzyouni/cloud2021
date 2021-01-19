package com.iben.springcloud.controller;


import com.iben.springcloud.entity.CloudPayment;
import com.iben.springcloud.enums.ReturnCodeType;
import com.iben.springcloud.msg.ResponseModel;
import com.iben.springcloud.service.ICloudPaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

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
public class CloudPaymentController {

    @Resource
    private ICloudPaymentService cloudPaymentService;

    @Value("${server.port}")
    private String port;

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

}
