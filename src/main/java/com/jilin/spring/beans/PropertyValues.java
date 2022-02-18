package com.jilin.spring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PropertyValues
 * @Description 属性集合
 * @Date 2022/2/17 15:06
 * @Created by jilin
 */
public class PropertyValues {
    /**
     * 一个对象中的属性集合
     */
    private final List<PropertyValue> propertyValueList  =  new ArrayList<>();

    /**
     * 添加属性
     * @param value
     */
    public void addPropertyValue(PropertyValue value){
        this.propertyValueList.add(value);
    }

    /**
     * 获取属性数组
     * @return
     */
    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据name获取属性
     * @param propertyName 属性名字
     * @return
     */
    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue value: propertyValueList){
            if (value.getName().equals(propertyName)){
                return value;
            }
        }
        return null;
    }
}
