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
     * insert
     */
    boolean insert(ColumnsVo vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<ColumnsVo> vos);


    /**
     * 查询base
     */
    List<ColumnsVo> queryBase(ColumnsVo query);

    /**
     * 查询base 多维条件
     */
    List<ColumnsVo> queryMultiTerm(ColumnsMultiTermVo query);

    /**
     * update base (exclude value is null or "")
     */
    boolean updateBase(ColumnsVo source, ColumnsVo target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(ColumnsVo source, ColumnsVo target);

    /**
     * 删除base
     */
    boolean deleteBase(ColumnsVo vo);

}
