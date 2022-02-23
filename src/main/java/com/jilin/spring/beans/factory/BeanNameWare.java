package com.jilin.spring.beans.factory;

/**
 * @Classname BeanNameWare
 * @Description TODO
 * @Date 2022/2/23 11:57
 * @Created by jilin
 */
public interface BeanNameWare extends Aware{
    /**
     * 实现此接口，能感知到所属的BeanName
     * @param name
     */
    void setBeanName(String name);
}
