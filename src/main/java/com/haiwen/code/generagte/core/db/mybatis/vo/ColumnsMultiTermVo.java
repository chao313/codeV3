package com.haiwen.code.generagte.core.db.mybatis.vo;

import demo.spring.boot.demospringboot.framework.MultiTerm;

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
public class ColumnsMultiTermVo {

    private MultiTerm<String> tableCatalog; 
    private MultiTerm<String> tableSchema; 
    private MultiTerm<String> tableName; 
    private MultiTerm<String> columnName; 
    private MultiTerm<Long> ordinalPosition; 
    private MultiTerm<String> columnDefault; 
    private MultiTerm<String> isNullable; 
    private MultiTerm<String> dataType; 
    private MultiTerm<Long> characterMaximumLength; 
    private MultiTerm<Long> characterOctetLength; 
    private MultiTerm<Long> numericPrecision; 
    private MultiTerm<Long> numericScale; 
    private MultiTerm<Long> datetimePrecision; 
    private MultiTerm<String> characterSetName; 
    private MultiTerm<String> collationName; 
    private MultiTerm<String> columnType; 
    private MultiTerm<String> columnKey; 
    private MultiTerm<String> extra; 
    private MultiTerm<String> privileges; 
    private MultiTerm<String> columnComment; 
    private MultiTerm<String> generationExpression; 


    public MultiTerm<String> getTableCatalog() {

        return tableCatalog;

    }

    public void setTableCatalog(MultiTerm<String> tableCatalog) {

        this.tableCatalog = tableCatalog;

    }
    public MultiTerm<String> getTableSchema() {

        return tableSchema;

    }

    public void setTableSchema(MultiTerm<String> tableSchema) {

        this.tableSchema = tableSchema;

    }
    public MultiTerm<String> getTableName() {

        return tableName;

    }

    public void setTableName(MultiTerm<String> tableName) {

        this.tableName = tableName;

    }
    public MultiTerm<String> getColumnName() {

        return columnName;

    }

    public void setColumnName(MultiTerm<String> columnName) {

        this.columnName = columnName;

    }
    public MultiTerm<Long> getOrdinalPosition() {

        return ordinalPosition;

    }

    public void setOrdinalPosition(MultiTerm<Long> ordinalPosition) {

        this.ordinalPosition = ordinalPosition;

    }
    public MultiTerm<String> getColumnDefault() {

        return columnDefault;

    }

    public void setColumnDefault(MultiTerm<String> columnDefault) {

        this.columnDefault = columnDefault;

    }
    public MultiTerm<String> getIsNullable() {

        return isNullable;

    }

    public void setIsNullable(MultiTerm<String> isNullable) {

        this.isNullable = isNullable;

    }
    public MultiTerm<String> getDataType() {

        return dataType;

    }

    public void setDataType(MultiTerm<String> dataType) {

        this.dataType = dataType;

    }
    public MultiTerm<Long> getCharacterMaximumLength() {

        return characterMaximumLength;

    }

    public void setCharacterMaximumLength(MultiTerm<Long> characterMaximumLength) {

        this.characterMaximumLength = characterMaximumLength;

    }
    public MultiTerm<Long> getCharacterOctetLength() {

        return characterOctetLength;

    }

    public void setCharacterOctetLength(MultiTerm<Long> characterOctetLength) {

        this.characterOctetLength = characterOctetLength;

    }
    public MultiTerm<Long> getNumericPrecision() {

        return numericPrecision;

    }

    public void setNumericPrecision(MultiTerm<Long> numericPrecision) {

        this.numericPrecision = numericPrecision;

    }
    public MultiTerm<Long> getNumericScale() {

        return numericScale;

    }

    public void setNumericScale(MultiTerm<Long> numericScale) {

        this.numericScale = numericScale;

    }
    public MultiTerm<Long> getDatetimePrecision() {

        return datetimePrecision;

    }

    public void setDatetimePrecision(MultiTerm<Long> datetimePrecision) {

        this.datetimePrecision = datetimePrecision;

    }
    public MultiTerm<String> getCharacterSetName() {

        return characterSetName;

    }

    public void setCharacterSetName(MultiTerm<String> characterSetName) {

        this.characterSetName = characterSetName;

    }
    public MultiTerm<String> getCollationName() {

        return collationName;

    }

    public void setCollationName(MultiTerm<String> collationName) {

        this.collationName = collationName;

    }
    public MultiTerm<String> getColumnType() {

        return columnType;

    }

    public void setColumnType(MultiTerm<String> columnType) {

        this.columnType = columnType;

    }
    public MultiTerm<String> getColumnKey() {

        return columnKey;

    }

    public void setColumnKey(MultiTerm<String> columnKey) {

        this.columnKey = columnKey;

    }
    public MultiTerm<String> getExtra() {

        return extra;

    }

    public void setExtra(MultiTerm<String> extra) {

        this.extra = extra;

    }
    public MultiTerm<String> getPrivileges() {

        return privileges;

    }

    public void setPrivileges(MultiTerm<String> privileges) {

        this.privileges = privileges;

    }
    public MultiTerm<String> getColumnComment() {

        return columnComment;

    }

    public void setColumnComment(MultiTerm<String> columnComment) {

        this.columnComment = columnComment;

    }
    public MultiTerm<String> getGenerationExpression() {

        return generationExpression;

    }

    public void setGenerationExpression(MultiTerm<String> generationExpression) {

        this.generationExpression = generationExpression;

    }

    @Override
    public String toString() {
        return "ColumnsMultiTermVo{" +
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
