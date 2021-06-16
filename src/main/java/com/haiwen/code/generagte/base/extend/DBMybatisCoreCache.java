package com.haiwen.code.generagte.base.extend;

import com.haiwen.code.generagte.base.ConcurrentCacheTemplate;
import com.haiwen.code.generagte.core.DBMybatisCore;
import com.haiwen.code.generagte.core.bo.jdbc.DbConnProperties;
import com.haiwen.code.generagte.core.db.mybatis.dao.ColumnsDAO;
import com.haiwen.code.generagte.core.db.mybatis.dao.SchemataDAO;
import com.haiwen.code.generagte.core.db.mybatis.dao.TablesDAO;
import com.haiwen.code.generagte.helper.DbConnPropertiesHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chao
 * @version 1.0
 * @description: MybatisCore核心包缓存
 * @date 2021/6/16 下午9:28
 */
@Component
public class DBMybatisCoreCache extends ConcurrentCacheTemplate<DbConnProperties, DBMybatisCore> {

    @Autowired
    private SqlSessionFactoryCache sqlSessionFactoryCache;


    @Override
    protected DBMybatisCore getInstance(DbConnProperties dbConnProperties) throws Exception {
        SchemataDAO schemataDAO = sqlSessionFactoryCache.getMapper(dbConnProperties, SchemataDAO.class);
        TablesDAO tablesDAO = sqlSessionFactoryCache.getMapper(dbConnProperties, TablesDAO.class);
        ColumnsDAO columnsDAO = sqlSessionFactoryCache.getMapper(dbConnProperties, ColumnsDAO.class);
        return new DBMybatisCore(schemataDAO, tablesDAO, columnsDAO);
    }

    @Override
    protected String getKey(DbConnProperties dbConnProperties) {
        return DbConnPropertiesHelper.getKey(dbConnProperties);
    }

    @Override
    protected void close(DBMybatisCore dbMybatisCore) throws Exception {

    }
}
