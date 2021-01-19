package com.iben.springcloud.enums;


/**
 * 枚举基础方法
 *
 * @author Ben
 * @version 1.0
 * @date 2019/4/28 14:55
 */
public interface BaseEnum {
    /**
     * 获取枚举的值
     *
     * @return 获取枚举的值
     */
    String getValue();

    /**
     * 获取枚举的key
     *
     * @return 获取枚举的key
     */
    String getKey();

    /**
     * 给枚举设置value
     *
     * @param value 要设置的值
     * @return 返回整个枚举
     */
    BaseEnum setValue(String value);
}
