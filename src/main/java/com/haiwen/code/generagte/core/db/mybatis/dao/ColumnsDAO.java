package com.haiwen.code.generagte.core.db.mybatis.dao;


import com.haiwen.code.generagte.core.db.mybatis.vo.ColumnsMultiTermVo;
import com.haiwen.code.generagte.core.db.mybatis.vo.ColumnsVo;
import org.apache.ibatis.annotations.Param;

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
public interface ColumnsDAO {
    /**
     * 查询base
     */
    List<ColumnsVo> queryBase(ColumnsVo query);

    /**
     * 查询base 多维条件
     */
    List<ColumnsVo> queryMultiTerm(ColumnsMultiTermVo query);


}
