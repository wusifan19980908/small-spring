package com.jilin.spring.beans.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2022/2/18 15:05
 * @Created by jilin
 */
public class UserDao {
    private static Map<String,String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001","sifan");
        hashMap.put("10002","jilin");
        hashMap.put("10003","xuye");
    }

    public String queryUserName(String uId){
        return hashMap.get(uId);
    }
}
