package com.haiwen.code.generagte.base.extend;

import com.haiwen.code.generagte.base.ConcurrentCacheTemplate;
import com.haiwen.code.generagte.core.bo.jdbc.DbConnProperties;
import com.haiwen.code.generagte.helper.DbConnPropertiesHelper;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author dumo
 * @version 1.0
 * @description: 拓展的连接缓存
 * @date 2021/6/15 8:50 上午
 */
@Component
public class ConnectionCache extends ConcurrentCacheTemplate<DbConnProperties, Connection> {

    @Override
    protected Connection getInstance(DbConnProperties dbConnProperties) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName(dbConnProperties.getDriverClassName());
        //根据连接URL，用户名，密码，获取数据库连接
        Connection conn = DriverManager.getConnection(
                dbConnProperties.getUrl(),
                dbConnProperties.getUsername(),
                dbConnProperties.getPassword());
        return conn;
    }

    @Override
    protected String getKey(DbConnProperties dbConnProperties) {
        return DbConnPropertiesHelper.getKey(dbConnProperties);
    }

    @Override
    protected void close(Connection connection) throws Exception {
        connection.close();
    }


}
