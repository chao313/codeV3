package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.FtlVueInterface;
import lombok.Data;

@Data
public class ListVueFtl implements FtlVueInterface {
    private String dirPath;//文件所在的文件夹 -> 生成文件的时候使用
    private String fileName;//file名称
    private String freeMarkFtlPath = "List.vue.ftl";//生成FreeMark的ftlPath
    private String freeMarkStr;//生成FreeMark的str
    private String freeMarkDirPathInResources = rootPath + "vue";//freemark所在文件夹的地址

    private String modulePath;//模块的名称 -> 页面跳转的时候需要用到
}
