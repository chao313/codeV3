package demomaster.service;


import java.util.List;

import demomaster.vo.TServiceImplVo;
import demomaster.vo.plugin.TServiceImplPriVo;
import demomaster.vo.plugin.TServiceImplNoPriVo;
import demomaster.vo.TServiceImplMultiTermVo;


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
public interface TServiceImplService {

    /**
     * insert
     */
    boolean insert(TServiceImplVo vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<TServiceImplVo> vos);


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
    boolean updateBase(TServiceImplVo source, TServiceImplVo target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(TServiceImplVo source, TServiceImplVo target);

    /**
     * 删除base
     */
    boolean deleteBase(TServiceImplVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     */
     TServiceImplVo queryByPrimaryKey(String dbName,String dbTableName);

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
    boolean updateByPrimaryKey(TServiceImplNoPriVo source,TServiceImplPriVo target);



}
