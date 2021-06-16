package com.haiwen.code.generagte;

import com.haiwen.code.generagte.base.extend.DBMybatisCoreCache;
import com.haiwen.code.generagte.base.extend.SqlSessionFactoryCache;
import com.haiwen.code.generagte.core.bo.TablesBo;
import com.haiwen.code.generagte.core.bo.jdbc.DbConnProperties;
import com.haiwen.code.generagte.core.db.mybatis.dao.TablesDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTest {

    @Autowired
    private SqlSessionFactoryCache sqlSessionFactoryCache;

    @Autowired
    private DBMybatisCoreCache dbMybatisCoreCache;


    /**
     * 测试mybatis的数据检索
     */
    @Test
    public void DaoTest() throws Exception {
        DbConnProperties dbConnProperties = this.getDbConnProperties();
        TablesDAO tablesDAO = sqlSessionFactoryCache.getMapper(dbConnProperties, TablesDAO.class);
        List<TablesBo> tablesBos = tablesDAO.queryBase(null);
        log.info("tablesBos:{}", tablesBos);

    }


    /**
     * 测试 DBMybatisCore的数据检索
     */
    @Test
    public void DBMybatisCoreTest() throws Exception {
        DbConnProperties dbConnProperties = this.getDbConnProperties();
        List<TablesBo> tablesBos = dbMybatisCoreCache.getFromCache(dbConnProperties).queryTablesBase(null);
        log.info("tablesBos:{}", tablesBos);

    }


    private DbConnProperties getDbConnProperties() {
        DbConnProperties dbConnProperties = new DbConnProperties();
        dbConnProperties.setUrl("jdbc:mysql://127.0.0.1:3306/work_ui?useUnicode=true&characterEncoding=utf8");
        dbConnProperties.setDriverClassName("com.mysql.jdbc.Driver");
        dbConnProperties.setPassword("123456");
        dbConnProperties.setUsername("root");
        return dbConnProperties;
    }


}
