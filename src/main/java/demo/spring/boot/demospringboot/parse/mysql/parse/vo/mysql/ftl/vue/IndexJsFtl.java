package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.FtlVueInterface;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.plugin.Module;
import lombok.Data;

import java.util.List;

@Data
public class IndexJsFtl implements FtlVueInterface {
    private String dirPath;//file名称
    private String fileName;//file名称
    private String freeMarkFtlPath = "Index.js.ftl";//生成FreeMark的ftlPath
    private String freeMarkStr;//生成FreeMark的str
    private String freeMarkDirPathInResources = rootPath + "vue";//freemark所在文件夹的地址

    /**
     * 自定义的属性
     */

    private List<Module> modules;


}