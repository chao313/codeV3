package ${ftlVo.packageName};


import java.util.List;

import ${allJavaFtl.voFtl.packageName}.${allJavaFtl.voFtl.className};
import ${allJavaFtl.voPriFtl.packageName}.${allJavaFtl.voPriFtl.className};
import ${allJavaFtl.voNoPriFtl.packageName}.${allJavaFtl.voNoPriFtl.className};
import ${allJavaFtl.multiTermVoFtl.packageName}.${allJavaFtl.multiTermVoFtl.className};

<#list ftlVo.javaFieldTypes as fieldType><#if fieldType = "Timestamp" >import java.sql.Timestamp;
</#if><#if fieldType = "Time" >import java.sql.Time;
</#if><#if fieldType = "Date" >import java.util.Date;
</#if></#list>

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
    boolean insert(${allJavaFtl.voFtl.className} vo);


    /**
     * insert vos 批量插入
     */
    boolean insert(List<${allJavaFtl.voFtl.className}> vos);


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
    boolean updateBase(${allJavaFtl.voFtl.className} source, ${allJavaFtl.voFtl.className} target);

    /**
     * update base (include value is null or "")
     */
    boolean updateBaseIncludeNull(${allJavaFtl.voFtl.className} source, ${allJavaFtl.voFtl.className} target);

    /**
     * 删除base
     */
    boolean deleteBase(${allJavaFtl.voFtl.className} vo);

<#if ftlVo.primaryKeyJavaFields?? && (ftlVo.primaryKeyJavaFields?size>0) >

    /**
     * 根据PrimaryKey查询
     * <#list ftlVo.primaryKeyJavaFields as field><p>
     * ${field.name} : ${field.comment}</#list>
     */
     ${allJavaFtl.voFtl.className} queryByPrimaryKey(<#list ftlVo.primaryKeyJavaFields as field>${field.type} ${field.name}<#if field_has_next>,</#if></#list>);

    /**
     * 根据PrimaryKey删除
     * <#list ftlVo.primaryKeyJavaFields as field><p>
     * ${field.name} : ${field.comment}</#list>
     * <#list ftlVo.primaryKeyJavaFields as field>@param ${field.name}
     * </#list>
     */
    boolean deleteByPrimaryKey(<#list ftlVo.primaryKeyJavaFields as field>${field.type} ${field.name}<#if field_has_next>,</#if></#list>);

    /**
     * 根据PrimaryKey更新，会根据主键去更新其他的值(空值不覆盖有值) -> 主键不更新
     * <#list ftlVo.primaryKeyJavaFields as field><p>
     * ${field.name} : ${field.comment}</#list>
     * <#list ftlVo.primaryKeyJavaFields as field>@param ${field.name}
     * </#list>
     */
    boolean updateByPrimaryKey(${allJavaFtl.voNoPriFtl.className} source,${allJavaFtl.voPriFtl.className} target);


 </#if>

}
