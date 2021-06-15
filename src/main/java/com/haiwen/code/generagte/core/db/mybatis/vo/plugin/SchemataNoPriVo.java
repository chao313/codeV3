package com.haiwen.code.generagte.core.db.mybatis.vo.plugin;


/**
 * 这里属性是非主键字段
 *
 * 表名称      :SCHEMATA
 * 表类型      :SYSTEM VIEW
 * 表引擎      :MEMORY
 * 表版本      :10
 * 行格式      :Fixed
 * 表创建      :2020-5-30
 * 字符集      :utf8_general_ci
 * 表注释      :
 */
public class SchemataNoPriVo {

    private String catalogName; 
    private String schemaName; 
    private String defaultCharacterSetName; 
    private String defaultCollationName; 
    private String sqlPath; 


    public String getCatalogName() {

        return catalogName;

    }

    public void setCatalogName(String catalogName) {

        this.catalogName = catalogName;

    }
    public String getSchemaName() {

        return schemaName;

    }

    public void setSchemaName(String schemaName) {

        this.schemaName = schemaName;

    }
    public String getDefaultCharacterSetName() {

        return defaultCharacterSetName;

    }

    public void setDefaultCharacterSetName(String defaultCharacterSetName) {

        this.defaultCharacterSetName = defaultCharacterSetName;

    }
    public String getDefaultCollationName() {

        return defaultCollationName;

    }

    public void setDefaultCollationName(String defaultCollationName) {

        this.defaultCollationName = defaultCollationName;

    }
    public String getSqlPath() {

        return sqlPath;

    }

    public void setSqlPath(String sqlPath) {

        this.sqlPath = sqlPath;

    }

    @Override
    public String toString() {
        return "SchemataNoPriVo{" +
                ", catalogName '" + catalogName + '\'' +
                ", schemaName '" + schemaName + '\'' +
                ", defaultCharacterSetName '" + defaultCharacterSetName + '\'' +
                ", defaultCollationName '" + defaultCollationName + '\'' +
                ", sqlPath '" + sqlPath + '\'' +
                '}';
    }

}
