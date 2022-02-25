package com.jilin.spring.beans.test.interceptor;

import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @Classname UserServiceInterceptor
 * @Description TODO
 * @Date 2022/2/25 15:51
 * @Created by jilin
 */
public class UserServiceInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long start = System.currentTimeMillis();
        try{
            return methodInvocation.proceed();
        }finally {
            System.out.println("监控-- begin by aop");
            System.out.println("方法名称:"+methodInvocation.getMethod());
            System.out.println("方法耗时："+(System.currentTimeMillis()-start)+"ms");
            System.out.println("监控-- end");
        }
    }
}
