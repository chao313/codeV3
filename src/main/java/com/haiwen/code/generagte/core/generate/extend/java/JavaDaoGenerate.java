package com.haiwen.code.generagte.core.generate.extend.java;

import com.haiwen.code.generagte.core.generate.GenerateTemplate;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.GenerateJavaUtil;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.JavaField;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.MysqlField;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.Table;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java.AllJavaFtl;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java.DAOFtl;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author chao
 * @version 1.0
 * @description: TODO
 * @date 2021/6/17 上午12:20
 */
public class JavaDaoGenerate extends GenerateTemplate<> {

    /**
     * DAO文件的操作
     */
    private static DAOFtl getDAOFtl(Table table,
                                    String basePackage,
                                    String classNamePrefix,
                                    List<MysqlField> mysqlFields,
                                    List<MysqlField> primaryKeyMysqlFields,
                                    List<JavaField> javaFields,
                                    List<JavaField> primaryKeyJavaFields,
                                    Set<String> javaFieldTypes,
                                    AllJavaFtl allJavaFtl
    ) throws IOException, TemplateException {
        DAOFtl daoFtl = new GenerateJavaUtil<DAOFtl>() {
            @Override
            public DAOFtl getFtlVo() {
                DAOFtl vo = new DAOFtl();
                vo.setTable(table);
                vo.setPackageName(basePackage.toLowerCase() + "." + vo.getDir());
                vo.setClassName(classNamePrefix + "DAO");
                vo.setMysqlFields(mysqlFields);
                vo.setPrimaryKeyMysqlFields(primaryKeyMysqlFields);
                vo.setJavaFields(javaFields);
                vo.setPrimaryKeyJavaFields(primaryKeyJavaFields);
                vo.setJavaFieldTypes(javaFieldTypes);
                //使用之前提取的className直接加上.java
                vo.setFileName(vo.getClassName() + ".java");
                return vo;
            }

            @Override
            public AllJavaFtl getAllJavaFtl() {
                return allJavaFtl;
            }
        }.grenerate();

        return daoFtl;
    }
}
