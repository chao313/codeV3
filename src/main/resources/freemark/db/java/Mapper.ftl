<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${allJavaFtl.daoFtl.packageName}.${allJavaFtl.daoFtl.className}">

    <resultMap id="resultMap" type="${allJavaFtl.voFtl.packageName}.${allJavaFtl.voFtl.className}">
      <#list ftlVo.mysqlAndJavaFields as mysqlAndJavaField>
        <result column="${mysqlAndJavaField.mysqlField.name}" property="${mysqlAndJavaField.javaField.name}"/>
      </#list>
    </resultMap>

    <insert id="insert"
            parameterType="${allJavaFtl.voFtl.packageName}.${allJavaFtl.voFtl.className}">
        INSERT INTO `${ftlVo.table.tableName}`(
      <#list ftlVo.mysqlFields as field>
        `${field.name}` <#if field_has_next>,</#if>
      </#list>
        )VALUE(
      <#list ftlVo.javaFields as field>
          <#noparse>#{</#noparse>${field.name}<#noparse>}</#noparse>  <#if field_has_next>,</#if>
      </#list>
        )
    </insert>

    <insert id="inserts"
            parameterType="java.util.List">
        INSERT INTO `${ftlVo.table.tableName}`(
        <#list ftlVo.mysqlFields as field>
        `${field.name}`<#if field_has_next>,</#if>
        </#list>
        )VALUES
        <foreach collection="vos" item="item" separator=",">
            (
         <#list ftlVo.javaFields as field>
            <#noparse>#{item.</#noparse>${field.name}<#noparse>}</#noparse><#if field_has_next>,</#if>
         </#list>
            )
        </foreach>
    </insert>

    <select id="queryBase" resultMap="resultMap"
            resultType="${allJavaFtl.voFtl.packageName}.${allJavaFtl.voFtl.className}"
            parameterType="${allJavaFtl.voFtl.packageName}.${allJavaFtl.voFtl.className}">
        SELECT
      <#list ftlVo.mysqlFields as field>
        `${field.name}`<#if field_has_next>,</#if>
      </#list>
        FROM `${ftlVo.table.tableName}`
        <where>
            1 = 1
        <#list ftlVo.mysqlAndJavaFields as mysqlAndJavaField>
            <if test="${mysqlAndJavaField.javaField.name} != null">
                AND `${mysqlAndJavaField.mysqlField.name}` = <#noparse>#{</#noparse>${mysqlAndJavaField.javaField.name}<#noparse>}</#noparse>
            </if>
        </#list>
        </where>
    </select>

     <select id="queryMultiTerm" resultMap="resultMap"
             resultType="${allJavaFtl.voFtl.packageName}.${allJavaFtl.voFtl.className}"
             parameterType="${allJavaFtl.multiTermVoFtl.packageName}.${allJavaFtl.multiTermVoFtl.className}">
        SELECT
      <#list ftlVo.mysqlFields as field>
        `${field.name}`<#if field_has_next>,</#if>
      </#list>
        FROM `${ftlVo.table.tableName}`
        <where>
            1 = 1
        <#list ftlVo.mysqlAndJavaFields as mysqlAndJavaField>
            <if test="${mysqlAndJavaField.javaField.name} != null">
                 <if test="${mysqlAndJavaField.javaField.name}._in != null">
                     AND `${mysqlAndJavaField.mysqlField.name}` in
                     <foreach collection="${mysqlAndJavaField.mysqlField.name}._in" item="item" separator="," open="(" close=")">
                         <#noparse>#{item}</#noparse>
                     </foreach>
                 </if>
                 <if test="${mysqlAndJavaField.javaField.name}._notIn != null">
                     AND `${mysqlAndJavaField.mysqlField.name}`  not in
                     <foreach collection="${mysqlAndJavaField.mysqlField.name}._notIn" item="item" separator="," open="(" close=")">
                         <#noparse>#{item}</#noparse>
                     </foreach>
                 </if>
                 <if test="${mysqlAndJavaField.javaField.name}._like != null">
                     <foreach collection="${mysqlAndJavaField.mysqlField.name}._like" item="item">
                       AND `${mysqlAndJavaField.mysqlField.name}` like <#noparse>#{item}</#noparse>
                     </foreach>
                 </if>
                 <if test="${mysqlAndJavaField.javaField.name}._notLike != null">
                     <foreach collection="${mysqlAndJavaField.mysqlField.name}._notLike" item="item">
                       AND `${mysqlAndJavaField.mysqlField.name}` not like <#noparse>#{item}</#noparse>
                     </foreach>
                 </if>
                 <if test="${mysqlAndJavaField.javaField.name}._regex != null">
                     <foreach collection="${mysqlAndJavaField.mysqlField.name}._regex" item="item">
                       AND `${mysqlAndJavaField.mysqlField.name}` REGEXP <#noparse>#{item}</#noparse>
                     </foreach>
                 </if>
                 <if test="${mysqlAndJavaField.javaField.name}._regex != null">
                     <foreach collection="${mysqlAndJavaField.mysqlField.name}._regex" item="item">
                       AND `${mysqlAndJavaField.mysqlField.name}` not REGEXP <#noparse>#{item}</#noparse>
                     </foreach>
                 </if>
                 <if test="${mysqlAndJavaField.javaField.name}._lt != null">
                      AND `${mysqlAndJavaField.mysqlField.name}` <![CDATA[ < ]]>  <#noparse>#</#noparse>{${mysqlAndJavaField.mysqlField.name}._lt}
                 </if>
                  <if test="${mysqlAndJavaField.javaField.name}._le != null">
                      AND `${mysqlAndJavaField.mysqlField.name}` <![CDATA[ <= ]]>  <#noparse>#</#noparse>{{${mysqlAndJavaField.mysqlField.name}._lt}
                 </if>
                  <if test="${mysqlAndJavaField.javaField.name}._gt != null">
                      AND `${mysqlAndJavaField.mysqlField.name}` <![CDATA[ > ]]>  <#noparse>#</#noparse>{{${mysqlAndJavaField.mysqlField.name}._lt}
                 </if>
                  <if test="${mysqlAndJavaField.javaField.name}._ge != null">
                      AND `${mysqlAndJavaField.mysqlField.name}` <![CDATA[ >= ]]>  <#noparse>#</#noparse>{{${mysqlAndJavaField.mysqlField.name}._lt}
                 </if>
            </if>
        </#list>
        </where>
        </select>

    <update id="updateBase"
            parameterType="${allJavaFtl.voFtl.packageName}.${allJavaFtl.voFtl.className}">
        UPDATE `${ftlVo.table.tableName}`
        <set>
        <#list ftlVo.mysqlAndJavaFields as mysqlAndJavaField>
            <if test="source.${mysqlAndJavaField.javaField.name} != null">
                `${mysqlAndJavaField.mysqlField.name}` = <#noparse>#{source.</#noparse>${mysqlAndJavaField.javaField.name}<#noparse>}</#noparse><#if mysqlAndJavaField_has_next>,</#if>
            </if>
        </#list>
        </set>
        <where>
            1 =1
        <#list ftlVo.mysqlAndJavaFields as mysqlAndJavaField>
            <if test="target.${mysqlAndJavaField.javaField.name} != null">
                AND `${mysqlAndJavaField.mysqlField.name}` = <#noparse>#{target.</#noparse>${mysqlAndJavaField.javaField.name}<#noparse>}</#noparse>
            </if>
        </#list>
        </where>
    </update>

    <update id="updateBaseIncludeNull"
            parameterType="${allJavaFtl.voFtl.packageName}.${allJavaFtl.voFtl.className}">
        UPDATE `${ftlVo.table.tableName}`
        <set>
         <#list ftlVo.mysqlAndJavaFields as mysqlAndJavaField>
            `${mysqlAndJavaField.mysqlField.name}` = <#noparse>#{source.</#noparse>${mysqlAndJavaField.javaField.name}<#noparse>}</#noparse><#if mysqlAndJavaField_has_next>,</#if>
         </#list>
        </set>
        <where>
            1 =1
         <#list ftlVo.mysqlAndJavaFields as mysqlAndJavaField>
            <if test="target.${mysqlAndJavaField.javaField.name} != null">
                AND `${mysqlAndJavaField.mysqlField.name}` = <#noparse>#{target.</#noparse>${mysqlAndJavaField.javaField.name}<#noparse>}</#noparse>
            </if>
         </#list>
        </where>
    </update>

    <delete id="deleteBase"
            parameterType="${allJavaFtl.voFtl.packageName}.${allJavaFtl.voFtl.className}">
        DELETE FROM `${ftlVo.table.tableName}`
        <where>
            1 =1
        <#list ftlVo.mysqlAndJavaFields as mysqlAndJavaField>
            <if test="${mysqlAndJavaField.javaField.name} != null">
                AND `${mysqlAndJavaField.mysqlField.name}` = <#noparse>#{</#noparse>${mysqlAndJavaField.javaField.name}<#noparse>}</#noparse>
            </if>
        </#list>
        </where>
    </delete>

<#if ftlVo.primaryKeyJavaFields?? && (ftlVo.primaryKeyJavaFields?size>0) >

    <select id="queryByPrimaryKey" resultMap="resultMap"
            resultType="${allJavaFtl.voFtl.packageName}.${allJavaFtl.voFtl.className}">
        SELECT
         <#list ftlVo.mysqlFields as field>
        `${field.name}`<#if field_has_next>,</#if>
         </#list>
        FROM `${ftlVo.table.tableName}`
        <where>
            1 =1
         <#list ftlVo.primaryKeyMysqlAndJavaFields as mysqlAndJavaField>
            AND `${mysqlAndJavaField.mysqlField.name}` = <#noparse>#{</#noparse>${mysqlAndJavaField.javaField.name}<#noparse>}</#noparse>
         </#list>
        </where>
    </select>

    <delete id="deleteByPrimaryKey">
        DELETE FROM `${ftlVo.table.tableName}`
        <where>
            1 = 1
            <#list ftlVo.primaryKeyMysqlAndJavaFields as mysqlAndJavaField>
               AND `${mysqlAndJavaField.mysqlField.name}` = <#noparse>#{</#noparse>${mysqlAndJavaField.javaField.name}<#noparse>}</#noparse>
            </#list>
        </where>
    </delete>

    <update id="updateByPrimaryKey"
            parameterType="${allJavaFtl.voFtl.packageName}.${allJavaFtl.voFtl.className}">
        UPDATE `${ftlVo.table.tableName}`
        <set>
            <#list ftlVo.mysqlAndJavaFields as mysqlAndJavaField>
                <#if mysqlAndJavaField.mysqlField.isPRI=false>
               <if test="source.${mysqlAndJavaField.javaField.name} != null">
                   `${mysqlAndJavaField.mysqlField.name}` = <#noparse>#{source.</#noparse>${mysqlAndJavaField.javaField.name}<#noparse>}</#noparse><#if mysqlAndJavaField_has_next>,</#if>
               </if>
                </#if>
            </#list>
        </set>
        <where>
            1 =1
            <#list ftlVo.primaryKeyMysqlAndJavaFields as mysqlAndJavaField>
               AND `${mysqlAndJavaField.mysqlField.name}` = <#noparse>#{target.</#noparse>${mysqlAndJavaField.javaField.name}<#noparse>}</#noparse>
            </#list>
        </where>
    </update>
</#if>

</mapper>