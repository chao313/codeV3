package com.haiwen.code.generagte.core;

import com.haiwen.code.generagte.core.bo.ColumnsBo;
import com.haiwen.code.generagte.core.bo.SchemataBo;
import com.haiwen.code.generagte.core.bo.TablesBo;
import com.haiwen.code.generagte.core.db.mybatis.dao.ColumnsDAO;
import com.haiwen.code.generagte.core.db.mybatis.dao.SchemataDAO;
import com.haiwen.code.generagte.core.db.mybatis.dao.TablesDAO;
import com.haiwen.code.generagte.core.db.mybatis.service.ColumnsService;
import com.haiwen.code.generagte.core.db.mybatis.service.SchemataService;
import com.haiwen.code.generagte.core.db.mybatis.service.TablesService;
import com.haiwen.code.generagte.core.db.mybatis.vo.*;

import java.util.List;

/**
 * @author dumo
 * @version 1.0
 * @description: 对外开放的核心包
 * @date 2021/6/16 10:11 上午
 */
public class DBMybatisCore implements TablesService, SchemataService, ColumnsService {

    private SchemataDAO schemataDAO;

    private TablesDAO tablesDAO;

    private ColumnsDAO columnsDAO;


    public DBMybatisCore(SchemataDAO schemataDAO, TablesDAO tablesDAO, ColumnsDAO columnsDAO) {
        this.columnsDAO = columnsDAO;
        this.schemataDAO = schemataDAO;
        this.tablesDAO = tablesDAO;
    }

    /**
     * 查询base
     */
    @Override
    public List<ColumnsBo> queryColumnsBase(ColumnsBo query) {

        return columnsDAO.queryBase(query);

    }

    /**
     * 查询base 多维条件
     */
    @Override
    public List<ColumnsBo> queryColumnsMultiTerm(ColumnsMultiTermVo query) {

        return columnsDAO.queryMultiTerm(query);

    }


    /**
     * 查询base
     */
    @Override
    public List<SchemataBo> querySchemataBase(SchemataBo query) {

        return schemataDAO.queryBase(query);

    }

    /**
     * 查询base 多维条件
     */
    @Override
    public List<SchemataBo> querySchemataMultiTerm(SchemataMultiTermVo query) {

        return schemataDAO.queryMultiTerm(query);

    }


    /**
     * 查询base
     */
    @Override
    public List<TablesBo> queryTablesBase(TablesBo query) {

        return tablesDAO.queryBase(query);

    }

    /**
     * 查询base 多维条件
     */
    @Override
    public List<TablesBo> queryTablesMultiTerm(TablesMultiTermVo query) {

        return tablesDAO.queryMultiTerm(query);

    }


}
