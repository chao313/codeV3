package com.haiwen.code.generagte.core.bo;


import lombok.Data;

/**
 * 表名称      :COLUMNS
 * 表类型      :SYSTEM VIEW
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Dynamic
 * 表创建      :
 * 字符集      :utf8_general_ci
 * 表注释      :
 */
@Data
public class ColumnsBo {

    private String tableCatalog; //表目录
    private String tableSchema; //库名
    private String tableName; //表名
    private String columnName; //列名
    private Long ordinalPosition; //字段标识
    private String columnDefault; //字段默认值
    private String isNullable; //是否允许为空
    private String dataType; //数据类型
    private Long characterMaximumLength;//以字符为单位的最大长度
    private Long characterOctetLength;//以字节为单位的最大长度
    private Long numericPrecision;
    private Long numericScale;
    private Long datetimePrecision;
    private String characterSetName;
    private String collationName;
    private String columnType;//列类型 varchar(256)
    /**
     * 如果Key是PRI,  那么该列是主键的组成部分
     * 如果Key是UNI,  那么该列是一个唯一值索引的第一列(前导列),并别不能含有空值(NULL)
     * 如果Key是MUL,  那么该列的值可以重复, 该列是一个非唯一索引的前导列(第一列)或者是一个唯一性索引的组成部分但是可以含有空值NULL
     */
    private String columnKey;
    private String extra;
    private String privileges;
    private String columnComment;//列注释
    private String generationExpression;
}
