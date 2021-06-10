package demomaster.dao;


import java.util.List;

import demomaster.vo.TProjectVo;
import demomaster.vo.plugin.TProjectPriVo;
import demomaster.vo.plugin.TProjectNoPriVo;
import demomaster.vo.TProjectMultiTermVo;


import org.apache.ibatis.annotations.Param;

/**
 * 表名称      :t_project
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public interface TProjectDAO {

    /**
     * insert
     */
    int insert(TProjectVo vo);

    /**
     * insert vos 批量插入
     */
    int inserts(@Param(value = "vos") List<TProjectVo> vos);

    /**
     * 查询base
     */
    List<TProjectVo> queryBase(TProjectVo query);

    /**
     * 查询base 多维条件
     */
    List<TProjectVo> queryMultiTerm(TProjectMultiTermVo query);

    /**
     * update base (exclude value is null or "")
     */
    int updateBase(@Param(value = "source") TProjectVo source, @Param(value = "target") TProjectVo target);


    /**
     * update base (include value is null or "")
     */
    int updateBaseIncludeNull(@Param(value = "source") TProjectVo source, @Param(value = "target") TProjectVo target);

    /**
     * 删除base
     */
    int deleteBase(TProjectVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName : 库名
     * @param dbName
     * 
     */
    TProjectVo queryByPrimaryKey(@Param(value = "dbName") String dbName);

    /**
     * 根据PrimaryKey删除
     * <p>
     * dbName : 库名
     * @param dbName
     * 
     */
    int deleteByPrimaryKey(@Param(value = "dbName") String dbName);

    /**
     * 根据PrimaryKey更新，会根据主键去更新其他的值(空值不覆盖有值)
     * <p>
     * dbName : 库名
     * @param dbName
     * 
     */
    int updateByPrimaryKey(@Param(value = "source") TProjectNoPriVo source,@Param(value = "target") TProjectPriVo target);

}
