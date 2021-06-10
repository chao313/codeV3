package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.FtlVueInterface;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.plugin.KeyToUrlVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class ApiJsFtl implements FtlVueInterface {

    private String dirPath;//文件所在的文件夹 -> 生成文件的时候使用
    private String fileName = "api.js";//file名称
    private String freeMarkFtlPath = "api.js.ftl";//生成FreeMark的ftlPath
    private String freeMarkStr;//生成FreeMark的str
    private String freeMarkDirPathInResources = rootPath + "vue";//freemark所在文件夹的地址

    /**
     * 自定义的属性
     */
    private List<String> apis = new ArrayList<>();
    /**
     * 举例:
     * <deleteByPrimaryKey,<deleteTUserByPrimaryKey,/demomsater/TUserController/deleteByPrimaryKey>>
     */
    private Map<String, KeyToUrlVo> keyToKeyToUrls = new HashMap<>();//key到url的映射，留作各个使用
    private Map<String, Map<String, KeyToUrlVo>> keyToKeyToUrlsAllMap = new HashMap<>();//key到url的映射，单独留作Api.js使用
    private String BASE_URL = FtlVueInterface.tomcatPath;//后台项目的地址 -> 留作拼接使用
    private String baseName;

    /**
     * 用作跳转的统一
     */

    private String EditModulePath;
    private String ViewModulePath;
    private String ListModulePath;
    private String AddModulePath;

}
