package com.haiwen.code.generagte.core.bo;


import lombok.Data;

/**
 * 数据库信息
 * 表名称      :SCHEMATA
 * 表类型      :SYSTEM VIEW
 * 表引擎      :MEMORY
 * 表版本      :10
 * 行格式      :Fixed
 * 表创建      :2020-5-30
 * 字符集      :utf8_general_ci
 * 表注释      :
 */
@Data
public class SchemataBo {
    private String catalogName; //目录名称
    private String schemaName; //库名
    private String defaultCharacterSetName; //默认字符集
    private String defaultCollationName; //默认排序规则
    private String sqlPath; //路径

}
