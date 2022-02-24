package com.jilin.spring.beans.test.bean;

import com.jilin.spring.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ProxyBeanFactory
 * @Description TODO
 * @Date 2022/2/24 10:13
 * @Created by jilin
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {
    @Override
    public IUserDao getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            Map<String,String> map = new HashMap<>();
            map.put("10001","sifan");
            map.put("10002","jilin");
            map.put("10003","xuye");
            return "你被代理了"+method.getName()+":"+map.get(args[0].toString());
        };
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class},handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
