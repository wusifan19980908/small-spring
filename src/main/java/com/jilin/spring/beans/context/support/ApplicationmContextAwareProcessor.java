package com.jilin.spring.beans.context.support;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.context.ApplicationContext;
import com.jilin.spring.beans.context.ApplicationContextAware;
import com.jilin.spring.beans.factory.config.BeanPostProcessor;

/**
 * @Classname ApplicationmContextAwareProcessor
 * @Description TODO
 * @Date 2022/2/23 14:03
 * @Created by jilin
 */
public class ApplicationmContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationmContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
