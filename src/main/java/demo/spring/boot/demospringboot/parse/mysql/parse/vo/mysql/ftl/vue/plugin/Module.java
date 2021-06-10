package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.plugin;

import lombok.Data;

/**
 * index中和Moudle相关的
 */
@Data
public class Module {
    private String baseModule;
    private String path;//"locationZipManaeEdit";
    private String realPath;//@/views/zipManager/list
    private String component;//"LocationZipManagerEdit";
    private String name;//locationZipManagerEdit";
    private String metaTitle;//locationZipManagerEdit配置编辑";
    private String hidden = "true";
}
