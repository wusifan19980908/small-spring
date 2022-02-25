package com.jilin.spring.aop.framework;

import com.jilin.spring.aop.AdvisedSupport;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Classname Cglib2AopProxy
 * @Description 基于 Cglib 使用 Enhancer 代理的类可以在运行期间为接口使用底层 ASM 字节
 * 码增强技术处理对象的代理对象生成，因此被代理类不需要实现任何接口。
 * @Date 2022/2/24 16:57
 * @Created by jilin
 */
public class Cglib2AopProxy implements AopProxy{
    private final AdvisedSupport advised;

    public Cglib2AopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(advised.getTargetSource().getTarget().getClass());
        enhancer.setInterfaces(advised.getTargetSource().getTargetClass());
        enhancer.setCallback(new DynamicAdvisedInterceptor(advised));
        return enhancer.create();
    }

    private static  class DynamicAdvisedInterceptor implements MethodInterceptor{

        private final AdvisedSupport advised;

        public DynamicAdvisedInterceptor(AdvisedSupport advised) {
            this.advised = advised;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            CglibMethodInvocation methodInvocation = new CglibMethodInvocation(advised.getTargetSource().getTarget(),method,objects,methodProxy);
            //是否需要aop代理
            if (advised.getMethodMatcher().matches(method,advised.getTargetSource().getTarget().getClass())){
                return advised.getMethodInterceptor().invoke(methodInvocation);
            }
            return methodInvocation.proceed();
        }
    }
    private static class CglibMethodInvocation extends ReflectiveMethodInvocation{
        private final MethodProxy methodProxy;
        public CglibMethodInvocation(Object target, Method method, Object[] arguments,MethodProxy methodProxy) {
            super(target, method, arguments);
            this.methodProxy = methodProxy;
        }

        @Override
        public Object proceed() throws Throwable {
            return this.methodProxy.invoke(this.target,this.arguments);
        }
    }
}
