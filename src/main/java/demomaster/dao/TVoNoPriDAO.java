package demomaster.dao;


import java.util.List;

import demomaster.vo.TVoNoPriVo;
import demomaster.vo.plugin.TVoNoPriPriVo;
import demomaster.vo.plugin.TVoNoPriNoPriVo;
import demomaster.vo.TVoNoPriMultiTermVo;


import org.apache.ibatis.annotations.Param;

/**
 * 表名称      :t_vo_no_pri
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public interface TVoNoPriDAO {

    /**
     * insert
     */
    int insert(TVoNoPriVo vo);

    /**
     * insert vos 批量插入
     */
    int inserts(@Param(value = "vos") List<TVoNoPriVo> vos);

    /**
     * 查询base
     */
    List<TVoNoPriVo> queryBase(TVoNoPriVo query);

    /**
     * 查询base 多维条件
     */
    List<TVoNoPriVo> queryMultiTerm(TVoNoPriMultiTermVo query);

    /**
     * update base (exclude value is null or "")
     */
    int updateBase(@Param(value = "source") TVoNoPriVo source, @Param(value = "target") TVoNoPriVo target);


    /**
     * update base (include value is null or "")
     */
    int updateBaseIncludeNull(@Param(value = "source") TVoNoPriVo source, @Param(value = "target") TVoNoPriVo target);

    /**
     * 删除base
     */
    int deleteBase(TVoNoPriVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     * @param dbName
     * @param dbTableName
     * 
     */
    TVoNoPriVo queryByPrimaryKey(@Param(value = "dbName") String dbName,@Param(value = "dbTableName") String dbTableName);

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
    int updateByPrimaryKey(@Param(value = "source") TVoNoPriNoPriVo source,@Param(value = "target") TVoNoPriPriVo target);

}
