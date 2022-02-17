package com.jilin.spring.beans.factory.config;

/**
 * @author jilin
 * @description 类定义
 * @createTime 2022/2/17 9:57
 */
public class BeanDefinition {
    /**
     * 类模板
     */
    private Class beanClass;

    public  BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }
}
