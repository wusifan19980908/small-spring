package com.jilin.spring.beans.factory.config;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Classname BeanFactoryPostProcessor
 * @Description TODO
 * @Date 2022/2/21 10:02
 * @Created by jilin
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的beanDefinition加载完成后，实例化bean之前，提供修改beanDefinition属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)throws BeansException;
}
