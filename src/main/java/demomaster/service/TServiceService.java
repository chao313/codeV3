package demomaster.service;


import java.util.List;

import demomaster.vo.TServiceVo;
import demomaster.vo.plugin.TServicePriVo;
import demomaster.vo.plugin.TServiceNoPriVo;
import demomaster.vo.TServiceMultiTermVo;


/**
 * 表名称      :t_service
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public interface TServiceService {

    /**
     * insert
     */
    boolean insert(TServiceVo vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<TServiceVo> vos);


    /**
     * 查询base
     */
    List<TServiceVo> queryBase(TServiceVo query);

    /**
     * 查询base 多维条件
     */
    List<TServiceVo> queryMultiTerm(TServiceMultiTermVo query);

    /**
     * update base (exclude value is null or "")
     */
    boolean updateBase(TServiceVo source, TServiceVo target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(TServiceVo source, TServiceVo target);

    /**
     * 删除base
     */
    boolean deleteBase(TServiceVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     */
     TServiceVo queryByPrimaryKey(String dbName,String dbTableName);

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
    boolean updateByPrimaryKey(TServiceNoPriVo source,TServicePriVo target);



}
