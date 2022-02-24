package com.jilin.spring.beans.test.bean;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONString;
import cn.hutool.json.JSONUtil;
import com.jilin.spring.beans.BeansException;
import com.jilin.spring.beans.context.ApplicationContext;
import com.jilin.spring.beans.context.ApplicationContextAware;
import com.jilin.spring.beans.factory.*;

/**
 * @author jilin
 * @description [类型描述]
 * @createTime 2022/2/17 9:58
 */
public class UserService implements BeanNameWare,BeanClassLoaderAware, ApplicationContextAware,BeanFactoryAware {
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    private String uId;
    private String company;
    private String location;

    private IUserDao userDao;


    public void queryUserInfo(){
        System.out.printf("查询用户信息:{%s}\n",userDao.queryUserName(uId));
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
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader:"+classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanName is"+name);
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
