package com.jilin.spring.beans.test.bean;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONString;
import cn.hutool.json.JSONUtil;
import com.jilin.spring.beans.factory.DisposableBean;
import com.jilin.spring.beans.factory.InitializingBean;

/**
 * @author jilin
 * @description [类型描述]
 * @createTime 2022/2/17 9:58
 */
public class UserService implements InitializingBean, DisposableBean {
    private String uId;
    private String company;
    private String location;

    private UserDao userDao;


    public void queryUserInfo(){
        System.out.printf("查询用户信息:{%s:%s,%s,%s}\n",uId, userDao.queryUserName(uId),company,location);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
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
    public void destory() throws Exception {
        System.out.println("执行 userservice.destory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行userSeevice.afterPropertieSet");
    }
}
