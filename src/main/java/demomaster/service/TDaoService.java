package demomaster.service;


import java.util.List;

import demomaster.vo.TDaoVo;
import demomaster.vo.plugin.TDaoPriVo;
import demomaster.vo.plugin.TDaoNoPriVo;
import demomaster.vo.TDaoMultiTermVo;


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
public interface TDaoService {

    /**
     * insert
     */
    boolean insert(TDaoVo vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<TDaoVo> vos);


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
    boolean updateBase(TDaoVo source, TDaoVo target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(TDaoVo source, TDaoVo target);

    /**
     * 删除base
     */
    boolean deleteBase(TDaoVo vo);


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     */
     TDaoVo queryByPrimaryKey(String dbName,String dbTableName);

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
    boolean updateByPrimaryKey(TDaoNoPriVo source,TDaoPriVo target);



}
