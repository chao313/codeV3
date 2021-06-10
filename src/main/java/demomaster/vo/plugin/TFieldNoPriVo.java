package demomaster.vo.plugin;


/**
 * 这里属性是非主键字段
 *
 * 表名称      :t_field
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public class TFieldNoPriVo {

    private String fieldJavaName;  // 字段java名称 
    private String fieldType;  // 数据类型 
    private String fieldJavaType;  // 对应的java类型 
    private String fieldComment;  // 注释 
    private String fieldIsNotNull;  // 是否允许为空 
    private String fieldIsPri;  // 是否是主键 
    private String fieldChinaName;  // 字段的中文 
    private String fieldEnumValue;  // 如果是枚举,直接是枚举值 
    private String fieldIsBusinessUniq;  // 是否是业务唯一性 
    private String fieldIsQuery;  // 是否参与查询 
    private String fieldIsReturn;  // 是否参与返回 
    private String fieldIsInsert;  // 是否参与插入 
    private String fieldIsAutoIncrement;  // 是否自动递增(递增的默认不参与插入) 


    public String getFieldJavaName() {

        return fieldJavaName;

    }

    public void setFieldJavaName(String fieldJavaName) {

        this.fieldJavaName = fieldJavaName;

    }
    public String getFieldType() {

        return fieldType;

    }

    public void setFieldType(String fieldType) {

        this.fieldType = fieldType;

    }
    public String getFieldJavaType() {

        return fieldJavaType;

    }

    public void setFieldJavaType(String fieldJavaType) {

        this.fieldJavaType = fieldJavaType;

    }
    public String getFieldComment() {

        return fieldComment;

    }

    public void setFieldComment(String fieldComment) {

        this.fieldComment = fieldComment;

    }
    public String getFieldIsNotNull() {

        return fieldIsNotNull;

    }

    public void setFieldIsNotNull(String fieldIsNotNull) {

        this.fieldIsNotNull = fieldIsNotNull;

    }
    public String getFieldIsPri() {

        return fieldIsPri;

    }

    public void setFieldIsPri(String fieldIsPri) {

        this.fieldIsPri = fieldIsPri;

    }
    public String getFieldChinaName() {

        return fieldChinaName;

    }

    public void setFieldChinaName(String fieldChinaName) {

        this.fieldChinaName = fieldChinaName;

    }
    public String getFieldEnumValue() {

        return fieldEnumValue;

    }

    public void setFieldEnumValue(String fieldEnumValue) {

        this.fieldEnumValue = fieldEnumValue;

    }
    public String getFieldIsBusinessUniq() {

        return fieldIsBusinessUniq;

    }

    public void setFieldIsBusinessUniq(String fieldIsBusinessUniq) {

        this.fieldIsBusinessUniq = fieldIsBusinessUniq;

    }
    public String getFieldIsQuery() {

        return fieldIsQuery;

    }

    public void setFieldIsQuery(String fieldIsQuery) {

        this.fieldIsQuery = fieldIsQuery;

    }
    public String getFieldIsReturn() {

        return fieldIsReturn;

    }

    public void setFieldIsReturn(String fieldIsReturn) {

        this.fieldIsReturn = fieldIsReturn;

    }
    public String getFieldIsInsert() {

        return fieldIsInsert;

    }

    public void setFieldIsInsert(String fieldIsInsert) {

        this.fieldIsInsert = fieldIsInsert;

    }
    public String getFieldIsAutoIncrement() {

        return fieldIsAutoIncrement;

    }

    public void setFieldIsAutoIncrement(String fieldIsAutoIncrement) {

        this.fieldIsAutoIncrement = fieldIsAutoIncrement;

    }

    @Override
    public String toString() {
        return "TFieldNoPriVo{" +
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
