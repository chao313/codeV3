package demo.spring.boot.demospringboot.controller.db;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import demo.spring.boot.demospringboot.config.framework.Code;
import demo.spring.boot.demospringboot.config.framework.RequestUpdate;
import demo.spring.boot.demospringboot.config.framework.Response;
import demo.spring.boot.demospringboot.mybatis.service.SchemataService;
import demo.spring.boot.demospringboot.mybatis.vo.SchemataMultiTermVo;
import demo.spring.boot.demospringboot.mybatis.vo.SchemataVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/SchemataController")
@Slf4j
public class SchemataController {

    @Autowired
    private SchemataService service;

    /**
     * 插入一条记录: 请求体是json
     *
     * @param vo
     * @return 成功和失败都返回Response，具体的结果在response的
     * code   :状态码
     * content:具体返回值
     */
    @PostMapping(value = "/insert")
    public Response insert(@RequestBody SchemataVo vo) {
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
    public Response insert(@RequestBody List<SchemataVo> vos) {
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
    public Response queryBase(@RequestBody SchemataVo query) {
        Response response = new Response();
        try {
            List<SchemataVo> result = service.queryBase(query);
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
     * @param pageNum  页码 默认值为1
     * @param pageSize 每页的size 默认值为10
     * @return 成功和失败都返回Response，具体的结果在response的
     * code   :状态码
     * content:具体返回值
     */
    @PostMapping(value = "/queryBasePageHelper")
    public Response queryBasePageHelper(@RequestBody SchemataVo query,
                                        @RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
                                        @RequestParam(value = "order", required = false) String order) {
        Response response = new Response();
        try {
            PageHelper.startPage(pageNum, pageSize);
            if (StringUtils.isNotBlank(order)) {
                PageHelper.orderBy(order);
            }
            List<SchemataVo> result = service.queryBase(query);
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
     * @param pageNum  页码 默认值为1
     * @param pageSize 每页的size 默认值为10
     * @return 成功和失败都返回Response，具体的结果在response的
     * code   :状态码
     * content:具体返回值
     */
    @PostMapping(value = "/queryMultiTermPageHelper")
    public Response queryMultiTermPageHelper(@RequestBody SchemataMultiTermVo query,
                                             @RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                             @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
                                             @RequestParam(value = "order", required = false) String order) {
        Response response = new Response();
        try {
            PageHelper.startPage(pageNum, pageSize);
            if (StringUtils.isNotBlank(order)) {
                PageHelper.orderBy(order);
            }
            List<SchemataVo> result = service.queryMultiTerm(query);
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
    public Response updateBase(@RequestBody RequestUpdate<SchemataVo, SchemataVo> update) {
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
    public Response updateBaseIncludeNull(@RequestBody RequestUpdate<SchemataVo, SchemataVo> update) {
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
    public Response deleteBase(@RequestBody SchemataVo vo) {
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

}
