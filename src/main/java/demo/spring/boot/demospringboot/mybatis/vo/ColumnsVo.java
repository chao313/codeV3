package demo.spring.boot.demospringboot.mybatis.vo;


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
public class ColumnsVo {

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
    private String columnKey;//如果Key是PRI,  那么该列是主键的组成部分 | 如果Key是UNI,  那么该列是一个唯一值索引的第一列(前导列),并别不能含有空值(NULL) | 如果Key是MUL,  那么该列的值可以重复, 该列是一个非唯一索引的前导列(第一列)或者是一个唯一性索引的组成部分但是可以含有空值NULL
    private String extra;
    private String privileges;
    private String columnComment;//列注释
    private String generationExpression;


    public String getTableCatalog() {

        return tableCatalog;

    }

    public void setTableCatalog(String tableCatalog) {

        this.tableCatalog = tableCatalog;

    }

    public String getTableSchema() {

        return tableSchema;

    }

    public void setTableSchema(String tableSchema) {

        this.tableSchema = tableSchema;

    }

    public String getTableName() {

        return tableName;

    }

    public void setTableName(String tableName) {

        this.tableName = tableName;

    }

    public String getColumnName() {

        return columnName;

    }

    public void setColumnName(String columnName) {

        this.columnName = columnName;

    }

    public Long getOrdinalPosition() {

        return ordinalPosition;

    }

    public void setOrdinalPosition(Long ordinalPosition) {

        this.ordinalPosition = ordinalPosition;

    }

    public String getColumnDefault() {

        return columnDefault;

    }

    public void setColumnDefault(String columnDefault) {

        this.columnDefault = columnDefault;

    }

    public String getIsNullable() {

        return isNullable;

    }

    public void setIsNullable(String isNullable) {

        this.isNullable = isNullable;

    }

    public String getDataType() {

        return dataType;

    }

    public void setDataType(String dataType) {

        this.dataType = dataType;

    }

    public Long getCharacterMaximumLength() {

        return characterMaximumLength;

    }

    public void setCharacterMaximumLength(Long characterMaximumLength) {

        this.characterMaximumLength = characterMaximumLength;

    }

    public Long getCharacterOctetLength() {

        return characterOctetLength;

    }

    public void setCharacterOctetLength(Long characterOctetLength) {

        this.characterOctetLength = characterOctetLength;

    }

    public Long getNumericPrecision() {

        return numericPrecision;

    }

    public void setNumericPrecision(Long numericPrecision) {

        this.numericPrecision = numericPrecision;

    }

    public Long getNumericScale() {

        return numericScale;

    }

    public void setNumericScale(Long numericScale) {

        this.numericScale = numericScale;

    }

    public Long getDatetimePrecision() {

        return datetimePrecision;

    }

    public void setDatetimePrecision(Long datetimePrecision) {

        this.datetimePrecision = datetimePrecision;

    }

    public String getCharacterSetName() {

        return characterSetName;

    }

    public void setCharacterSetName(String characterSetName) {

        this.characterSetName = characterSetName;

    }

    public String getCollationName() {

        return collationName;

    }

    public void setCollationName(String collationName) {

        this.collationName = collationName;

    }

    public String getColumnType() {

        return columnType;

    }

    public void setColumnType(String columnType) {

        this.columnType = columnType;

    }

    public String getColumnKey() {

        return columnKey;

    }

    public void setColumnKey(String columnKey) {

        this.columnKey = columnKey;

    }

    public String getExtra() {

        return extra;

    }

    public void setExtra(String extra) {

        this.extra = extra;

    }

    public String getPrivileges() {

        return privileges;

    }

    public void setPrivileges(String privileges) {

        this.privileges = privileges;

    }

    public String getColumnComment() {

        return columnComment;

    }

    public void setColumnComment(String columnComment) {

        this.columnComment = columnComment;

    }

    public String getGenerationExpression() {

        return generationExpression;

    }

    public void setGenerationExpression(String generationExpression) {

        this.generationExpression = generationExpression;

    }


    @Override
    public String toString() {
        return "ColumnsVo{" +
                ", tableCatalog '" + tableCatalog + '\'' +
                ", tableSchema '" + tableSchema + '\'' +
                ", tableName '" + tableName + '\'' +
                ", columnName '" + columnName + '\'' +
                ", ordinalPosition '" + ordinalPosition +
                ", columnDefault '" + columnDefault + '\'' +
                ", isNullable '" + isNullable + '\'' +
                ", dataType '" + dataType + '\'' +
                ", characterMaximumLength '" + characterMaximumLength +
                ", characterOctetLength '" + characterOctetLength +
                ", numericPrecision '" + numericPrecision +
                ", numericScale '" + numericScale +
                ", datetimePrecision '" + datetimePrecision +
                ", characterSetName '" + characterSetName + '\'' +
                ", collationName '" + collationName + '\'' +
                ", columnType '" + columnType + '\'' +
                ", columnKey '" + columnKey + '\'' +
                ", extra '" + extra + '\'' +
                ", privileges '" + privileges + '\'' +
                ", columnComment '" + columnComment + '\'' +
                ", generationExpression '" + generationExpression + '\'' +
                '}';
    }

}
