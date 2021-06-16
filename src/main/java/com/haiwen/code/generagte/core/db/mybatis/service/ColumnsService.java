package com.haiwen.code.generagte.core.db.mybatis.service;


import com.haiwen.code.generagte.core.db.mybatis.vo.ColumnsMultiTermVo;
import com.haiwen.code.generagte.core.db.mybatis.vo.ColumnsVo;

import java.util.List;


/**
 * 表名称      :COLUMNS
 * 表类型      :SYSTEM VIEW
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Dynamic
 * 表创建      :
 * 字符集      :utf8_general_ci
 * 表注释      :
 */
public interface ColumnsService {

    /**
     * 查询base
     */
    List<ColumnsVo> queryColumnsBase(ColumnsVo query);

    /**
     * 查询base 多维条件
     */
    List<ColumnsVo> queryColumnsMultiTerm(ColumnsMultiTermVo query);

}
