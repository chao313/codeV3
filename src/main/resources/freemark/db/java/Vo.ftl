package ${vo.packageName};

${vo.imports}

/**
 * 库名称      :${vo.dbName}
 * 表类型      :${vo.dbTableName}
 * 表注释      :${vo.dbTableComment}
 */
public class ${vo.className} {

<#list tFieldVos as fieldVo>
    <#if fieldVo.fieldType == 'year'>
    @ApiModelProperty(example = "1970")
    <#elseif fieldVo.fieldType == 'time'>
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "HH:mm:ss")
    @ApiModelProperty(dataType = "date", example = "12:12:12")
    <#elseif fieldVo.fieldType == 'date'>
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(dataType = "date", example = "1970-01-01")
    <#elseif fieldVo.fieldType == 'datetime'>
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(dataType = "date", example = "1970-01-01 12:12:12")
    <#elseif fieldVo.fieldType == 'timestamp'>
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(dataType = "date", example = "1970-01-01 12:12:12")
    </#if>
    private ${fieldVo.fieldJavaType} ${fieldVo.fieldJavaName}; <#if fieldVo.fieldComment?? && fieldVo.fieldComment !=""> // ${fieldVo.fieldComment} </#if>
</#list>

<#list tFieldVos as fieldVo>

    public ${fieldVo.fieldJavaType} get${fieldVo.fieldJavaName?cap_first}() {

        return ${fieldVo.fieldJavaName};

    }

    public void set${fieldVo.fieldJavaName?cap_first}(${fieldVo.fieldJavaType} ${fieldVo.fieldJavaName}) {

        this.${fieldVo.fieldJavaName} = ${fieldVo.fieldJavaName};

    }

</#list>

    @Override
    public String toString() {
        return "${vo.className}{" +
<#list tFieldVos as fieldVo>
                ", ${fieldVo.fieldJavaName} '" + ${fieldVo.fieldJavaName} +<#if fieldVo.fieldJavaType = 'String' > '\'' +</#if>
</#list>
                '}';
    }

}
