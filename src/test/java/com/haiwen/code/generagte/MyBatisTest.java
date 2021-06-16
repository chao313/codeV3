package com.haiwen.code.generagte;

import com.haiwen.code.generagte.base.extend.SqlSessionFactoryCache;
import com.haiwen.code.generagte.core.DBMybatisCore;
import com.haiwen.code.generagte.core.bo.jdbc.DbConnProperties;
import com.haiwen.code.generagte.core.db.mybatis.dao.TablesDAO;
import com.haiwen.code.generagte.core.db.mybatis.vo.TablesVo;
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
    private DBMybatisCore dbMybatisCore;


    /**
     * 测试mybatis的数据检索
     */
    @Test
    public void DaoTest() throws Exception {
        DbConnProperties dbConnProperties = this.getDbConnProperties();
        TablesDAO tablesDAO = sqlSessionFactoryCache.getMapper(dbConnProperties, TablesDAO.class);
        List<TablesVo> tablesVos = tablesDAO.queryBase(null);
        log.info("tablesVos:{}", tablesVos);

    }


    /**
     * 测试 DBMybatisCore的数据检索
     */
    @Test
    public void DBMybatisCoreTest() throws Exception {
        DbConnProperties dbConnProperties = this.getDbConnProperties();
        List<TablesVo> tablesVos = dbMybatisCore.initDb(dbConnProperties).queryTablesBase(null);
        log.info("tablesVos:{}", tablesVos);

    }


    private DbConnProperties getDbConnProperties() {
        DbConnProperties dbConnProperties = new DbConnProperties();
        dbConnProperties.setUrl("jdbc:mysql://127.0.0.1:7001/work_ui?useUnicode=true&characterEncoding=utf8");
        dbConnProperties.setDriverClassName("com.mysql.jdbc.Driver");
        dbConnProperties.setPassword("123456");
        dbConnProperties.setUsername("root");
        return dbConnProperties;
    }


}
