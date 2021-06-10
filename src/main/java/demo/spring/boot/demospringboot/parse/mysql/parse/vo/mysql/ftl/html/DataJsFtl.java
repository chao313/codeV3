package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.html;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.JavaField;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.FtlHtmlInterface;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.FtlVueInterface;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.plugin.KeyToUrlVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 专门用于前端的生成
 */
@Data
public class DataJsFtl implements FtlHtmlInterface {

    private String dirPath;//文件所在的文件夹 -> 生成文件的时候使用
    private String fileName = "data.js";//file名称
    private String freeMarkFtlPath = "Data.js.ftl";//生成FreeMark的ftlPath
    private String freeMarkStr;//生成FreeMark的str
    private String freeMarkDirPathInResources = rootPath + "html";//freemark所在文件夹的地址

    /**
     * 自定义的属性
     */
    private List<String> apis = new ArrayList<>();
    /**
     * 举例:
     * <deleteByPrimaryKey,<deleteTUserByPrimaryKey,/demomsater/TUserController/deleteByPrimaryKey>>
     */
    private Map<String, KeyToUrlVo> keyToKeyToUrls = new HashMap<>();//key到url的映射，留作各个使用
    /**
     * Map<Tpic,<CURD,URL>>
     */
    private Map<String, Map<String, KeyToUrlVo>> keyToKeyToUrlsAllMap = new HashMap<>();//
    private Map<String, List<JavaField>> keyToVoJavaFields = new HashMap<>();//key到vo字段的映射 ，和 keyToKeyToUrlsAllMap 的key对应
    private Map<String, List<JavaField>> keyToVoPrimaryKeyJavaFields;//所有主键主键的字段
    private String BASE_URL = FtlVueInterface.tomcatPath;//后台项目的地址 -> 留作拼接使用
    private String baseName;


}
