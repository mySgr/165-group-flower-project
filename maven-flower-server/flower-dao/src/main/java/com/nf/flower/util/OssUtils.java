package com.nf.flower.util;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.sun.media.jfxmediaimpl.HostUtils;

import java.io.*;
import java.util.Properties;

public class OssUtils {
    public static final String ALIYUNOSS_FILE = "/aliyunoss.properties";
    //阿里云API的内或外网域名
    private static String ENDPOINT;
    //阿里云API的密钥Access Key ID
    private static String ACCESS_KEY_ID;
    //阿里云API的密钥Access Key Secret
    private static String ACCESS_KEY_SECRET;
    //阿里云API的bucket名称
    public static String BUCKET_NAME;

    static {
        InputStream resourceAsStream = OssUtils.class.getResourceAsStream(ALIYUNOSS_FILE);
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
            ENDPOINT = properties.getProperty("ENDPOINT");
            ACCESS_KEY_ID = properties.getProperty("ACCESS_KEY_ID");
            ACCESS_KEY_SECRET = properties.getProperty("ACCESS_KEY_SECRET");
            BUCKET_NAME = properties.getProperty("BUCKET_NAME");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // 获取 oss 客户端
    public static OSSClient getOSSClient() {
        return new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    }

    /**
     *  此静态方法可上传图片
     * @param saveName   保存为什么名
     * @param inputStream      上传的文件
     * @return
     */
    public static PutObjectResult uploadImage(String saveName, InputStream inputStream) {
        PutObjectResult putObjectResult = getOSSClient().putObject(BUCKET_NAME, saveName, inputStream);
        return putObjectResult;
    }

    public static void main(String[] args) {
        System.out.println(getOSSClient());
    }
}
