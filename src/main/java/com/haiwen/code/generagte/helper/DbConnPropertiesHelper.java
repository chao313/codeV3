package com.haiwen.code.generagte.helper;

import com.haiwen.code.generagte.core.bo.jdbc.DbConnProperties;

/**
 * @author dumo
 * @version 1.0
 * @description: 用于存放连接信息
 * @date 2021/6/13 10:01 上午
 */
public class DbConnPropertiesHelper {
    //连接信息本地变量
    private static ThreadLocal<DbConnProperties> dbConnPropertiesThreadLocal
            = new InheritableThreadLocal<DbConnProperties>();

    /**
     * @param dbConnProperties 设置本地线程变量:连接信息
     */
    public void setDbConnProperties(DbConnProperties dbConnProperties) {
        dbConnPropertiesThreadLocal.set(dbConnProperties);
    }

    /**
     * @param dbConnProperties 移除本地线程变量:连接信息
     */
    public void removeDbConnProperties(DbConnProperties dbConnProperties) {
        dbConnPropertiesThreadLocal.remove();
    }


    /**
     * 获取连接信息的key
     *
     * @param dbConnProperties
     * @return
     */
    public static String getKey(DbConnProperties dbConnProperties) {
        StringBuilder key = new StringBuilder();
        key.append(dbConnProperties.getDriverClassName())
                .append(dbConnProperties.getUrl())
                .append(dbConnProperties.getUsername())
                .append(dbConnProperties.getPassword());
        return key.toString();
    }
}
