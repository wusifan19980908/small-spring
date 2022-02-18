package com.jilin.spring.beans.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Classname DefaultResourceLoader
 * @Description 资源加载实现类
 * @Date 2022/2/18 16:00
 * @Created by jilin
 */
public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location,"localtion不能为null");
        //判断是否为classpth下资源文件
        if (location.startsWith(CLASSPATH_URL_PREFIX)){
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else{
            try{
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                //加载本地资源文件
                return new FileSystemResource(location);
            }
        }
    }
}
