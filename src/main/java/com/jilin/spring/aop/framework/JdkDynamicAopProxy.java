package com.jilin.spring.aop.framework;

import com.jilin.spring.aop.AdvisedSupport;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Classname JdkDynamicAopProxy
 * @Description jdk代理实现类
 * @Date 2022/2/24 16:57
 * @Created by jilin
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {
    private final AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    /**
     * 获取代理类
     * @return
     */
    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), advised.getTargetSource().getTargetClass(),this);
    }

    /**
     * 代理类执行方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //判断是否满足aop
        if (advised.getMethodMatcher().matches(method,advised.getTargetSource().getTarget().getClass())){
            MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
            return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(),method,args));
        }
        return method.invoke(advised.getTargetSource().getTarget(),args);
    }
}
