package com.jilin.spring.beans;

/**
 * @Classname PropertyValue
 * @Description 属性对象
 * @Date 2022/2/17 15:06
 * @Created by jilin
 */
public class PropertyValue {
    /**
     * 属性名
     */
    private final String name;
    /**
     * 属性值
     */
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
