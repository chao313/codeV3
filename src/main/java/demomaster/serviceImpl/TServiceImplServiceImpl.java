package demomaster.serviceImpl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import demomaster.vo.TServiceImplVo;
import demomaster.dao.TServiceImplDAO;
import demomaster.service.TServiceImplService;
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
@Service
public class TServiceImplServiceImpl implements TServiceImplService {

    @Autowired
    private TServiceImplDAO dao;

    /**
     * insert
     */
    @Override
    public boolean insert(TServiceImplVo vo) {

        return dao.insert(vo) > 0 ? true : false;

    }

    /**
     * insert vos 批量插入
     */
    @Override
    public boolean insert(List<TServiceImplVo> vos) {

        return dao.inserts(vos) > 0 ? true : false;

    }

    /**
     * 查询base
     */
    @Override
    public List<TServiceImplVo> queryBase(TServiceImplVo query) {

        return dao.queryBase(query);

    }

    /**
     * 查询base 多维条件
     */
    @Override
    public List<TServiceImplVo> queryMultiTerm(TServiceImplMultiTermVo query) {

        return dao.queryMultiTerm(query);

    }

    /**
     * update base (exclude value is null or "")
     */
    @Override
    public boolean updateBase(TServiceImplVo source, TServiceImplVo target) {

        return dao.updateBase(source, target) > 0 ? true : false;

    }

    /**
     * update base (include value is null or "")
     */
    @Override
    public boolean updateBaseIncludeNull(TServiceImplVo source, TServiceImplVo target) {

        return dao.updateBaseIncludeNull(source, target) > 0 ? true : false;

    }

    /**
     * 删除base
     */
    @Override
    public boolean deleteBase(TServiceImplVo vo) {

        return dao.deleteBase(vo) > 0 ? true : false;

    }


    /**
     * 根据PrimaryKey查询
     * <p>
     * dbName  库名<p>
     * dbTableName  表名
     */
    @Override
    public TServiceImplVo queryByPrimaryKey(String dbName, String dbTableName) {

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
    public boolean updateByPrimaryKey(TServiceImplNoPriVo source,TServiceImplPriVo target){

        return dao.updateByPrimaryKey(source,target) > 0 ? true : false;

    }


}
