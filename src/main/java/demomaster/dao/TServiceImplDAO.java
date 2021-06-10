package demomaster.dao;


import java.util.List;

import demomaster.vo.TServiceImplVo;
import demomaster.vo.plugin.TServiceImplPriVo;
import demomaster.vo.plugin.TServiceImplNoPriVo;
import demomaster.vo.TServiceImplMultiTermVo;


import org.apache.ibatis.annotations.Param;

/**
 * 表名称      :t_service_impl
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public interface TServiceImplDAO {

    /**
     * insert
     */
    int insert(TServiceImplVo vo);

    /**
     * insert vos 批量插入
     */
    int inserts(@Param(value = "vos") List<TServiceImplVo> vos);

    /**
     * 查询base
     */
    List<TServiceImplVo> queryBase(TServiceImplVo query);

    /**
     * 查询base 多维条件
     */
    List<TServiceImplVo> queryMultiTerm(TServiceImplMultiTermVo query);

    /**
     * update base (exclude value is null or "")
     */
    int updateBase(@Param(value = "source") TServiceImplVo source, @Param(value = "target") TServiceImplVo target);


    /**
     * update base (include value is null or "")
     */
    int updateBaseIncludeNull(@Param(value = "source") TServiceImplVo source, @Param(value = "target") TServiceImplVo target);

    /**
     * 删除base
     */
    int deleteBase(TServiceImplVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     * @param dbName
     * @param dbTableName
     * 
     */
    TServiceImplVo queryByPrimaryKey(@Param(value = "dbName") String dbName,@Param(value = "dbTableName") String dbTableName);

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
    int updateByPrimaryKey(@Param(value = "source") TServiceImplNoPriVo source,@Param(value = "target") TServiceImplPriVo target);

}
