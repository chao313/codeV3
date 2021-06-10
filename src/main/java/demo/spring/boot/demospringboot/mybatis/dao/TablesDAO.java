package demo.spring.boot.demospringboot.mybatis.dao;


import demo.spring.boot.demospringboot.mybatis.vo.TablesMultiTermVo;
import demo.spring.boot.demospringboot.mybatis.vo.TablesVo;
import org.apache.ibatis.annotations.Param;

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
public interface TablesDAO {

    /**
     * insert
     */
    int insert(TablesVo vo);

    /**
     * insert vos 批量插入
     */
    int inserts(@Param(value = "vos") List<TablesVo> vos);

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
    int updateBase(@Param(value = "source") TablesVo source, @Param(value = "target") TablesVo target);


    /**
     * update base (include value is null or "")
     */
    int updateBaseIncludeNull(@Param(value = "source") TablesVo source, @Param(value = "target") TablesVo target);

    /**
     * 删除base
     */
    int deleteBase(TablesVo vo);

}
