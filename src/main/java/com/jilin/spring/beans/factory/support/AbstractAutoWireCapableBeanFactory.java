package com.jilin.spring.beans.factory.support;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.config.BeanDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jilin
 * @description 实现  实例化bean方法抽象类
 * @createTime 2022/2/17 10:22
 */
public abstract class AbstractAutoWireCapableBeanFactory extends AbstractBeanFactory{
    /**
     *实例化注册的beanDefinition
     * @param beanName 实例化后bean的name
     * @param beanDefinition 注册的beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try{
            //实例化bean
            bean = beanDefinition.getBeanClass().newInstance();
            System.out.printf("实例化bean--{%s}\n",beanName);
        } catch (IllegalAccessException|InstantiationException e) {
            throw new BeansException("实例化失败",e);
        }
        //将实例化后的bean添加到单例对象map
        addSingleton(beanName,bean);
        return bean;
    }
}
