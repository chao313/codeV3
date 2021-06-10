package demomaster.service;


import java.util.List;

import demomaster.vo.TProjectVo;
import demomaster.vo.plugin.TProjectPriVo;
import demomaster.vo.plugin.TProjectNoPriVo;
import demomaster.vo.TProjectMultiTermVo;


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
public interface TProjectService {

    /**
     * insert
     */
    boolean insert(TProjectVo vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<TProjectVo> vos);


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
    boolean updateBase(TProjectVo source, TProjectVo target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(TProjectVo source, TProjectVo target);

    /**
     * 删除base
     */
    boolean deleteBase(TProjectVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName : 库名
     */
     TProjectVo queryByPrimaryKey(String dbName);

    /**
     * 根据PrimaryKey删除
     * <p>
     * dbName : 库名
     * @param dbName
     * 
     */
    boolean deleteByPrimaryKey(String dbName);

    /**
     * 根据PrimaryKey更新，会根据主键去更新其他的值(空值不覆盖有值) -> 主键不更新
     * <p>
     * dbName : 库名
     * @param dbName
     * 
     */
    boolean updateByPrimaryKey(TProjectNoPriVo source,TProjectPriVo target);



}
