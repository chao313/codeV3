package com.haiwen.code.generagte.base.extend;

import com.haiwen.code.generagte.base.ConcurrentCacheTemplate;
import com.haiwen.code.generagte.core.bo.jdbc.DbConnProperties;
import com.haiwen.code.generagte.helper.DbConnPropertiesHelper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author dumo
 * @version 1.0
 * @description: mybatis工场缓存
 * @date 2021/6/13 11:26 上午
 */
@Component
public class SqlSessionFactoryCache extends ConcurrentCacheTemplate<DbConnProperties, SqlSessionFactoryBean> {


    //MyBatis 配置文件的路径
    private static String CONFIG_LOCATION = "com/haiwen/code/generagte/core/db/mybatis/location/config/mybatis-config.xml";

    //mapper 对应的XML 文件的路径
    private static String MAPPER_LOCATION = "com/haiwen/code/generagte/core/db/mybatis/location/mapper/*.xml";

    @Autowired
    private DataSourceCache dataSourceCache;

    @Autowired
    private SqlSessionFactoryCache sqlSessionFactoryCache;

    @Override
    protected SqlSessionFactoryBean getInstance(DbConnProperties dbConnProperties) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        DataSource dataSource = dataSourceCache.getFromCache(dbConnProperties);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 设置MyBatis 配置文件的路径
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(CONFIG_LOCATION));
        // 设置mapper 对应的XML 文件的路径
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(MAPPER_LOCATION));
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置mapper 接口所在的包
        return sqlSessionFactoryBean;
    }

    @Override
    protected String getKey(DbConnProperties dbConnProperties) {
        return DbConnPropertiesHelper.getKey(dbConnProperties);
    }

    @Override
    protected void close(SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {

    }

    /**
     * 额外拓展的根据数据源获取Mapper的方法
     *
     * @param dbConnProperties
     * @param type
     * @param <T>
     */
    public <T> T getMapper(DbConnProperties dbConnProperties, Class<T> type) throws Exception {
        return sqlSessionFactoryCache.getFromCache(dbConnProperties).getObject().openSession().getMapper(type);
    }
}
