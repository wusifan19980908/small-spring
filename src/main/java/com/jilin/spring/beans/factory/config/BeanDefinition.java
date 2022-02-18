package com.jilin.spring.beans.factory.config;

import com.jilin.spring.beans.PropertyValues;

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
    /**
     * 属性集合
     */
    private PropertyValues propertyValues;


    public  BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues !=null?propertyValues:new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
