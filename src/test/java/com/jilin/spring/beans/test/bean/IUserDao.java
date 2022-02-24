package com.jilin.spring.beans.test.bean;

/**
 * @Classname IUserDao
 * @Description TODO
 * @Date 2022/2/24 10:12
 * @Created by jilin
 */
public interface IUserDao {
    String queryUserName(String uId);

    String queryUserId(String uId);
}
