//package com.haiwen.code.generagte.core.db.mybatis.service.impl;
//
//
//import com.haiwen.code.generagte.core.db.mybatis.dao.TablesDAO;
//import com.haiwen.code.generagte.core.db.mybatis.service.TablesService;
//import com.haiwen.code.generagte.core.db.mybatis.vo.TablesMultiTermVo;
//import com.haiwen.code.generagte.core.db.mybatis.vo.TablesVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
///**
// * 表名称      :TABLES
// * 表类型      :SYSTEM VIEW
// * 表引擎      :MEMORY
// * 表版本      :10
// * 行格式      :Fixed
// * 表创建      :2020-5-30
// * 字符集      :utf8_general_ci
// * 表注释      :
// */
//@Service
//public class TablesServiceImpl implements TablesService {
//
//    @Autowired
//    private TablesDAO dao;
//
//    /**
//     * insert
//     */
//    @Override
//    public boolean insert(TablesVo vo) {
//
//        return dao.insert(vo) > 0 ? true : false;
//
//    }
//
//    /**
//     * insert vos 批量插入
//     */
//    @Override
//    public boolean insert(List<TablesVo> vos) {
//
//        return dao.inserts(vos) > 0 ? true : false;
//
//    }
//
//    /**
//     * 查询base
//     */
//    @Override
//    public List<TablesVo> queryBase(TablesVo query) {
//
//        return dao.queryBase(query);
//
//    }
//
//    /**
//     * 查询base 多维条件
//     */
//    @Override
//    public List<TablesVo> queryMultiTerm(TablesMultiTermVo query) {
//
//        return dao.queryMultiTerm(query);
//
//    }
//
//    /**
//     * update base (exclude value is null or "")
//     */
//    @Override
//    public boolean updateBase(TablesVo source, TablesVo target) {
//
//        return dao.updateBase(source, target) > 0 ? true : false;
//
//    }
//
//    /**
//     * update base (include value is null or "")
//     */
//    @Override
//    public boolean updateBaseIncludeNull(TablesVo source, TablesVo target) {
//
//        return dao.updateBaseIncludeNull(source, target) > 0 ? true : false;
//
//    }
//
//    /**
//     * 删除base
//     */
//    @Override
//    public boolean deleteBase(TablesVo vo) {
//
//        return dao.deleteBase(vo) > 0 ? true : false;
//
//    }
//
//}
