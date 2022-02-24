package com.jilin.spring.beans.factory.support;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.DisposableBean;
import com.jilin.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jilin
 * @description [类型描述]
 * @createTime 2022/2/17 10:23
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 空对象
     */
    protected  static final Object NULL_OBJECT = new Object();
    /**
     * 根据beanName来存储单例对象
     */
    private Map<String,Object> singletonObjects = new ConcurrentHashMap<>();
    /**
     * 注册销毁的bean
     */
    private final Map<String, DisposableBean> disposableBeans = new LinkedHashMap<>();

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
     * 注册单例对象
     * @param beanName
     * @param singletonObject
     */
    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName,singletonObject);
    }

    /**
     * 添加单例对象
     * @param beanName
     * @param singletonObject
     */
    protected  void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName, singletonObject);
    }

    /**
     * 存储注册的有销毁方法的bean
     * @param beanName
     * @param bean
     */
    public void registerDisposableBean(String beanName,DisposableBean bean){
        disposableBeans.put(beanName,bean);
    }

    /**
     * 销毁单例对象
     */
    public void destorySingletons(){
        Set<String> keySet = this.disposableBeans.keySet();
        String[] disposableBeanNames = keySet.toArray(new String[0]);

        for (int i = disposableBeanNames.length-1;i>=0;i--){
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.get(beanName);
            try{
                disposableBean.destory();
            }catch (Exception e){
                System.out.println("Destory方法执行失败，bean名称：["+beanName+"]");
            }
        }
    }
}
