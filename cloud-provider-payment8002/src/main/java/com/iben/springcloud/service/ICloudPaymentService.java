package com.iben.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iben.springcloud.entity.CloudPayment;

/**
 * <p>
 * 支付表 服务类
 * </p>
 *
 * @author fz
 * @since 2021-01-18
 */
public interface ICloudPaymentService extends IService<CloudPayment> {


    int createPay(String payUser, Double money);

    CloudPayment getPaymentById(Long id);

}
