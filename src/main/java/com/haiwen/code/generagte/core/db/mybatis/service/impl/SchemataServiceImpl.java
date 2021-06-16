package com.haiwen.code.generagte.core.db.mybatis.service.impl;


import com.haiwen.code.generagte.core.db.mybatis.dao.SchemataDAO;
import com.haiwen.code.generagte.core.db.mybatis.service.SchemataService;
import com.haiwen.code.generagte.core.db.mybatis.vo.SchemataMultiTermVo;
import com.haiwen.code.generagte.core.db.mybatis.vo.SchemataVo;
import lombok.Data;
import org.springframework.stereotype.Service;

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
@Data
@Service
public class SchemataServiceImpl implements SchemataService {


    private SchemataDAO dao;

    /**
     * insert
     */
    @Override
    public boolean insert(SchemataVo vo) {

        return dao.insert(vo) > 0 ? true : false;

    }

    /**
     * insert vos 批量插入
     */
    @Override
    public boolean insert(List<SchemataVo> vos) {

        return dao.inserts(vos) > 0 ? true : false;

    }

    /**
     * 查询base
     */
    @Override
    public List<SchemataVo> queryBase(SchemataVo query) {

        return dao.queryBase(query);

    }

    /**
     * 查询base 多维条件
     */
    @Override
    public List<SchemataVo> queryMultiTerm(SchemataMultiTermVo query) {

        return dao.queryMultiTerm(query);

    }

    /**
     * update base (exclude value is null or "")
     */
    @Override
    public boolean updateBase(SchemataVo source, SchemataVo target) {

        return dao.updateBase(source, target) > 0 ? true : false;

    }

    /**
     * update base (include value is null or "")
     */
    @Override
    public boolean updateBaseIncludeNull(SchemataVo source, SchemataVo target) {

        return dao.updateBaseIncludeNull(source, target) > 0 ? true : false;

    }

    /**
     * 删除base
     */
    @Override
    public boolean deleteBase(SchemataVo vo) {

        return dao.deleteBase(vo) > 0 ? true : false;

    }

}
