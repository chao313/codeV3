package com.haiwen.code.generagte.core.db.mybatis.dao;


import com.haiwen.code.generagte.core.db.mybatis.vo.SchemataMultiTermVo;
import com.haiwen.code.generagte.core.db.mybatis.vo.SchemataVo;
import org.apache.ibatis.annotations.Param;

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
public interface SchemataDAO {

    /**
     * insert
     */
    int insert(SchemataVo vo);

    /**
     * insert vos 批量插入
     */
    int inserts(@Param(value = "vos") List<SchemataVo> vos);

    /**
     * 查询base
     */
    List<SchemataVo> queryBase(SchemataVo query);

    /**
     * 查询base 多维条件
     */
    List<SchemataVo> queryMultiTerm(SchemataMultiTermVo query);

    /**
     * update base (exclude value is null or "")
     */
    int updateBase(@Param(value = "source") SchemataVo source, @Param(value = "target") SchemataVo target);


    /**
     * update base (include value is null or "")
     */
    int updateBaseIncludeNull(@Param(value = "source") SchemataVo source, @Param(value = "target") SchemataVo target);

    /**
     * 删除base
     */
    int deleteBase(SchemataVo vo);

}
