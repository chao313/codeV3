package com.haiwen.code.generagte.core.db.mybatis.service;


import com.haiwen.code.generagte.core.bo.TablesBo;
import com.haiwen.code.generagte.core.db.mybatis.vo.TablesMultiTermVo;

import java.util.List;

/**
 * 表名称      :TABLES
 * 表类型      :SYSTEM VIEW
 * 表引擎      :MEMORY
 * 表版本      :10
 * 行格式      :Fixed
 * 表创建      :2020-5-30
 * 字符集      :utf8_general_ci
 * 表注释      :
 */
public interface TablesService {

    /**
     * 查询base
     */
    List<TablesBo> queryTablesBase(TablesBo query);

    /**
     * 查询base 多维条件
     */
    List<TablesBo> queryTablesMultiTerm(TablesMultiTermVo query);

}
