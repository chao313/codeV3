package com.haiwen.code.generagte.framework.runner;

import com.haiwen.code.generagte.base.extend.SqlSessionFactoryCache;
import com.haiwen.code.generagte.core.bo.jdbc.DbConnProperties;
import com.haiwen.code.generagte.core.db.mybatis.dao.ColumnsDAO;
import com.haiwen.code.generagte.core.db.mybatis.dao.SchemataDAO;
import com.haiwen.code.generagte.core.db.mybatis.dao.TablesDAO;
import com.haiwen.code.generagte.helper.DbConnPropertiesHelper;
import com.haiwen.code.generagte.util.AwareUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Runner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("启动参数为:{}", args);
        this.init();
    }

    @Autowired
    private SqlSessionFactoryCache sqlSessionFactoryCache;

    public void init() throws Exception {
        DbConnProperties ymlDbConnProperties = DbConnPropertiesHelper.getYmlDbConnProperties();
        ColumnsDAO columnsDAO = sqlSessionFactoryCache.getMapper(ymlDbConnProperties, ColumnsDAO.class);
        SchemataDAO schemataDAO = sqlSessionFactoryCache.getMapper(ymlDbConnProperties, SchemataDAO.class);
        TablesDAO tablesDAO = sqlSessionFactoryCache.getMapper(ymlDbConnProperties, TablesDAO.class);
        registerSingleton(columnsDAO);
        registerSingleton(schemataDAO);
        registerSingleton(tablesDAO);
    }

    private <T> void registerSingleton(T t) {
        ApplicationContext ctx = AwareUtil.applicationContext;
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) ctx.getAutowireCapableBeanFactory();
        defaultListableBeanFactory.registerSingleton(t.getClass().getSimpleName(), t);
    }

}
