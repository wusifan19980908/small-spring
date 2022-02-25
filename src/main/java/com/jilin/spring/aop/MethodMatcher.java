package com.jilin.spring.aop;

import java.lang.reflect.Method;

/**
 * @Classname MethodMatcher
 * @Description TODO
 * @Date 2022/2/24 16:57
 * @Created by jilin
 */
public interface MethodMatcher {
    /**
     *
     * @param method
     * @param clazz
     * @return
     */
    boolean matches(Method method,Class<?> clazz);
}
