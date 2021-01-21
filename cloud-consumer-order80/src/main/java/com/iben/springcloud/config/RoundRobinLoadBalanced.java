package com.iben.springcloud.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Ben <fzyouni@163.com>
 * @Desc
 * @Date 2021/1/21 20:40
 */
@Component
public class RoundRobinLoadBalanced implements LoadBalanced {


    private AtomicInteger atomicInteger = new AtomicInteger(0);


    private final int getAndIncrease() {
        int current, next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println(String.format("第%d次访问", next));
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> services) {
        int index = getAndIncrease() % services.size();
        return services.get(index);
    }
}
