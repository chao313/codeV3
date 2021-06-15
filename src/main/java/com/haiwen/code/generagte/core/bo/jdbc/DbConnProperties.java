package com.haiwen.code.generagte.core.bo.jdbc;

import lombok.Data;

/**
 * @author dumo
 * @version 1.0
 * @description: db的连接信息
 * @date 2021/6/13 8:55 上午
 */
@Data
public class DbConnProperties {
    /**
     * 数据库连接URL，当前连接的是当前项目的dbdir:下的mydb.mv.db
     * jdbc:mysql://127.0.0.1:3306/dzr
     */
    private String url;
    /**
     * 账号
     * root
     */
    private String username;
    /**
     * 密码
     * 123456
     */
    private String password;
    /**
     * 连接数据库时使用的驱动类
     * com.mysql.jdbc.Driver
     */
    private String driverClassName;
}
