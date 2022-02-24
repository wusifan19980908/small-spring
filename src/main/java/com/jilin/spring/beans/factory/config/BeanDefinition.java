package com.jilin.spring.beans.factory.config;

import com.jilin.spring.beans.PropertyValues;
import com.jilin.spring.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author jilin
 * @description 类定义
 * @createTime 2022/2/17 9:57
 */
public class BeanDefinition {
    String SCOPE_SINGLETON = ConfigurableListableBeanFactory.SCOPE_SINGLETON;
    String SCOPE_PROTOTYPE = ConfigurableListableBeanFactory.SCOPE_PROTOTYPE;

    /**
     * 类模板
     */
    private Class beanClass;
    /**
     * 属性集合
     */
    private PropertyValues propertyValues;
    /**
     * 初始化方法名
     */
    private String initMethodName;
    /**
     * 销毁方法名
     */
    private String destroyMethodName;
    /**
     * 作用域
     */
    private String scope = SCOPE_SINGLETON;
    /**
     * 是否为原型
     */
    private boolean singleton = true;

    private boolean prototype = false;

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

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    public boolean isSingleton() {
        return singleton;
    }

    public void setSingleton(boolean singleton) {
        this.singleton = singleton;
    }

    public boolean isPrototype() {
        return prototype;
    }

    public void setPrototype(boolean prototype) {
        this.prototype = prototype;
    }
}
