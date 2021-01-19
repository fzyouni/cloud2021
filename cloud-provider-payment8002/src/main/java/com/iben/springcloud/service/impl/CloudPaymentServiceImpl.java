package com.iben.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iben.springcloud.entity.CloudPayment;
import com.iben.springcloud.mapper.CloudPaymentMapper;
import com.iben.springcloud.service.ICloudPaymentService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 * 支付表 服务实现类
 * </p>
 *
 * @author fz
 * @since 2021-01-18
 */
@Service
public class CloudPaymentServiceImpl extends ServiceImpl<CloudPaymentMapper, CloudPayment> implements ICloudPaymentService {

    @Override
    public int createPay(String payUser, Double money) {
        CloudPayment payment = new CloudPayment();
        payment.setPayUser(payUser);
        payment.setPayMoney(new BigDecimal(money));
        return this.baseMapper.insert(payment);
    }

    @Override
    public CloudPayment getPaymentById(Long id) {
        return this.baseMapper.selectById(id);
    }
}
