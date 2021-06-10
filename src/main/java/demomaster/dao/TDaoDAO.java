package demomaster.dao;


import java.util.List;

import demomaster.vo.TDaoVo;
import demomaster.vo.plugin.TDaoPriVo;
import demomaster.vo.plugin.TDaoNoPriVo;
import demomaster.vo.TDaoMultiTermVo;


import org.apache.ibatis.annotations.Param;

/**
 * 表名称      :t_dao
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public interface TDaoDAO {

    /**
     * insert
     */
    int insert(TDaoVo vo);

    /**
     * insert vos 批量插入
     */
    int inserts(@Param(value = "vos") List<TDaoVo> vos);

    /**
     * 查询base
     */
    List<TDaoVo> queryBase(TDaoVo query);

    /**
     * 查询base 多维条件
     */
    List<TDaoVo> queryMultiTerm(TDaoMultiTermVo query);

    /**
     * update base (exclude value is null or "")
     */
    int updateBase(@Param(value = "source") TDaoVo source, @Param(value = "target") TDaoVo target);


    /**
     * update base (include value is null or "")
     */
    int updateBaseIncludeNull(@Param(value = "source") TDaoVo source, @Param(value = "target") TDaoVo target);

    /**
     * 删除base
     */
    int deleteBase(TDaoVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     * @param dbName
     * @param dbTableName
     * 
     */
    TDaoVo queryByPrimaryKey(@Param(value = "dbName") String dbName,@Param(value = "dbTableName") String dbTableName);

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
    int updateByPrimaryKey(@Param(value = "source") TDaoNoPriVo source,@Param(value = "target") TDaoPriVo target);

}
