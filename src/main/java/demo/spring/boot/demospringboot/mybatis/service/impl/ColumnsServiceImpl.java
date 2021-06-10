package demo.spring.boot.demospringboot.mybatis.service.impl;


import demo.spring.boot.demospringboot.mybatis.dao.ColumnsDAO;
import demo.spring.boot.demospringboot.mybatis.service.ColumnsService;
import demo.spring.boot.demospringboot.mybatis.vo.ColumnsMultiTermVo;
import demo.spring.boot.demospringboot.mybatis.vo.ColumnsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 表名称      :COLUMNS
 * 表类型      :SYSTEM VIEW
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Dynamic
 * 表创建      :
 * 字符集      :utf8_general_ci
 * 表注释      :
 */
@Service
public class ColumnsServiceImpl implements ColumnsService {

    @Autowired
    private ColumnsDAO dao;

    /**
     * insert
     */
    @Override
    public boolean insert(ColumnsVo vo) {

        return dao.insert(vo) > 0 ? true : false;

    }

    /**
     * insert vos 批量插入
     */
    @Override
    public boolean insert(List<ColumnsVo> vos) {

        return dao.inserts(vos) > 0 ? true : false;

    }

    /**
     * 查询base
     */
    @Override
    public List<ColumnsVo> queryBase(ColumnsVo query) {

        return dao.queryBase(query);

    }

    /**
     * 查询base 多维条件
     */
    @Override
    public List<ColumnsVo> queryMultiTerm(ColumnsMultiTermVo query) {

        return dao.queryMultiTerm(query);

    }

    /**
     * update base (exclude value is null or "")
     */
    @Override
    public boolean updateBase(ColumnsVo source, ColumnsVo target) {

        return dao.updateBase(source, target) > 0 ? true : false;

    }

    /**
     * update base (include value is null or "")
     */
    @Override
    public boolean updateBaseIncludeNull(ColumnsVo source, ColumnsVo target) {

        return dao.updateBaseIncludeNull(source, target) > 0 ? true : false;

    }

    /**
     * 删除base
     */
    @Override
    public boolean deleteBase(ColumnsVo vo) {

        return dao.deleteBase(vo) > 0 ? true : false;

    }

}
