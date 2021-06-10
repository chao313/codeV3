package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql;

import demo.spring.boot.demospringboot.util.FreeMarkUtil;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java.AllJavaFtl;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.FtlJavaInterface;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 模板方法 -> 定义流程，继承者只需要实现接口
 * 限定了接口 FtlJavaInterface
 */
@Slf4j
public abstract class GenerateJavaUtil<FtlVo extends FtlJavaInterface> {


    /**
     * 实现着需要从这个接口去获取 FtlVo
     *
     * @return
     */
    public abstract FtlVo getFtlVo();

    /**
     * 实现着需要从这个接口去获取 全部的ftl -> 用作相互依赖
     *
     * @return
     */
    public abstract AllJavaFtl getAllJavaFtl();


    /**
     * 1.注入需要的Vo
     * 2.根据freeMark生成ftl
     * 3.返回的就生成好的freeMark的ftl
     *
     * @return
     */
    public FtlVo grenerate() throws IOException, TemplateException {
        FtlVo ftlVo = this.getFtlVo();//获取数据vo
        Map<String, Object> map = new HashMap<>();
        map.put("ftlVo", ftlVo);
        map.put("allJavaFtl", this.getAllJavaFtl());//存放所有的ftlVo ， 方便后面使用
        File templateDirFile = ResourceUtils.getFile(ftlVo.getFreeMarkDirPathInResources());//文件夹从实现者中提取
        StringBuffer freeMarkStr = FreeMarkUtil.generateXmlByTemplate(map, templateDirFile, ftlVo.getFreeMarkFtlPath());
        ftlVo.setFreeMarkStr(freeMarkStr.toString());
        return ftlVo;
    }

}









