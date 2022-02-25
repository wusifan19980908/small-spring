package com.jilin.spring.beans.test.bean;

/**
 * @Classname IUserService
 * @Description TODO
 * @Date 2022/2/25 15:55
 * @Created by jilin
 */
public interface IUserService {
    void queryUserName();

    String queryUserId(String uId);

     String register(String userName);
}
