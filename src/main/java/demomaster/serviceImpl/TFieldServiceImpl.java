package demomaster.serviceImpl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import demomaster.vo.TFieldVo;
import demomaster.dao.TFieldDAO;
import demomaster.service.TFieldService;
import demomaster.vo.plugin.TFieldPriVo;
import demomaster.vo.plugin.TFieldNoPriVo;
import demomaster.vo.TFieldMultiTermVo;



/**
 * 表名称      :t_field
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
@Service
public class TFieldServiceImpl implements TFieldService {

    @Autowired
    private TFieldDAO dao;

    /**
     * insert
     */
    @Override
    public boolean insert(TFieldVo vo) {

        return dao.insert(vo) > 0 ? true : false;

    }

    /**
     * insert vos 批量插入
     */
    @Override
    public boolean insert(List<TFieldVo> vos) {

        return dao.inserts(vos) > 0 ? true : false;

    }

    /**
     * 查询base
     */
    @Override
    public List<TFieldVo> queryBase(TFieldVo query) {

        return dao.queryBase(query);

    }

    /**
     * 查询base 多维条件
     */
    @Override
    public List<TFieldVo> queryMultiTerm(TFieldMultiTermVo query) {

        return dao.queryMultiTerm(query);

    }

    /**
     * update base (exclude value is null or "")
     */
    @Override
    public boolean updateBase(TFieldVo source, TFieldVo target) {

        return dao.updateBase(source, target) > 0 ? true : false;

    }

    /**
     * update base (include value is null or "")
     */
    @Override
    public boolean updateBaseIncludeNull(TFieldVo source, TFieldVo target) {

        return dao.updateBaseIncludeNull(source, target) > 0 ? true : false;

    }

    /**
     * 删除base
     */
    @Override
    public boolean deleteBase(TFieldVo vo) {

        return dao.deleteBase(vo) > 0 ? true : false;

    }


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName  库名<p>
     * dbTableName  表名<p>
     * fieldName  字段名称
     */
    @Override
    public TFieldVo queryByPrimaryKey(String dbName, String dbTableName, String fieldName) {

        return dao.queryByPrimaryKey(dbName, dbTableName, fieldName);

    }

    /**
     * 根据PrimaryKey删除
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名<p>
     * fieldName : 字段名称
     * @param dbName
     * @param dbTableName
     * @param fieldName
     * 
     */
    @Override
    public boolean deleteByPrimaryKey(String dbName, String dbTableName, String fieldName) {

        return dao.deleteByPrimaryKey(dbName, dbTableName, fieldName) > 0 ? true : false;

    }

    /**
     * 根据PrimaryKey更新，会根据主键去更新其他的值(空值不覆盖有值)
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名<p>
     * fieldName : 字段名称
     * @param dbName
     * @param dbTableName
     * @param fieldName
     * 
     */
    @Override
    public boolean updateByPrimaryKey(TFieldNoPriVo source,TFieldPriVo target){

        return dao.updateByPrimaryKey(source,target) > 0 ? true : false;

    }


}
