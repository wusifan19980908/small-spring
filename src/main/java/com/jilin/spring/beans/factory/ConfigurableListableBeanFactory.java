package com.jilin.spring.beans.factory;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.config.AutowireCapableBeanFactory;
import com.jilin.spring.beans.factory.config.BeanDefinition;
import com.jilin.spring.beans.factory.config.BeanPostProcessor;
import com.jilin.spring.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Classname ConfigurableListableBeanFactory
 * @Description TODO
 * @Date 2022/2/18 15:59
 * @Created by jilin
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName)throws BeansException;

    /**
     * 初始化所有的bean
     * @throws BeansException
     */
    void preInstantiateSingletons()throws BeansException;

    /**
     * 添加BeanPostProcessor
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
