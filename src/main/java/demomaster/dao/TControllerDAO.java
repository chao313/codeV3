package demomaster.dao;


import java.util.List;

import demomaster.vo.TControllerVo;
import demomaster.vo.plugin.TControllerPriVo;
import demomaster.vo.plugin.TControllerNoPriVo;
import demomaster.vo.TControllerMultiTermVo;


import org.apache.ibatis.annotations.Param;

/**
 * 表名称      :t_controller
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :Contrller相关的生成
 */
public interface TControllerDAO {

    /**
     * insert
     */
    int insert(TControllerVo vo);

    /**
     * insert vos 批量插入
     */
    int inserts(@Param(value = "vos") List<TControllerVo> vos);

    /**
     * 查询base
     */
    List<TControllerVo> queryBase(TControllerVo query);

    /**
     * 查询base 多维条件
     */
    List<TControllerVo> queryMultiTerm(TControllerMultiTermVo query);

    /**
     * update base (exclude value is null or "")
     */
    int updateBase(@Param(value = "source") TControllerVo source, @Param(value = "target") TControllerVo target);


    /**
     * update base (include value is null or "")
     */
    int updateBaseIncludeNull(@Param(value = "source") TControllerVo source, @Param(value = "target") TControllerVo target);

    /**
     * 删除base
     */
    int deleteBase(TControllerVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     * @param dbName
     * @param dbTableName
     * 
     */
    TControllerVo queryByPrimaryKey(@Param(value = "dbName") String dbName,@Param(value = "dbTableName") String dbTableName);

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
    int updateByPrimaryKey(@Param(value = "source") TControllerNoPriVo source,@Param(value = "target") TControllerPriVo target);

}
