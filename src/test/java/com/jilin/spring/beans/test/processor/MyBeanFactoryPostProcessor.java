package com.jilin.spring.beans.test.processor;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.PropertyValue;
import com.jilin.spring.beans.PropertyValues;
import com.jilin.spring.beans.factory.ConfigurableListableBeanFactory;
import com.jilin.spring.beans.factory.config.BeanDefinition;
import com.jilin.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.jilin.spring.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Classname MyBeanFactoryPostProcessor
 * @Description TODO
 * @Date 2022/2/22 10:49
 * @Created by jilin
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company","改为：rzyc"));
    }
}
