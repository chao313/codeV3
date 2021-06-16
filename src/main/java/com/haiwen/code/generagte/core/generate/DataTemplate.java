package com.haiwen.code.generagte.core.generate;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.JavaField;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.MysqlField;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.Table;

import java.util.List;
import java.util.Set;

/**
 * @author chao
 * @version 1.0
 * @description: TODO
 * @date 2021/6/17 上午12:01
 */
public abstract class DataTemplate {
    /**
     * 1.全部字段(遍历)
     * 2.主键字段(遍历)
     * 3.非主键字段(遍历)
     * 4.全部字段类型
     *
     */

    private String packageName;//包名
    private String dir = "vo";//文件夹名称
    private String className;//class名称
    private String fileName;//file名称
    private String freeMarkFtlPath = "Vo.ftl";//生成FreeMark的ftlPath
    private String freeMarkStr;//生成FreeMark的str
    private List<MysqlField> primaryKeyMysqlFields;//主键字段(mysql)
    private List<MysqlField> mysqlFields;//全部字段(mysql)
    private List<JavaField> primaryKeyJavaFields;//主键字段(java的)
    private List<JavaField> javaFields;//全部字段(java的)
    private Set<String> javaFieldTypes;//全部不重复的字段Type(java的)
    /**
     * 包含:表名称,表类型,引擎,表的字符集,表的注释
     */
    private Table table;//包含表
    private String freeMarkDirPathInResources = rootPath + "java";//freemark所在文件夹的地址
}
