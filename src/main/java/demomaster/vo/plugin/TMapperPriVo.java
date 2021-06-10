package demomaster.vo.plugin;


/**
 * 这里属性是主键字段
 *
 * 表名称      :t_mapper
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public class TMapperPriVo {

    private String dbName;  // 库名 
    private String dbTableName;  // 表名 


    public String getDbName() {

        return dbName;

    }

    public void setDbName(String dbName) {

        this.dbName = dbName;

    }
    public String getDbTableName() {

        return dbTableName;

    }

    public void setDbTableName(String dbTableName) {

        this.dbTableName = dbTableName;

    }

    @Override
    public String toString() {
        return "TMapperPriVo{" +
                ", dbName '" + dbName + '\'' +
                ", dbTableName '" + dbTableName + '\'' +
                '}';
    }

}
