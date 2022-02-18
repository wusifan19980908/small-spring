package com.jilin.spring.beans.factory.support;

import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @Classname CglibSubclassingInstantiationStrategy
 * @Description TODO
 * @Date 2022/2/17 15:06
 * @Created by jilin
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    /**
     * 通过cglib实例化对象
     * @param beanDefinition bean定义
     * @param beanName bean名字
     * @param ctor 构造方法
     * @param args 构造参数
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        //设置类
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        //设置回调
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor){
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(),args);
    }
}
