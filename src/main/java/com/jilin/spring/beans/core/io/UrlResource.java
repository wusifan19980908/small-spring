package com.jilin.spring.beans.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Classname UrlResource
 * @Description 远程加载资源文件
 * @Date 2022/2/18 16:01
 * @Created by jilin
 */
public class UrlResource implements Resource{
    /**
     * 远程文件url
     */
    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url,"url不能为空");
        this.url = url;
    }

    /**
     * 加载远程资源文件
     * @return
     * @throws IOException
     */
    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection connection = this.url.openConnection();
        try{
            return connection.getInputStream();
        }catch (IOException ex){
            if (connection instanceof HttpURLConnection){
                ((HttpURLConnection) connection).disconnect();
            }
            throw ex;
        }
    }
}
