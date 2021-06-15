package com.haiwen.code.generagte.base.extend;

import com.alibaba.druid.pool.DruidDataSource;
import com.haiwen.code.generagte.base.ConcurrentCacheTemplate;
import com.haiwen.code.generagte.core.bo.jdbc.DbConnProperties;
import com.haiwen.code.generagte.helper.DbConnPropertiesHelper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author dumo
 * @version 1.0
 * @description: 拓展的数据源缓存
 * @date 2021/6/15 8:50 上午
 */
@Component
public class DataSourceCache extends ConcurrentCacheTemplate<DbConnProperties, DataSource> {

    @Override
    protected DataSource getInstance(DbConnProperties dbConnProperties) throws ClassNotFoundException, SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbConnProperties.getUrl());
        druidDataSource.setUsername(dbConnProperties.getUsername());
        druidDataSource.setPassword(dbConnProperties.getPassword());
        druidDataSource.setDriverClassName(dbConnProperties.getDriverClassName());
        return druidDataSource;
    }

    @Override
    protected String getKey(DbConnProperties dbConnProperties) {
        return DbConnPropertiesHelper.getKey(dbConnProperties);
    }

    @Override
    protected void close(DataSource dataSource) throws Exception {

    }


}
