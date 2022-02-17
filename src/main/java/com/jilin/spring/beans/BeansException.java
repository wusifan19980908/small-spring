package com.jilin.spring.beans;

/**
 * @author jilin
 * @description [类型描述]
 * @createTime 2022/2/17 10:20
 */
public class BeansException extends Exception{

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
