package com.iben.springcloud.service;

import com.iben.springcloud.enums.ReturnCodeType;
import com.iben.springcloud.msg.ResponseModel;
import org.springframework.stereotype.Service;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/22 21:47
 */
@Service
public class PaymentServiceFallback implements PaymentService {

    @Override
    public ResponseModel payInfoOk() {
        return ResponseModel.error(ReturnCodeType.NOT_ACCESS_SERVER);
    }

    @Override
    public ResponseModel payInfoTimeOut() {
        return ResponseModel.error(ReturnCodeType.NOT_ACCESS_SERVER);
    }
}
