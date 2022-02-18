package com.jilin.spring.beans.util;

/**
 * @Classname ClassUtils
 * @Description TODO
 * @Date 2022/2/18 16:01
 * @Created by jilin
 */
public class ClassUtils {
    /**
     * 获取当前默认的类加载器
     *
     * @return
     */
    public static ClassLoader getDefaultClassLoader(){
        ClassLoader classLoader = null;
        try{
            classLoader = Thread.currentThread().getContextClassLoader();
        }catch (Throwable ex){

        }
        if (classLoader ==null){
            classLoader = ClassUtils.getDefaultClassLoader();
        }
        return classLoader;
    }
}
