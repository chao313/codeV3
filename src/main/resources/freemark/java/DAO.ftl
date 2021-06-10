package ${ftlVo.packageName};


import java.util.List;

import ${allJavaFtl.voFtl.packageName}.${allJavaFtl.voFtl.className};
import ${allJavaFtl.voPriFtl.packageName}.${allJavaFtl.voPriFtl.className};
import ${allJavaFtl.voNoPriFtl.packageName}.${allJavaFtl.voNoPriFtl.className};
import ${allJavaFtl.multiTermVoFtl.packageName}.${allJavaFtl.multiTermVoFtl.className};

<#list ftlVo.javaFieldTypes as type><#if type = "Timestamp" >import java.sql.Timestamp;
</#if><#if type = "Time" >import java.sql.Time;
</#if><#if type = "Date" >import java.util.Date;
</#if></#list>

import org.apache.ibatis.annotations.Param;

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
public interface ${ftlVo.className} {

    /**
     * insert
     */
    int insert(${allJavaFtl.voFtl.className} vo);

    /**
     * insert vos 批量插入
     */
    int inserts(@Param(value = "vos") List<${allJavaFtl.voFtl.className}> vos);

    /**
     * 查询base
     */
    List<${allJavaFtl.voFtl.className}> queryBase(${allJavaFtl.voFtl.className} query);

    /**
     * 查询base 多维条件
     */
    List<${allJavaFtl.voFtl.className}> queryMultiTerm(${allJavaFtl.multiTermVoFtl.className} query);

    /**
     * update base (exclude value is null or "")
     */
    int updateBase(@Param(value = "source") ${allJavaFtl.voFtl.className} source, @Param(value = "target") ${allJavaFtl.voFtl.className} target);


    /**
     * update base (include value is null or "")
     */
    int updateBaseIncludeNull(@Param(value = "source") ${allJavaFtl.voFtl.className} source, @Param(value = "target") ${allJavaFtl.voFtl.className} target);

    /**
     * 删除base
     */
    int deleteBase(${allJavaFtl.voFtl.className} vo);

 <#if ftlVo.primaryKeyJavaFields?? && (ftlVo.primaryKeyJavaFields?size>0) >

    /**
     * 根据PrimaryKey查询
     * <#list ftlVo.primaryKeyJavaFields as field><p>
     * ${field.name} : ${field.comment}</#list>
     * <#list ftlVo.primaryKeyJavaFields as field>@param ${field.name}
     * </#list>
     */
    ${allJavaFtl.voFtl.className} queryByPrimaryKey(<#list ftlVo.primaryKeyJavaFields as field>@Param(value = "${field.name}") ${field.type} ${field.name}<#if field_has_next>,</#if></#list>);

    /**
     * 根据PrimaryKey删除
     * <#list ftlVo.primaryKeyJavaFields as field><p>
     * ${field.name} : ${field.comment}</#list>
     * <#list ftlVo.primaryKeyJavaFields as field>@param ${field.name}
     * </#list>
     */
    int deleteByPrimaryKey(<#list ftlVo.primaryKeyJavaFields as field>@Param(value = "${field.name}") ${field.type} ${field.name}<#if field_has_next>,</#if></#list>);

    /**
     * 根据PrimaryKey更新，会根据主键去更新其他的值(空值不覆盖有值)
     * <#list ftlVo.primaryKeyJavaFields as field><p>
     * ${field.name} : ${field.comment}</#list>
     * <#list ftlVo.primaryKeyJavaFields as field>@param ${field.name}
     * </#list>
     */
    int updateByPrimaryKey(@Param(value = "source") ${allJavaFtl.voNoPriFtl.className} source,@Param(value = "target") ${allJavaFtl.voPriFtl.className} target);

 </#if>
}
