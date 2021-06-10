package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl;

/**
 * 接口,由Ftl继承
 * 注意:
 * 接口目录就是强制实现者实现某种方法
 * -> 这种方法一定是多个实现者都要使用的 !!!
 */
public interface FtlVueInterface {

    String tomcatPath = "demomaster";

    String rootPath = "classpath:freemark/";

    /**
     * 文件所在的文件夹 -> 生成文件的时候使用
     *
     * @return
     */
    String getDirPath();


    /**
     * 文件名称 -> 生成文件的时候需要
     *
     * @return
     */
    String getFileName();

    /**
     * ftl的路径 -> 生成freemark的时候使用
     *
     * @return
     */
    String getFreeMarkFtlPath();

    /**
     * ftl的具体内容 -> 生成文件的时候使用
     *
     * @return
     */
    String getFreeMarkStr();

    void setFreeMarkStr(String freeMarkStr);


    /**
     * @return 返回ftl的文件夹所在位置
     */
    String getFreeMarkDirPathInResources();

}
