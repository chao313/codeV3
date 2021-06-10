package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl;

/**
 * 接口,由Ftl继承
 */
public interface FtlJavaInterface {

    String rootPath = "classpath:freemark/";

    String getPackageName();

    String getFileName();


    String getFreeMarkFtlPath();


    String getFreeMarkStr();

    void setFreeMarkStr(String freeMarkStr);

    /**
     * @return 返回ftl的文件夹所在位置
     */
    String getFreeMarkDirPathInResources();

}
