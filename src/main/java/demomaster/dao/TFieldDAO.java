package demomaster.dao;


import java.util.List;

import demomaster.vo.TFieldVo;
import demomaster.vo.plugin.TFieldPriVo;
import demomaster.vo.plugin.TFieldNoPriVo;
import demomaster.vo.TFieldMultiTermVo;


import org.apache.ibatis.annotations.Param;

/**
 * 表名称      :t_field
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public interface TFieldDAO {

    /**
     * insert
     */
    int insert(TFieldVo vo);

    /**
     * insert vos 批量插入
     */
    int inserts(@Param(value = "vos") List<TFieldVo> vos);

    /**
     * 查询base
     */
    List<TFieldVo> queryBase(TFieldVo query);

    /**
     * 查询base 多维条件
     */
    List<TFieldVo> queryMultiTerm(TFieldMultiTermVo query);

    /**
     * update base (exclude value is null or "")
     */
    int updateBase(@Param(value = "source") TFieldVo source, @Param(value = "target") TFieldVo target);


    /**
     * update base (include value is null or "")
     */
    int updateBaseIncludeNull(@Param(value = "source") TFieldVo source, @Param(value = "target") TFieldVo target);

    /**
     * 删除base
     */
    int deleteBase(TFieldVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名<p>
     * fieldName : 字段名称
     * @param dbName
     * @param dbTableName
     * @param fieldName
     * 
     */
    TFieldVo queryByPrimaryKey(@Param(value = "dbName") String dbName,@Param(value = "dbTableName") String dbTableName,@Param(value = "fieldName") String fieldName);

    /**
     * 根据PrimaryKey删除
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名<p>
     * fieldName : 字段名称
     * @param dbName
     * @param dbTableName
     * @param fieldName
     * 
     */
    int deleteByPrimaryKey(@Param(value = "dbName") String dbName,@Param(value = "dbTableName") String dbTableName,@Param(value = "fieldName") String fieldName);

    /**
     * 根据PrimaryKey更新，会根据主键去更新其他的值(空值不覆盖有值)
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名<p>
     * fieldName : 字段名称
     * @param dbName
     * @param dbTableName
     * @param fieldName
     * 
     */
    int updateByPrimaryKey(@Param(value = "source") TFieldNoPriVo source,@Param(value = "target") TFieldPriVo target);

}
