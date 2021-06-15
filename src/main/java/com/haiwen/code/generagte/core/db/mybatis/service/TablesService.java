package com.haiwen.code.generagte.core.db.mybatis.service;


import com.haiwen.code.generagte.core.db.mybatis.vo.TablesMultiTermVo;
import com.haiwen.code.generagte.core.db.mybatis.vo.TablesVo;

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
     * insert
     */
    boolean insert(TablesVo vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<TablesVo> vos);


    /**
     * 查询base
     */
    List<TablesVo> queryBase(TablesVo query);

    /**
     * 查询base 多维条件
     */
    List<TablesVo> queryMultiTerm(TablesMultiTermVo query);

    /**
     * update base (exclude value is null or "")
     */
    boolean updateBase(TablesVo source, TablesVo target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(TablesVo source, TablesVo target);

    /**
     * 删除base
     */
    boolean deleteBase(TablesVo vo);


}
