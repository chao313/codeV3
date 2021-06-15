package ${ftlVo.packageName};

<#list ftlVo.javaFieldTypes as type><#if type = "Timestamp" >import java.sql.Timestamp;
</#if><#if type = "Time" >import java.sql.Time;
</#if><#if type = "Date" >import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import demo.spring.boot.demospringboot.framework.MultiTerm;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
</#if></#list>
import demo.spring.boot.demospringboot.framework.MultiTerm;

/**
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
    <#if field.dbType == 'datetime' || field.dbType == 'timestamp' >
    private MultiTerm<String> ${field.name}; <#if field.comment?? && field.comment !=""> // ${field.comment}></#if>
    <#else>
    private MultiTerm<${field.type}> ${field.name}; <#if field.comment?? && field.comment !=""> // ${field.comment}</#if>
    </#if>
</#list>


<#list ftlVo.javaFields as field>
 <#if field.dbType == 'datetime' || field.dbType == 'timestamp' >
    public MultiTerm<String> get${field.name?cap_first}() {

        return ${field.name};

    }

    public void set${field.name?cap_first}(MultiTerm<String> ${field.name}) {

        this.${field.name} = ${field.name};

    }
 <#else>
    public MultiTerm<${field.type}> get${field.name?cap_first}() {

        return ${field.name};

    }

    public void set${field.name?cap_first}(MultiTerm<${field.type}> ${field.name}) {

        this.${field.name} = ${field.name};

    }
 </#if>
</#list>

    @Override
    public String toString() {
        return "${ftlVo.className}{" +
<#list ftlVo.javaFields as field>
                ", ${field.name} '" + ${field.name} +<#if field.type = 'String' > '\'' +</#if>
</#list>
                '}';
    }

}
