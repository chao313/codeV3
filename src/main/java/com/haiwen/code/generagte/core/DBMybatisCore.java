package com.haiwen.code.generagte.core;

import com.haiwen.code.generagte.base.extend.SqlSessionFactoryCache;
import com.haiwen.code.generagte.core.bo.jdbc.DbConnProperties;
import com.haiwen.code.generagte.core.db.mybatis.dao.ColumnsDAO;
import com.haiwen.code.generagte.core.db.mybatis.dao.SchemataDAO;
import com.haiwen.code.generagte.core.db.mybatis.dao.TablesDAO;
import com.haiwen.code.generagte.core.db.mybatis.service.ColumnsService;
import com.haiwen.code.generagte.core.db.mybatis.service.SchemataService;
import com.haiwen.code.generagte.core.db.mybatis.service.TablesService;
import com.haiwen.code.generagte.core.db.mybatis.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author dumo
 * @version 1.0
 * @description: 对外开放的核心包
 * @date 2021/6/16 10:11 上午
 */
@Component
public class DBMybatisCore implements TablesService, SchemataService, ColumnsService {

    @Autowired
    private SqlSessionFactoryCache sqlSessionFactoryCache;

    public DBMybatisCore initDb(DbConnProperties dbConnProperties) throws Exception {
        ColumnsDAO columnsDAO = sqlSessionFactoryCache.getMapper(dbConnProperties, ColumnsDAO.class);
        SchemataDAO schemataDAO = sqlSessionFactoryCache.getMapper(dbConnProperties, SchemataDAO.class);
        TablesDAO tablesDAO = sqlSessionFactoryCache.getMapper(dbConnProperties, TablesDAO.class);
        this.columnsDAO = columnsDAO;
        this.schemataDAO = schemataDAO;
        this.tablesDAO = tablesDAO;
        return this;
    }

    @Autowired
    private SchemataDAO schemataDAO;
    @Autowired
    private TablesDAO tablesDAO;
    @Autowired
    private ColumnsDAO columnsDAO;


    /**
     * 查询base
     */
    @Override
    public List<ColumnsVo> queryColumnsBase(ColumnsVo query) {

        return columnsDAO.queryBase(query);

    }

    /**
     * 查询base 多维条件
     */
    @Override
    public List<ColumnsVo> queryColumnsMultiTerm(ColumnsMultiTermVo query) {

        return columnsDAO.queryMultiTerm(query);

    }


    /**
     * 查询base
     */
    @Override
    public List<SchemataVo> querySchemataBase(SchemataVo query) {

        return schemataDAO.queryBase(query);

    }

    /**
     * 查询base 多维条件
     */
    @Override
    public List<SchemataVo> querySchemataMultiTerm(SchemataMultiTermVo query) {

        return schemataDAO.queryMultiTerm(query);

    }


    /**
     * 查询base
     */
    @Override
    public List<TablesVo> queryTablesBase(TablesVo query) {

        return tablesDAO.queryBase(query);

    }

    /**
     * 查询base 多维条件
     */
    @Override
    public List<TablesVo> queryTablesMultiTerm(TablesMultiTermVo query) {

        return tablesDAO.queryMultiTerm(query);

    }


}
