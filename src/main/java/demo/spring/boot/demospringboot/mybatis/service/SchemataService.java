package demo.spring.boot.demospringboot.mybatis.service;



import demo.spring.boot.demospringboot.mybatis.vo.SchemataMultiTermVo;
import demo.spring.boot.demospringboot.mybatis.vo.SchemataVo;

import java.util.List;


/**
 * 表名称      :SCHEMATA
 * 表类型      :SYSTEM VIEW
 * 表引擎      :MEMORY
 * 表版本      :10
 * 行格式      :Fixed
 * 表创建      :2020-5-30
 * 字符集      :utf8_general_ci
 * 表注释      :
 */
public interface SchemataService {

    /**
     * insert
     */
    boolean insert(SchemataVo vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<SchemataVo> vos);


    /**
     * 查询base
     */
    List<SchemataVo> queryBase(SchemataVo query);

    /**
     * 查询base 多维条件
     */
    List<SchemataVo> queryMultiTerm(SchemataMultiTermVo query);

    /**
     * update base (exclude value is null or "")
     */
    boolean updateBase(SchemataVo source, SchemataVo target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(SchemataVo source, SchemataVo target);

    /**
     * 删除base
     */
    boolean deleteBase(SchemataVo vo);


}
