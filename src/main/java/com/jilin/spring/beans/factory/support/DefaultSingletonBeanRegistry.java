package com.jilin.spring.beans.factory.support;

import com.jilin.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jilin
 * @description [类型描述]
 * @createTime 2022/2/17 10:23
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    /**
     * 根据beanName来存储单例对象
     */
    private Map<String,Object> singletonObjects = new HashMap<>();

    /**
     * 获取单例对象
     * @param beanName
     * @return
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 添加单例对象
     * @param beanName
     * @param singletonObject
     */
    protected  void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName, singletonObject);
    }
}
