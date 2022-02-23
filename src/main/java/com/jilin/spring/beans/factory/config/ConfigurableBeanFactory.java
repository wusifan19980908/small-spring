package com.jilin.spring.beans.factory.config;

import com.jilin.spring.beans.factory.HierarchicalBeanFactory;

/**
 * @Classname ConfigurableBeanFactory
 * @Description TODO
 * @Date 2022/2/18 15:56
 * @Created by jilin
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory,SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    /**
     * 添加PostProcessor
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
