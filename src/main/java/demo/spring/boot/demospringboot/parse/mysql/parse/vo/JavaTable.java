package demo.spring.boot.demospringboot.parse.mysql.parse.vo;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.JavaField;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.MysqlAndJavaField;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.util.List;

/**
 * 这个是专门在 freemark 中使用的
 *
 * 整数类型：BIT、BOOL、TINY INT、SMALL INT、MEDIUM INT、 INT、 BIG INT
 * <p>
 * 浮点数类型：FLOAT、DOUBLE、DECIMAL
 * <p>
 * 字符串类型：CHAR、VARCHAR、TINY TEXT、TEXT、MEDIUM TEXT、LONGTEXT、TINY BLOB、BLOB、MEDIUM BLOB、LONG BLOB
 * <p>
 * 日期类型：Date、DateTime、TimeStamp、Time、Year
 * <p>
 * 其他数据类型：BINARY、VARBINARY、ENUM、SET、Geometry、Point、MultiPoint、LineString、MultiLineString、Polygon、GeometryCollection等
 */

@Data
@Slf4j
@ToString
public class JavaTable {
    String tableName;                  //TABLE_NAME
    String tableType;                  //TABLE_TYPE
    String engine;                     //ENGINE
    int version;                       //VERSION
    String rowFormat;                  //ROW_FORMAT
    Date createTime;                   //CREATE_TIME
    String tableCollation;             //TABLE_COLLATION
    String tableComment;               //TABLE_COMMENT
    private List<JavaField> javaFields;//java字段信息
    private List<JavaField> primaryKeys;//java key
    private MysqlTable mysqlTable;//java key
    private List<MysqlAndJavaField> mysqlAndJavaFields;//存放mysl和java的对应map
    private List<MysqlAndJavaField> mysqlAndJavaKeys;//存放mysl和java的key的对应map
    private List<String> javaFieldTypeNameUnique;//java字段Type - 去掉重复字段
    private List<String> primaryKeyTypeNameUnique;//java key Type - 去掉重复字段
    private String basePackage;
    private String basePackagePath;

    private String classVoName;
    private String classVoPackage;
    private String classVoPath;
    private String classVoStr;

    private String classDAOName;
    private String classDAOPackage;
    private String classDaoPath;
    private String classDaoStr;

    private String classServiceName;
    private String classServicePackage;
    private String classServicePath;
    private String classServiceStr;

    private String classServiceImplName;
    private String classServiceImplPackage;
    private String classServiceImplPath;
    private String classServiceImplStr;

    private String classControllerName;
    private String classControllerPackage;
    private String classControllerPath;
    private String classControllerStr;

    private String mapperName;
    private String mapperPath;
    private String mapperStr;



}
