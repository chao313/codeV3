package demomaster.service;


import java.util.List;

import demomaster.vo.TMultiTermVoVo;
import demomaster.vo.plugin.TMultiTermVoPriVo;
import demomaster.vo.plugin.TMultiTermVoNoPriVo;
import demomaster.vo.TMultiTermVoMultiTermVo;


/**
 * 表名称      :t_multi_term_vo
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public interface TMultiTermVoService {

    /**
     * insert
     */
    boolean insert(TMultiTermVoVo vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<TMultiTermVoVo> vos);


    /**
     * 查询base
     */
    List<TMultiTermVoVo> queryBase(TMultiTermVoVo query);

    /**
     * 查询base 多维条件
     */
    List<TMultiTermVoVo> queryMultiTerm(TMultiTermVoMultiTermVo query);

    /**
     * update base (exclude value is null or "")
     */
    boolean updateBase(TMultiTermVoVo source, TMultiTermVoVo target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(TMultiTermVoVo source, TMultiTermVoVo target);

    /**
     * 删除base
     */
    boolean deleteBase(TMultiTermVoVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     */
     TMultiTermVoVo queryByPrimaryKey(String dbName,String dbTableName);

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
    boolean updateByPrimaryKey(TMultiTermVoNoPriVo source,TMultiTermVoPriVo target);



}
