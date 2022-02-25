package com.jilin.spring.aop;


import org.aopalliance.intercept.MethodInterceptor;

/**
 * @Classname AdvisedSupport
 * @Description 切面通知信息
 * @Date 2022/2/24 16:57
 * @Created by jilin
 */
public class AdvisedSupport {
    //被代理的对象
    private TargetSource targetSource;
    //方法拦截器
    private MethodInterceptor methodInterceptor;
    //方法匹配器
    private MethodMatcher methodMatcher;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
