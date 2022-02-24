package com.jilin.spring.beans.factory.support;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Classname FactoryBeanRegistrySupport
 * @Description TODO
 * @Date 2022/2/23 16:25
 * @Created by jilin
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry{
    /**
     * 存放单例对象缓存
     */
    private final Map<String,Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    /**
     * 获取缓存的对象
     * @param beanName
     * @return
     */
    protected Object getCachedObjectForFactoryBean(String beanName){
        Object object = this.factoryBeanObjectCache.get(beanName);
        return (object!=NULL_OBJECT?object:null);
    }

    /**
     * 从缓存中获取bean
     * @param factory
     * @param beanName
     * @return
     * @throws BeansException
     */
    protected Object getObjectFromFactoryBean(FactoryBean factory,String beanName) throws BeansException {
        if (factory.isSingleton()){
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object==null){
                object = doGetObjectFromFactoryBean(factory,beanName);
                this.factoryBeanObjectCache.put(beanName,(object!=NULL_OBJECT?object:null));
            }
            return (object!=NULL_OBJECT?object:null);
        }else{
            return doGetObjectFromFactoryBean(factory,beanName);
        }
    }

    /**
     * 获取bean对象
     * @param factory
     * @param beanName
     * @return
     * @throws BeansException
     */
    private Object doGetObjectFromFactoryBean(final FactoryBean factory,final String beanName) throws BeansException {
        try{
            return factory.getObject();
        }catch (Exception e){
            throw new BeansException("FactoryBean threw exception on object ["+beanName+"] creation",e);
        }
    }
}
