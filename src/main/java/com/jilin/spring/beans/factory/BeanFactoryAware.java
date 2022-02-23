package com.jilin.spring.beans.factory;

import com.jilin.spring.beans.BeansException;

/**
 * @Classname BeanFactoryAware
 * @Description TODO
 * @Date 2022/2/23 11:57
 * @Created by jilin
 */
public interface BeanFactoryAware extends Aware{
    /**
     * 实现此接口，能感知到所属的BeanFactory
     * @param beanFactory
     * @throws BeansException
     */
    void setBeanFactory(BeanFactory beanFactory)throws BeansException;
}
