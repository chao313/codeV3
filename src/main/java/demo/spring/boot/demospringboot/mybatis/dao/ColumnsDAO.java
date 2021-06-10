package demo.spring.boot.demospringboot.mybatis.dao;


import demo.spring.boot.demospringboot.mybatis.vo.ColumnsMultiTermVo;
import demo.spring.boot.demospringboot.mybatis.vo.ColumnsVo;
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
     * insert
     */
    int insert(ColumnsVo vo);

    /**
     * insert vos 批量插入
     */
    int inserts(@Param(value = "vos") List<ColumnsVo> vos);

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
    int updateBase(@Param(value = "source") ColumnsVo source, @Param(value = "target") ColumnsVo target);


    /**
     * update base (include value is null or "")
     */
    int updateBaseIncludeNull(@Param(value = "source") ColumnsVo source, @Param(value = "target") ColumnsVo target);

    /**
     * 删除base
     */
    int deleteBase(ColumnsVo vo);

}
