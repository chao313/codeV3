package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.JavaField;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.MysqlField;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.Table;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.FtlJavaInterface;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * 准备和FTL绑定的
 */
@Data
public class ServiceFtl implements FtlJavaInterface {
    private String packageName;//包名
    private String dir = "service";//文件夹名称
    private String className;//class名称
    private String fileName;//file名称
    private String freeMarkFtlPath = "Service.ftl";//生成FreeMark的ftlPath
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
