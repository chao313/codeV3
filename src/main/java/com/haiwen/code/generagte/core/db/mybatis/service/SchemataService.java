package com.haiwen.code.generagte.core.db.mybatis.service;


import com.haiwen.code.generagte.core.db.mybatis.vo.SchemataMultiTermVo;
import com.haiwen.code.generagte.core.db.mybatis.vo.SchemataVo;

import java.util.List;


/**
 * 表名称      :SCHEMATA
 * 表类型      :SYSTEM VIEW
 * 表引擎      :MEMORY
 * 表版本      :10
 * 行格式      :Fixed
 * 表创建      :2020-5-30
 * 字符集      :utf8_general_ci
 * 表注释      :
 */
public interface SchemataService {
    /**
     * 查询base
     */
    List<SchemataVo> querySchemataBase(SchemataVo query);

    /**
     * 查询base 多维条件
     */
    List<SchemataVo> querySchemataMultiTerm(SchemataMultiTermVo query);
}
