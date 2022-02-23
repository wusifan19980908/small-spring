package com.jilin.spring.beans.factory.config;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.BeanFactory;

/**
 * @Classname AutowireCapableBeanFactory
 * @Description TODO
 * @Date 2022/2/18 15:56
 * @Created by jilin
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    /**
     * 执行beanPostProcessors接口实现的postProcessBeforeInitialization方法
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean,String beanName)throws BeansException;

    /**
     * 执行beanPostProcessors接口实现类的postProcessorsInitialization方法
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean,String beanName)throws BeansException;
}
