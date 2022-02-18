package com.jilin.spring.beans.factory.support;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Classname InstantiationStrategy
 * @Description TODO
 * @Date 2022/2/17 15:06
 * @Created by jilin
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,Object[] args)throws BeansException;
}
