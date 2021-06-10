package demomaster.dao;


import java.util.List;

import demomaster.vo.TVoPriVo;
import demomaster.vo.plugin.TVoPriPriVo;
import demomaster.vo.plugin.TVoPriNoPriVo;
import demomaster.vo.TVoPriMultiTermVo;


import org.apache.ibatis.annotations.Param;

/**
 * 表名称      :t_vo_pri
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public interface TVoPriDAO {

    /**
     * insert
     */
    int insert(TVoPriVo vo);

    /**
     * insert vos 批量插入
     */
    int inserts(@Param(value = "vos") List<TVoPriVo> vos);

    /**
     * 查询base
     */
    List<TVoPriVo> queryBase(TVoPriVo query);

    /**
     * 查询base 多维条件
     */
    List<TVoPriVo> queryMultiTerm(TVoPriMultiTermVo query);

    /**
     * update base (exclude value is null or "")
     */
    int updateBase(@Param(value = "source") TVoPriVo source, @Param(value = "target") TVoPriVo target);


    /**
     * update base (include value is null or "")
     */
    int updateBaseIncludeNull(@Param(value = "source") TVoPriVo source, @Param(value = "target") TVoPriVo target);

    /**
     * 删除base
     */
    int deleteBase(TVoPriVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     * @param dbName
     * @param dbTableName
     * 
     */
    TVoPriVo queryByPrimaryKey(@Param(value = "dbName") String dbName,@Param(value = "dbTableName") String dbTableName);

    /**
     * 根据PrimaryKey删除
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     * @param dbName
     * @param dbTableName
     * 
     */
    int deleteByPrimaryKey(@Param(value = "dbName") String dbName,@Param(value = "dbTableName") String dbTableName);

    /**
     * 根据PrimaryKey更新，会根据主键去更新其他的值(空值不覆盖有值)
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     * @param dbName
     * @param dbTableName
     * 
     */
    int updateByPrimaryKey(@Param(value = "source") TVoPriNoPriVo source,@Param(value = "target") TVoPriPriVo target);

}
