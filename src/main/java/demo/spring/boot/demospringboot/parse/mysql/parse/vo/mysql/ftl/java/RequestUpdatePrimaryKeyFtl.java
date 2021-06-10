package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.Table;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.FtlJavaInterface;
import lombok.Data;

/**
 * 准备和FTL绑定的
 * 这个是只包含主键的vo -> 用于update使用，当然，其他的也可以使用
 */
@Data
public class RequestUpdatePrimaryKeyFtl implements FtlJavaInterface {
    private String packageName;//包名
    private String dir = "request";//文件夹名称
    private String className;//class名称
    private String fileName;//file名称
    private String freeMarkFtlPath = "RequestUpdatePrimaryKey.ftl";//生成FreeMark的ftlPath
    private String freeMarkStr;//生成FreeMark的str
    /**
     * 包含:表名称,表类型,引擎,表的字符集,表的注释
     */
    private Table table;//包含表
    private String freeMarkDirPathInResources = rootPath + "java";//freemark所在文件夹的地址
}
