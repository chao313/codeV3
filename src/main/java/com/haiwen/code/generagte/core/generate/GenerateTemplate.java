package com.haiwen.code.generagte.core.generate;

import demo.spring.boot.demospringboot.util.FreeMarkUtil;
import freemarker.template.TemplateException;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chao
 * @version 1.0
 * @description: 代码生成的核心
 * @date 2021/6/16 下午11:33
 * 生成:
 * 1.需要生成的目标文件名称
 * 2.需要生成的目标文件全路径
 * 3.需要模板
 * 4.需要渲染的数据
 */
public abstract class GenerateTemplate<D extends DataTemplate, R extends ResultTemplate> {

    /**
     * 目标文件的名称
     */
    public abstract String getFreeMarkFilePath();

    /**
     * 目标文件的路径
     */
    public abstract String getFreeMarkDirPath();


    /**
     * 获取数据
     */
    public abstract D getData();


    /**
     * 构造结果
     */
    public abstract R getResult();


    /**
     * 核心生成方法
     *
     * @return
     */
    public R generate() throws IOException, TemplateException {
        R result = this.getResult();
        D data = this.getData();//获取数据
        Map<String, Object> map = new HashMap<>();
        map.put("data", data);
        File templateDirFile = ResourceUtils.getFile(this.getFreeMarkDirPath());//文件夹从实现者中提取
        StringBuffer freeMarkStr = FreeMarkUtil.generateXmlByTemplate(map, templateDirFile, this.getFreeMarkFilePath());
        result.setResultFreeMark(freeMarkStr.toString());
        return result;
    }


}
