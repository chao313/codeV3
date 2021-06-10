package demomaster.service;


import java.util.List;

import demomaster.vo.TControllerVo;
import demomaster.vo.plugin.TControllerPriVo;
import demomaster.vo.plugin.TControllerNoPriVo;
import demomaster.vo.TControllerMultiTermVo;


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
public interface TControllerService {

    /**
     * insert
     */
    boolean insert(TControllerVo vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<TControllerVo> vos);


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
    boolean updateBase(TControllerVo source, TControllerVo target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(TControllerVo source, TControllerVo target);

    /**
     * 删除base
     */
    boolean deleteBase(TControllerVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     */
     TControllerVo queryByPrimaryKey(String dbName,String dbTableName);

    /**
     * 根据PrimaryKey删除
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     * @param dbName
     * @param dbTableName
     * 
     */
    boolean deleteByPrimaryKey(String dbName,String dbTableName);

    /**
     * 根据PrimaryKey更新，会根据主键去更新其他的值(空值不覆盖有值) -> 主键不更新
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     * @param dbName
     * @param dbTableName
     * 
     */
    boolean updateByPrimaryKey(TControllerNoPriVo source,TControllerPriVo target);



}
