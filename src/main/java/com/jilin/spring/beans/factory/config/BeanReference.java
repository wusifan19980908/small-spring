package com.jilin.spring.beans.factory.config;

/**
 * @Classname BeanReference
 * @Description TODO
 * @Date 2022/2/17 15:06
 * @Created by jilin
 */
public class BeanReference {
    private final String beanNam;

    public BeanReference(String beanNam) {
        this.beanNam = beanNam;
    }

    public String getBeanNam() {
        return beanNam;
    }
}
