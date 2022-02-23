package com.jilin.spring.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.jilin.spring.beans.factory.DisposableBean;
import com.jilin.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @Classname DisposableBeanAdapter
 * @Description TODO
 * @Date 2022/2/23 9:59
 * @Created by jilin
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;

    private final String beanName;

    private String destroyMethodName;

    /**
     * 初始化方法
     * @param bean
     * @param beanName
     * @param beanDefinition
     */
    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition){
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destory() throws Exception {
        //实现接口 disposableBean
        if (bean instanceof DisposableBean){
            ((DisposableBean) bean).destory();
        }
        //配置destroy-method  判断是为了避免二次执行
        if (StrUtil.isNotEmpty(destroyMethodName)&&!(bean instanceof DisposableBeanAdapter)&&"destory".equals(this.destroyMethodName)){
            Method destoryMethod = bean.getClass().getMethod(destroyMethodName);
            if (null==destoryMethod){
                throw new Exception("无法找到destory方法，方法名：["+destroyMethodName+"],bean名字为：["+beanName+"]");
            }
            destoryMethod.invoke(bean);
        }
    }
}
