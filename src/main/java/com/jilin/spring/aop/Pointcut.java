package com.jilin.spring.aop;

/**
 * @Classname Pointcut
 * @Description 切入点接口，定义用于获取 ClassFilter、MethodMatcher 的两个类，这两个接口
 * 获取都是切点表达式提供的内容。
 * @Date 2022/2/24 16:58
 * @Created by jilin
 */
public interface Pointcut {
    /**
     * 获取切入点的拦截器
     * @return
     */
    ClassFilter getClassFilter();

    /**
     * 获取方法匹配器
     * @return
     */
    MethodMatcher getMethodMatcher();
}
