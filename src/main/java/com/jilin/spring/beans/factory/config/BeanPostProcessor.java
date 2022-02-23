package com.jilin.spring.beans.factory.config;

import com.jilin.spring.beans.BeansException;

/**
 * @Classname BeanPostProcessor
 * @Description TODO
 * @Date 2022/2/21 10:02
 * @Created by jilin
 */
public interface BeanPostProcessor {
    /**
     * 在bean对象执行初始化方法之前,执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean,String beanName)throws BeansException;

    /**
     * 在bean对象执行初始化方法之后，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean,String beanName)throws BeansException;
}
