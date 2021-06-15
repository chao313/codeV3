package com.haiwen.code.generagte.core.bo.jdbc;

import com.haiwen.code.generagte.base.extend.ConnectionCache;
import com.haiwen.code.generagte.util.AwareUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.function.Function;

/**
 * db核心内,用于获取连接和执行,底层使用线程变量来隔离
 * 1.存在的意义
 * :更自由化的操作,数据库连接,执行
 */

@Slf4j
@Component
public class DBTemplate {

    /**
     * 使用泛型模板，处理返回集
     *
     * @param sql
     * @param function
     * @param <R>
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static <R> R executeQuery(String sql, Function<ResultSet, R> function, DbConnProperties dbConnProperties)
            throws Exception {
        ConnectionCache connectionCache = AwareUtil.applicationContext.getBean(ConnectionCache.class);
        Connection conn = connectionCache.getFromCache(dbConnProperties);
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        R result = function.apply(resultSet);
        //释放资源
        stmt.close();
        return result;
    }

    /**
     * 执行 添加-更新-删除 操作
     */
    public static int executeInsertUpdateDelete(String sql, DbConnProperties dbConnProperties)
            throws Exception {
        ConnectionCache connectionCache = AwareUtil.applicationContext.getBean(ConnectionCache.class);
        Connection conn = connectionCache.getFromCache(dbConnProperties);
        Statement stmt = conn.createStatement();
        //执行更新操作
        int result = stmt.executeUpdate(sql);
        //释放资源
        stmt.close();
        return result;
    }

    /**
     * 执行sql -> 只返回执行成功与否
     */
    public static boolean execute(String sql, DbConnProperties dbConnProperties)
            throws Exception {
        ConnectionCache connectionCache = AwareUtil.applicationContext.getBean(ConnectionCache.class);
        Connection conn = connectionCache.getFromCache(dbConnProperties);
        Statement stmt = conn.createStatement();
        //执行更新操作
        boolean result = stmt.execute(sql);
        //释放资源
        stmt.close();
        return result;
    }
}
