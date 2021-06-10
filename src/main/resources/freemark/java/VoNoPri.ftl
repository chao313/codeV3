package ${ftlVo.packageName};

<#list ftlVo.javaFieldTypes as type><#if type = "Timestamp" >import java.sql.Timestamp;
</#if><#if type = "Time" >import java.sql.Time;
</#if><#if type = "Date" >import java.util.Date;
</#if></#list>
<#list ftlVo.javaFields as field>
    <#if field.isPRI == false>
        <#if field.dbType == 'time' ||  field.dbType == 'Date' || field.dbType == 'datetime' || field.dbType == 'timestamp' >
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
            <#break>
        </#if>
    </#if>
</#list>

/**
 * 这里属性是非主键字段
 *
 * 表名称      :${ftlVo.table.tableName}
 * 表类型      :${ftlVo.table.tableType}
 * 表引擎      :${ftlVo.table.engine}
 * 表版本      :${ftlVo.table.version}
 * 行格式      :${ftlVo.table.rowFormat}
 * 表创建      :${ftlVo.table.createTime}
 * 字符集      :${ftlVo.table.tableCollation}
 * 表注释      :${ftlVo.table.tableComment}
 */
public class ${ftlVo.className} {

<#list ftlVo.javaFields as field>
    <#if field.isPRI=false>
        <#if field.dbType == 'year'>
    @ApiModelProperty(example = "1970")
        <#elseif field.dbType == 'time'>
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "HH:mm:ss")
    @ApiModelProperty(dataType = "date", example = "12:12:12")
        <#elseif field.dbType == 'date'>
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(dataType = "date", example = "1970-01-01")
        <#elseif field.dbType == 'datetime'>
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(dataType = "date", example = "1970-01-01 12:12:12")
        <#elseif field.dbType == 'timestamp'>
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(dataType = "date", example = "1970-01-01 12:12:12")
        </#if>
    private ${field.type} ${field.name}; <#if field.comment?? && field.comment !=""> // ${field.comment} </#if>
    </#if>
</#list>


<#list ftlVo.javaFields as field>
    <#if field.isPRI=false>
    public ${field.type} get${field.name?cap_first}() {

        return ${field.name};

    }

    public void set${field.name?cap_first}(${field.type} ${field.name}) {

        this.${field.name} = ${field.name};

    }
    </#if>
</#list>

    @Override
    public String toString() {
        return "${ftlVo.className}{" +
<#list ftlVo.javaFields as field>
    <#if field.isPRI=false>
                ", ${field.name} '" + ${field.name} +<#if field.type = 'String' > '\'' +</#if>
    </#if>
</#list>
                '}';
    }

}
