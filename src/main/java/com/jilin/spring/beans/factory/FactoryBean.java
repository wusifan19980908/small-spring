package com.jilin.spring.beans.factory;

/**
 * @Classname FactoryBean
 * @Description TODO
 * @Date 2022/2/23 16:26
 * @Created by jilin
 */
public interface FactoryBean<T> {
    /**
     * 获取bean
     * @return
     * @throws Exception
     */
    T getObject()throws Exception;

    /**
     * 获取bean的类对象
     * @return
     */
    Class<?> getObjectType();

    /**
     * 是否单例
     * @return
     */
    boolean isSingleton();
}
