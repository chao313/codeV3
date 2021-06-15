package com.haiwen.code.generagte.framework.runner;

import com.haiwen.code.generagte.base.extend.SqlSessionFactoryCache;
import com.haiwen.code.generagte.core.bo.jdbc.DbConnProperties;
import com.haiwen.code.generagte.core.db.mybatis.dao.TablesDAO;
import com.haiwen.code.generagte.core.db.mybatis.vo.TablesVo;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class Runner implements ApplicationRunner {

    @Autowired
    private SqlSessionFactoryCache sqlSessionFactoryCache;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("启动参数为:{}", args);
        this.ss();
    }

    private void ss() throws Exception {
        DbConnProperties dbConnProperties = new DbConnProperties();
        dbConnProperties.setUrl("jdbc:mysql://127.0.0.1:3306/work_ui?useUnicode=true&characterEncoding=utf8");
        dbConnProperties.setDriverClassName("com.mysql.jdbc.Driver");
        dbConnProperties.setPassword("123456");
        dbConnProperties.setUsername("root");
        SqlSessionFactoryBean sqlSessionFactoryBean = sqlSessionFactoryCache.getFromCache(dbConnProperties);

        TablesDAO tablesDAO = sqlSessionFactoryBean.getObject().openSession().getMapper(TablesDAO.class);
        List<TablesVo> tablesVos = tablesDAO.queryBase(null);
        log.info("tablesVos:{}", tablesVos);

    }
}
