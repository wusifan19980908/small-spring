package com.jilin.spring.beans.core.io;

import cn.hutool.core.lang.Assert;
import com.jilin.spring.beans.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname ClassPathResource
 * @Description 加载classpath下资源文件
 * @Date 2022/2/18 16:00
 * @Created by jilin
 */
public class ClassPathResource implements Resource{
    /**
     * 文件路径
     */
    private final String path;
    /**
     * 当前的类加载器
     */
    private ClassLoader classLoader;

    /**
     * 全参构造方法
     * @param path
     * @param classLoader
     */
    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path,"path不能为null");
        this.path = path;
        this.classLoader = (classLoader!=null?classLoader: ClassUtils.getDefaultClassLoader());
    }

    /**
     * path构造器
     * @param path
     */
    public ClassPathResource(String path) {
        this(path,(ClassLoader) null);
    }

    /**
     * 加载classpath目录下的spring.xml
     * @return
     * @throws IOException
     */
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream inputStream = classLoader.getResourceAsStream(path);
        if (inputStream == null){
            throw new FileNotFoundException(this.path+"\tcannot be opened because it dose not exist");
        }
        return inputStream;
    }
}
