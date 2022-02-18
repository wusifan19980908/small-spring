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

    /**
     * 获取bean
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name,Object... args)throws BeansException;

    /**
     * 获取bean
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name,Class<T> requiredType) throws BeansException;
}
