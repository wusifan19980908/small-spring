package com.jilin.spring.beans.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname Resource
 * @Description 获取资源接口
 * @Date 2022/2/18 16:01
 * @Created by jilin
 */
public interface Resource {
    /**
     * 获取文件输入流，资源加载流
     * @return
     * @throws IOException
     */
    InputStream getInputStream()throws IOException;
}
