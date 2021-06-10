package demomaster.serviceImpl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import demomaster.vo.TMapperVo;
import demomaster.dao.TMapperDAO;
import demomaster.service.TMapperService;
import demomaster.vo.plugin.TMapperPriVo;
import demomaster.vo.plugin.TMapperNoPriVo;
import demomaster.vo.TMapperMultiTermVo;



/**
 * 表名称      :t_mapper
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
@Service
public class TMapperServiceImpl implements TMapperService {

    @Autowired
    private TMapperDAO dao;

    /**
     * insert
     */
    @Override
    public boolean insert(TMapperVo vo) {

        return dao.insert(vo) > 0 ? true : false;

    }

    /**
     * insert vos 批量插入
     */
    @Override
    public boolean insert(List<TMapperVo> vos) {

        return dao.inserts(vos) > 0 ? true : false;

    }

    /**
     * 查询base
     */
    @Override
    public List<TMapperVo> queryBase(TMapperVo query) {

        return dao.queryBase(query);

    }

    /**
     * 查询base 多维条件
     */
    @Override
    public List<TMapperVo> queryMultiTerm(TMapperMultiTermVo query) {

        return dao.queryMultiTerm(query);

    }

    /**
     * update base (exclude value is null or "")
     */
    @Override
    public boolean updateBase(TMapperVo source, TMapperVo target) {

        return dao.updateBase(source, target) > 0 ? true : false;

    }

    /**
     * update base (include value is null or "")
     */
    @Override
    public boolean updateBaseIncludeNull(TMapperVo source, TMapperVo target) {

        return dao.updateBaseIncludeNull(source, target) > 0 ? true : false;

    }

    /**
     * 删除base
     */
    @Override
    public boolean deleteBase(TMapperVo vo) {

        return dao.deleteBase(vo) > 0 ? true : false;

    }


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName  库名<p>
     * dbTableName  表名
     */
    @Override
    public TMapperVo queryByPrimaryKey(String dbName, String dbTableName) {

        return dao.queryByPrimaryKey(dbName, dbTableName);

    }

    /**
     * 根据PrimaryKey删除
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     * @param dbName
     * @param dbTableName
     * 
     */
    @Override
    public boolean deleteByPrimaryKey(String dbName, String dbTableName) {

        return dao.deleteByPrimaryKey(dbName, dbTableName) > 0 ? true : false;

    }

    /**
     * 根据PrimaryKey更新，会根据主键去更新其他的值(空值不覆盖有值)
     * <p>
     * dbName : 库名<p>
     * dbTableName : 表名
     * @param dbName
     * @param dbTableName
     * 
     */
    @Override
    public boolean updateByPrimaryKey(TMapperNoPriVo source,TMapperPriVo target){

        return dao.updateByPrimaryKey(source,target) > 0 ? true : false;

    }


}
