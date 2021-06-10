package demomaster.service;


import java.util.List;

import demomaster.vo.TVoVo;
import demomaster.vo.plugin.TVoPriVo;
import demomaster.vo.plugin.TVoNoPriVo;
import demomaster.vo.TVoMultiTermVo;


/**
 * 表名称      :t_vo
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public interface TVoService {

    /**
     * insert
     */
    boolean insert(TVoVo vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<TVoVo> vos);


    /**
     * 查询base
     */
    List<TVoVo> queryBase(TVoVo query);

    /**
     * 查询base 多维条件
     */
    List<TVoVo> queryMultiTerm(TVoMultiTermVo query);

    /**
     * update base (exclude value is null or "")
     */
    boolean updateBase(TVoVo source, TVoVo target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(TVoVo source, TVoVo target);

    /**
     * 删除base
     */
    boolean deleteBase(TVoVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     */
     TVoVo queryByPrimaryKey(String dbName,String dbTableName);

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
    boolean updateByPrimaryKey(TVoNoPriVo source,TVoPriVo target);



}
