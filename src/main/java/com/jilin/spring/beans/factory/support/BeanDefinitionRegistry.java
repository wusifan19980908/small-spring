package com.jilin.spring.beans.factory.support;

import com.jilin.spring.beans.factory.config.BeanDefinition;

/**
 * @author jilin
 * @description 注册beanDefinition接口
 * @createTime 2022/2/17 10:22
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册beanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
