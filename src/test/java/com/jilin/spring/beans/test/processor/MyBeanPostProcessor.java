package com.jilin.spring.beans.test.processor;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.config.BeanPostProcessor;
import com.jilin.spring.beans.test.bean.UserService;

/**
 * @Classname MyBeanPostProcessor
 * @Description TODO
 * @Date 2022/2/22 10:53
 * @Created by jilin
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)){
            UserService userService = (UserService) bean;
            userService.setLocation("改为 北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }
}
