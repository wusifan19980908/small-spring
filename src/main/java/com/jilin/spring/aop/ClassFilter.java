package com.jilin.spring.aop;

/**
 * @Classname ClassFilter
 * @Description TODO
 * @Date 2022/2/24 16:57
 * @Created by jilin
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);


}
