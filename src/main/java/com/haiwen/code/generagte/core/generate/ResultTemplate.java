package com.haiwen.code.generagte.core.generate;

import lombok.Data;

/**
 * @author chao
 * @version 1.0
 * @description: TODO
 * @date 2021/6/17 上午12:01
 * 结果生成应该是固定的元素(这里不用做拓展,那是不是可以直接放到模板里面)
 */
@Data
public abstract class ResultTemplate {
    /**
     * freeMark的渲染结果
     */
    private String resultFreeMark;

    /**
     * 目标文件的名称
     */
    public abstract String getTargetFileName();

    /**
     * 目标文件的路径
     */
    public abstract String getTargetFilePath();
}
