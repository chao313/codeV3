package demo.spring.boot.demospringboot.mybatis.vo;


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
public class SchemataVo {

    private String catalogName; //目录名称
    private String schemaName; //库名
    private String defaultCharacterSetName; //默认字符集
    private String defaultCollationName; //默认排序规则
    private String sqlPath; //路径


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
        return "SchemataBo{" +
                ", catalogName '" + catalogName + '\'' +
                ", schemaName '" + schemaName + '\'' +
                ", defaultCharacterSetName '" + defaultCharacterSetName + '\'' +
                ", defaultCollationName '" + defaultCollationName + '\'' +
                ", sqlPath '" + sqlPath + '\'' +
                '}';
    }

}
