package com.jilin.spring.beans.factory;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jilin
 * @description 工厂
 * @createTime 2022/2/17 9:57
 */
public interface BeanFactory {
    /**
     * 获取被管理的bean
     * @param name
     * @return
     */
    public Object getBean(String name) throws BeansException;
}
