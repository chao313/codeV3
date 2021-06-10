package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue;


import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java.AllJavaFtl;
import lombok.Data;

import java.util.List;

@Data
public class AllVueFtl {
    private List<AllJavaFtl> allJavaFtls;//存放所有的java的ftl属性 注意是S 包含多条 vo -> controller
    private AllJavaFtl allJavaFtl;//存放单独java的ftl属性 注意是S 包含多条 vo -> controller
    private ApiJsFtl apiJsFtl;
    private ViewVueFtl viewVueFtl;
    private EditVueFtl editVueFtl;
    private ListVueFtl listVueFtl;
    private IndexJsFtl indexJsFtl;
    private AddVueFtl addVueFtl;
}
