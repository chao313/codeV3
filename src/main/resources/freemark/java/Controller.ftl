package ${ftlVo.packageName};


import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import demo.spring.boot.demospringboot.framework.Code;
import demo.spring.boot.demospringboot.framework.Response;
import demo.spring.boot.demospringboot.framework.RequestUpdate;
import org.apache.commons.lang3.StringUtils;
import ${allJavaFtl.voFtl.packageName}.${allJavaFtl.voFtl.className};
import ${allJavaFtl.serviceFtl.packageName}.${allJavaFtl.serviceFtl.className};
import ${allJavaFtl.voNoPriFtl.packageName}.${allJavaFtl.voNoPriFtl.className};
import ${allJavaFtl.voPriFtl.packageName}.${allJavaFtl.voPriFtl.className};
import ${allJavaFtl.multiTermVoFtl.packageName}.${allJavaFtl.multiTermVoFtl.className};
<#list ftlVo.javaFieldTypes as type><#if type = "Timestamp" >import java.sql.Timestamp;
</#if><#if type = "Time" >import java.sql.Time;
</#if><#if type = "Date" >import java.util.Date;
</#if></#list>
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/${ftlVo.className}")
@Slf4j
public class ${ftlVo.className} {

    @Autowired
    private ${allJavaFtl.serviceFtl.className} service;

    /**
     * 插入一条记录: 请求体是json
     *
     * @param vo
     * @return 成功和失败都返回Response，具体的结果在response的
     * code   :状态码
     * content:具体返回值
     */
    @PostMapping(value = "/insert")
    public Response insert(@RequestBody ${allJavaFtl.voFtl.className} vo) {
       Response response = new Response();
        try {
            Boolean result = service.insert(vo);
            response.setCode(Code.System.OK);
            response.setContent(result);
            log.info("success result -> {} ", result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            log.error("异常 -> {} ", e.getMessage(), e);
        }
        return response;
    }

    /**
     * 插入多条记录: 请求体是json
     *
     * @param vos
     * @return 成功和失败都返回Response，具体的结果在response的
     * code   :状态码
     * content:具体返回值
     */
    @PostMapping(value = "/inserts")
    public Response insert(@RequestBody List<${allJavaFtl.voFtl.className}> vos) {
        Response response = new Response();
        try {
            Boolean result = service.insert(vos);
            response.setCode(Code.System.OK);
            response.setContent(result);
            log.info("success result -> {} ", result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            log.error("异常 -> {} ", e.getMessage(), e);
        }
        return response;
    }


    /**
     * 多条件查询语句,每个字段只要不为null就是查询条件
     *
     * @param query
     * @return 成功和失败都返回Response，具体的结果在response的
     * code   :状态码
     * content:具体返回值
     */
    @PostMapping(value = "/queryBase")
    public Response queryBase(@RequestBody ${allJavaFtl.voFtl.className} query) {
        Response response = new Response();
        try {
            List<${allJavaFtl.voFtl.className}> result = service.queryBase(query);
            response.setCode(Code.System.OK);
            response.setContent(result);
            log.info("success result -> {} ", result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            log.error("异常 -> {} ", e.getMessage(), e);
        }
        return response;
    }

    /**
      * 多条件查询语句,每个字段只要不为null就是查询条件
      * 这里添加了分页插件，能够返回的数据包含页码，下一页... , 自动查询count
      *
      * @param query
      * @param pageNum 页码 默认值为1
      * @param pageSize 每页的size 默认值为10
      * @return 成功和失败都返回Response，具体的结果在response的
      * code   :状态码
      * content:具体返回值
      */
    @PostMapping(value = "/queryBasePageHelper")
    public Response queryBasePageHelper(@RequestBody ${allJavaFtl.voFtl.className} query,
                                        @RequestParam(value = "pageNum",defaultValue = "1",required = false) Integer pageNum,
                                        @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize,
                                        @RequestParam(value = "order", required = false) String order) {
         Response response = new Response();
         try {
             PageHelper.startPage(pageNum, pageSize);
             if (StringUtils.isNotBlank(order)) {
                 PageHelper.orderBy(order);
             }
             List<${allJavaFtl.voFtl.className}> result = service.queryBase(query);
             PageInfo pageInfo = new PageInfo(result);
             response.setCode(Code.System.OK);
             response.setContent(pageInfo);
             log.info("success pageInfo -> {} ", pageInfo);
         } catch (Exception e) {
             response.setCode(Code.System.FAIL);
             response.setMsg(e.getMessage());
             response.addException(e);
             log.error("异常 -> {} ", e.getMessage(), e);
         }
         return response;
     }

    /**
      * 多条件查询语句,每个字段只要不为null就是查询条件(这里是多维条件,包含like,not like)
      * 这里添加了分页插件，能够返回的数据包含页码，下一页... , 自动查询count
      *
      * @param query
      * @param pageNum 页码 默认值为1
      * @param pageSize 每页的size 默认值为10
      * @return 成功和失败都返回Response，具体的结果在response的
      * code   :状态码
      * content:具体返回值
      */
    @PostMapping(value = "/queryMultiTermPageHelper")
    public Response queryMultiTermPageHelper(@RequestBody ${allJavaFtl.multiTermVoFtl.className} query,
                                             @RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                             @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
                                             @RequestParam(value = "order", required = false) String order) {
         Response response = new Response();
         try {
             PageHelper.startPage(pageNum, pageSize);
             if (StringUtils.isNotBlank(order)) {
                 PageHelper.orderBy(order);
             }
             List<${allJavaFtl.voFtl.className}> result = service.queryMultiTerm(query);
             PageInfo pageInfo = new PageInfo(result);
             response.setCode(Code.System.OK);
             response.setContent(pageInfo);
             log.info("success pageInfo -> {} ", pageInfo);
         } catch (Exception e) {
             response.setCode(Code.System.FAIL);
             response.setMsg(e.getMessage());
             response.addException(e);
             log.error("异常 -> {} ", e.getMessage(), e);
         }
         return response;
    }


    /**
     * 多条件更新语句,
     * source每个字段只要不为null就是更新数据 -> 慎用
     * target每个字段只要不为null就是查询条件 -> 慎用
     *
     * @param source
     * @param target
     * @return 成功和失败都返回Response，具体的结果在response的
     * code   :状态码
     * content:具体返回值
     */
    @PostMapping(value = "/updateBase")
    public Response updateBase(@RequestBody RequestUpdate<${allJavaFtl.voFtl.className},${allJavaFtl.voFtl.className}> update) {
        Response response = new Response();
        try {
            Boolean result = service.updateBase(update.getSource(), update.getTarget());
            response.setCode(Code.System.OK);
            response.setContent(result);
            log.info("success result -> {} ", result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            log.error("异常 -> {} ", e.getMessage(), e);
        }
        return response;
    }

    /**
     * 多条件更新语句,(包含null)
     * source每个字段都是更新数据 -> 慎用
     * target每个字段只要不为null就是查询条件 -> 慎用
     *
     * @param source
     * @param target
     * @return 成功和失败都返回Response，具体的结果在response的
     * code   :状态码
     * content:具体返回值
     */
    @PostMapping(value = "/updateBaseIncludeNull")
    public Response updateBaseIncludeNull(@RequestBody RequestUpdate<${allJavaFtl.voFtl.className},${allJavaFtl.voFtl.className}> update) {
        Response response = new Response();
        try {
            Boolean result = service.updateBaseIncludeNull(update.getSource(), update.getTarget());
            response.setCode(Code.System.OK);
            response.setContent(result);
            log.info("success result -> {} ", result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            log.error("异常 -> {} ", e.getMessage(), e);
        }
        return response;
    }

    /**
     * 多条件查询语句,
     * 每个字段只要不为null就是查询条件
     *
     * @param vo
     * @return 成功和失败都返回Response，具体的结果在response的
     * code   :状态码
     * content:具体返回值
     */
    @PostMapping(value = "/deleteBase")
    public Response deleteBase(@RequestBody ${allJavaFtl.voFtl.className} vo) {
        Response response = new Response();
        try {
            Boolean result = service.deleteBase(vo);
            response.setCode(Code.System.OK);
            response.setContent(result);
            log.info("success result -> {} ", result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            log.error("异常 -> {} ", e.getMessage(), e);
        }
        return response;
    }

<#if ftlVo.primaryKeyJavaFields?? && (ftlVo.primaryKeyJavaFields?size>0) >


    /**
     * 主键查询语句,
     * 因为是主键 -> 查询返回的是一条记录
     *
     * <#list ftlVo.primaryKeyJavaFields as field>@param ${field.name}
     * </#list>
     * @return 成功和失败都返回Response，具体的结果在response的
     * code   :状态码
     * content:具体返回值
     */
    @GetMapping(value = "/queryByPrimaryKey")
    public Response queryByPrimaryKey(<#list ftlVo.primaryKeyJavaFields as field>
    <#if field.dbType == 'year'>
            @ApiParam(value = "${field.name}", defaultValue = "1970")
    <#elseif field.dbType == 'time'>
            @ApiParam(value = "${field.name}", defaultValue = "12:12:12")
    <#elseif field.dbType == 'date'>
            @ApiParam(value = "${field.name}", defaultValue = "1970-01-01")
    <#elseif field.dbType == 'datetime'>
            @ApiParam(value = "${field.name}", defaultValue = "1970-01-01 12:12:12")
    <#elseif field.dbType == 'timestamp'>
            @ApiParam(value = "${field.name}", defaultValue = "1970-01-01 12:12:12")
    </#if>
            @RequestParam ${field.type} ${field.name}<#if field_has_next>, </#if></#list>
    ) {
        Response response = new Response();
        try {
            ${allJavaFtl.voFtl.className} result = service.queryByPrimaryKey(<#list ftlVo.primaryKeyJavaFields as field>${field.name}<#if field_has_next>, </#if></#list>);
            response.setCode(Code.System.OK);
            response.setContent(result);
            log.info("success result -> {} ", result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            log.error("异常 -> {} ", e.getMessage(), e);
        }
        return response;
    }


    /**
     * 主键删除语句,
     * 因为是主键 -> 删除的是一条记录
     *
     * <#list ftlVo.primaryKeyJavaFields as field>@param ${field.name}
     * </#list>
     * @return 成功和失败都返回Response，具体的结果在response的
     * code   :状态码
     * content:具体返回值
     */
    @GetMapping(value = "/deleteByPrimaryKey")
    public Response deleteByPrimaryKey(<#list ftlVo.primaryKeyJavaFields as field>
    <#if field.dbType == 'year'>
            @ApiParam(value = "${field.name}", defaultValue = "1970")
    <#elseif field.dbType == 'time'>
            @ApiParam(value = "${field.name}", defaultValue = "12:12:12")
    <#elseif field.dbType == 'date'>
            @ApiParam(value = "${field.name}", defaultValue = "1970-01-01")
    <#elseif field.dbType == 'datetime'>
            @ApiParam(value = "${field.name}", defaultValue = "1970-01-01 12:12:12")
    <#elseif field.dbType == 'timestamp'>
            @ApiParam(value = "${field.name}", defaultValue = "1970-01-01 12:12:12")
    </#if>
           @RequestParam ${field.type} ${field.name}<#if field_has_next>, </#if></#list>
     ) {
        Response response = new Response();
        try {
            Boolean result = service.deleteByPrimaryKey(<#list ftlVo.primaryKeyJavaFields as field>${field.name}<#if field_has_next>, </#if></#list>);
            response.setCode(Code.System.OK);
            response.setContent(result);
            log.info("success result -> {} ", result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            log.error("异常 -> {} ", e.getMessage(), e);
        }
        return response;
    }

    /**
     * 根据PrimaryKey更新，会根据主键去更新其他的值(空值不覆盖有值)
     *
     * @param update.source 只包含非主键的字段
     * @param update.target 只包含主键的字段
     * <#list ftlVo.primaryKeyJavaFields as field>@param ${field.name}
     * </#list>
     * @return 成功和失败都返回Response，具体的结果在response的
     * code   :状态码
     * content:具体返回值
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Response updateByPrimaryKey(@RequestBody RequestUpdate<${allJavaFtl.voNoPriFtl.className},${allJavaFtl.voPriFtl.className}> update) {
        Response response = new Response();
        try {
            Boolean result = service.updateByPrimaryKey(update.getSource(), update.getTarget());
            response.setCode(Code.System.OK);
            response.setContent(result);
            log.info("success result -> {} ", result);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            log.error("异常 -> {} ", e.getMessage(), e);
        }
        return response;
    }
</#if>
}
