package com.jilin.spring.beans.test.bean;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONString;
import cn.hutool.json.JSONUtil;
import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.context.ApplicationContext;
import com.jilin.spring.beans.context.ApplicationContextAware;
import com.jilin.spring.beans.factory.*;

import java.util.Random;

/**
 * @author jilin
 * @description [类型描述]
 * @createTime 2022/2/17 9:58
 */
public class UserService implements IUserService{
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    private String uId;
    private String company;
    private String location;

    private IUserDao userDao;


    public void queryUserInfo(){

    }


    public void queryUserId(){
        System.out.println("查询用户id:"+userDao.queryUserId(uId));
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void queryUserName() {
        try{
            Thread.sleep(new Random(1).nextInt(100));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("查询用户信息:{%s}\n","123");
    }
    @Override
    public String register(String userName){
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "注册用户："+userName+"success!";
    }

    @Override
    public String queryUserId(String uId) {
        return null;
    }
}
