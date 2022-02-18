package com.jilin.spring.beans.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname FileSystemResourceLoader
 * @Description 加载本地资源文件
 * @Date 2022/2/18 16:00
 * @Created by jilin
 */
public class FileSystemResource implements Resource{
    /**
     * 文件对象
     */
    private final File file;
    /**
     * 文件路径
     */
    private final String path;

    /**
     * 全参构造方法
     * @param file
     * @param path
     */
    public FileSystemResource(File file, String path) {
        this.file = file;
        this.path = path;
    }

    /**
     * path构造方法
     * @param path
     */
    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    /**
     * 加载本地资源文件
     * @return
     * @throws IOException
     */
    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public String getPath() {
        return path;
    }
}
