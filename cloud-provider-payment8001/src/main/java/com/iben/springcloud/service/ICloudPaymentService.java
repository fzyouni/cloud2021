package com.iben.springcloud.service;

import com.iben.springcloud.entity.CloudPayment;
import com.baomidou.mybatisplus.extension.service.IService;

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
