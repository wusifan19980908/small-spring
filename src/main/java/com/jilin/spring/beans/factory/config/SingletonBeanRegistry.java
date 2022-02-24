package com.jilin.spring.beans.factory.config;

/**
 * @author jilin
 * @description 获取单例对象接口
 * @createTime 2022/2/17 10:21
 */
public interface SingletonBeanRegistry {
    /**
     * 根据beanName获取单例对象
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

    /**
     * 注册单例对象
     * @param beanName
     * @param singletonObject
     */
    void registerSingleton(String beanName,Object singletonObject);
}
