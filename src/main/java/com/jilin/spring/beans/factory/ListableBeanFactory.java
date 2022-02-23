package com.jilin.spring.beans.factory;

import com.jilin.spring.beans.BeansException;

import java.util.Map;

/**
 * @Classname ListableBeanFactory
 * @Description TODO
 * @Date 2022/2/18 15:59
 * @Created by jilin
 */
public interface ListableBeanFactory extends BeanFactory{
    /**
     * 按照类型返回Bean实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String,T> getBeansOfType(Class<T> type)throws BeansException;

    /**
     * 返回注册表中的所有bean名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
