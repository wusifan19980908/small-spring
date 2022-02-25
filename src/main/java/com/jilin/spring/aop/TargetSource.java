package com.jilin.spring.aop;

/**
 * @Classname TargetSource
 * @Description 被代理的目标对象
 * @Date 2022/2/24 16:58
 * @Created by jilin
 */
public class TargetSource {
    /**
     * 目标类
     */
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    /**
     * 获取被代理的目标接口
     * @return
     */
    public Class<?>[] getTargetClass(){
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return target;
    }
}
