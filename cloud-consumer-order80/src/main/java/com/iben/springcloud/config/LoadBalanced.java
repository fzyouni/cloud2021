package com.iben.springcloud.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/21 20:38
 */
public interface LoadBalanced {

    ServiceInstance instance(List<ServiceInstance> services);
}
