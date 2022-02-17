package com.jilin.spring.beans.factory.support;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.BeanFactory;
import com.jilin.spring.beans.factory.config.BeanDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jilin
 * @description 模板类，实现获取bean的方法，同时定义getBean方法的执行顺序
 * @createTime 2022/2/17 10:22
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    private Logger logger = LoggerFactory.getLogger(AbstractBeanFactory.class);
    /**
     * 获取bean，实现BeanFactory中的方法
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        //从单例对象池中获取对象
        Object bean = getSingleton(name);
        if (bean!=null){
            return bean;
        }
        //获取到bean为空的话则进行创建
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition)throws BeansException;
}
