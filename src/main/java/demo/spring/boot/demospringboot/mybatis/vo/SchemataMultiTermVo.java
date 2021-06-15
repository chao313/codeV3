package demo.spring.boot.demospringboot.mybatis.vo;

import demo.spring.boot.demospringboot.framework.MultiTerm;

/**
 * 表名称      :SCHEMATA
 * 表类型      :SYSTEM VIEW
 * 表引擎      :MEMORY
 * 表版本      :10
 * 行格式      :Fixed
 * 表创建      :2020-5-30
 * 字符集      :utf8_general_ci
 * 表注释      :
 */
public class SchemataMultiTermVo {

    private MultiTerm<String> catalogName; 
    private MultiTerm<String> schemaName; 
    private MultiTerm<String> defaultCharacterSetName; 
    private MultiTerm<String> defaultCollationName; 
    private MultiTerm<String> sqlPath; 


    public MultiTerm<String> getCatalogName() {

        return catalogName;

    }

    public void setCatalogName(MultiTerm<String> catalogName) {

        this.catalogName = catalogName;

    }
    public MultiTerm<String> getSchemaName() {

        return schemaName;

    }

    public void setSchemaName(MultiTerm<String> schemaName) {

        this.schemaName = schemaName;

    }
    public MultiTerm<String> getDefaultCharacterSetName() {

        return defaultCharacterSetName;

    }

    public void setDefaultCharacterSetName(MultiTerm<String> defaultCharacterSetName) {

        this.defaultCharacterSetName = defaultCharacterSetName;

    }
    public MultiTerm<String> getDefaultCollationName() {

        return defaultCollationName;

    }

    public void setDefaultCollationName(MultiTerm<String> defaultCollationName) {

        this.defaultCollationName = defaultCollationName;

    }
    public MultiTerm<String> getSqlPath() {

        return sqlPath;

    }

    public void setSqlPath(MultiTerm<String> sqlPath) {

        this.sqlPath = sqlPath;

    }

    @Override
    public String toString() {
        return "SchemataMultiTermVo{" +
                ", catalogName '" + catalogName + '\'' +
                ", schemaName '" + schemaName + '\'' +
                ", defaultCharacterSetName '" + defaultCharacterSetName + '\'' +
                ", defaultCollationName '" + defaultCollationName + '\'' +
                ", sqlPath '" + sqlPath + '\'' +
                '}';
    }

}
