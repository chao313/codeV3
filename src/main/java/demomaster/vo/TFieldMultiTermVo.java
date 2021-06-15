package demomaster.vo;

import demo.spring.boot.demospringboot.framework.MultiTerm;

/**
 * 表名称      :t_field
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public class TFieldMultiTermVo {

    private MultiTerm<String> dbName;  // 库名
    private MultiTerm<String> dbTableName;  // 表名
    private MultiTerm<String> fieldName;  // 字段名称
    private MultiTerm<String> fieldJavaName;  // 字段java名称
    private MultiTerm<String> fieldType;  // 数据类型
    private MultiTerm<String> fieldJavaType;  // 对应的java类型
    private MultiTerm<String> fieldComment;  // 注释
    private MultiTerm<String> fieldIsNotNull;  // 是否允许为空
    private MultiTerm<String> fieldIsPri;  // 是否是主键
    private MultiTerm<String> fieldChinaName;  // 字段的中文
    private MultiTerm<String> fieldEnumValue;  // 如果是枚举,直接是枚举值
    private MultiTerm<String> fieldIsBusinessUniq;  // 是否是业务唯一性
    private MultiTerm<String> fieldIsQuery;  // 是否参与查询
    private MultiTerm<String> fieldIsReturn;  // 是否参与返回
    private MultiTerm<String> fieldIsInsert;  // 是否参与插入
    private MultiTerm<String> fieldIsAutoIncrement;  // 是否自动递增(递增的默认不参与插入)


    public MultiTerm<String> getDbName() {

        return dbName;

    }

    public void setDbName(MultiTerm<String> dbName) {

        this.dbName = dbName;

    }
    public MultiTerm<String> getDbTableName() {

        return dbTableName;

    }

    public void setDbTableName(MultiTerm<String> dbTableName) {

        this.dbTableName = dbTableName;

    }
    public MultiTerm<String> getFieldName() {

        return fieldName;

    }

    public void setFieldName(MultiTerm<String> fieldName) {

        this.fieldName = fieldName;

    }
    public MultiTerm<String> getFieldJavaName() {

        return fieldJavaName;

    }

    public void setFieldJavaName(MultiTerm<String> fieldJavaName) {

        this.fieldJavaName = fieldJavaName;

    }
    public MultiTerm<String> getFieldType() {

        return fieldType;

    }

    public void setFieldType(MultiTerm<String> fieldType) {

        this.fieldType = fieldType;

    }
    public MultiTerm<String> getFieldJavaType() {

        return fieldJavaType;

    }

    public void setFieldJavaType(MultiTerm<String> fieldJavaType) {

        this.fieldJavaType = fieldJavaType;

    }
    public MultiTerm<String> getFieldComment() {

        return fieldComment;

    }

    public void setFieldComment(MultiTerm<String> fieldComment) {

        this.fieldComment = fieldComment;

    }
    public MultiTerm<String> getFieldIsNotNull() {

        return fieldIsNotNull;

    }

    public void setFieldIsNotNull(MultiTerm<String> fieldIsNotNull) {

        this.fieldIsNotNull = fieldIsNotNull;

    }
    public MultiTerm<String> getFieldIsPri() {

        return fieldIsPri;

    }

    public void setFieldIsPri(MultiTerm<String> fieldIsPri) {

        this.fieldIsPri = fieldIsPri;

    }
    public MultiTerm<String> getFieldChinaName() {

        return fieldChinaName;

    }

    public void setFieldChinaName(MultiTerm<String> fieldChinaName) {

        this.fieldChinaName = fieldChinaName;

    }
    public MultiTerm<String> getFieldEnumValue() {

        return fieldEnumValue;

    }

    public void setFieldEnumValue(MultiTerm<String> fieldEnumValue) {

        this.fieldEnumValue = fieldEnumValue;

    }
    public MultiTerm<String> getFieldIsBusinessUniq() {

        return fieldIsBusinessUniq;

    }

    public void setFieldIsBusinessUniq(MultiTerm<String> fieldIsBusinessUniq) {

        this.fieldIsBusinessUniq = fieldIsBusinessUniq;

    }
    public MultiTerm<String> getFieldIsQuery() {

        return fieldIsQuery;

    }

    public void setFieldIsQuery(MultiTerm<String> fieldIsQuery) {

        this.fieldIsQuery = fieldIsQuery;

    }
    public MultiTerm<String> getFieldIsReturn() {

        return fieldIsReturn;

    }

    public void setFieldIsReturn(MultiTerm<String> fieldIsReturn) {

        this.fieldIsReturn = fieldIsReturn;

    }
    public MultiTerm<String> getFieldIsInsert() {

        return fieldIsInsert;

    }

    public void setFieldIsInsert(MultiTerm<String> fieldIsInsert) {

        this.fieldIsInsert = fieldIsInsert;

    }
    public MultiTerm<String> getFieldIsAutoIncrement() {

        return fieldIsAutoIncrement;

    }

    public void setFieldIsAutoIncrement(MultiTerm<String> fieldIsAutoIncrement) {

        this.fieldIsAutoIncrement = fieldIsAutoIncrement;

    }

    @Override
    public String toString() {
        return "TFieldMultiTermVo{" +
                ", dbName '" + dbName + '\'' +
                ", dbTableName '" + dbTableName + '\'' +
                ", fieldName '" + fieldName + '\'' +
                ", fieldJavaName '" + fieldJavaName + '\'' +
                ", fieldType '" + fieldType + '\'' +
                ", fieldJavaType '" + fieldJavaType + '\'' +
                ", fieldComment '" + fieldComment + '\'' +
                ", fieldIsNotNull '" + fieldIsNotNull + '\'' +
                ", fieldIsPri '" + fieldIsPri + '\'' +
                ", fieldChinaName '" + fieldChinaName + '\'' +
                ", fieldEnumValue '" + fieldEnumValue + '\'' +
                ", fieldIsBusinessUniq '" + fieldIsBusinessUniq + '\'' +
                ", fieldIsQuery '" + fieldIsQuery + '\'' +
                ", fieldIsReturn '" + fieldIsReturn + '\'' +
                ", fieldIsInsert '" + fieldIsInsert + '\'' +
                ", fieldIsAutoIncrement '" + fieldIsAutoIncrement + '\'' +
                '}';
    }

}
