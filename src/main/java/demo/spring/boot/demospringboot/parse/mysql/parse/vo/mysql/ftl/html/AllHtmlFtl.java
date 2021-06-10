package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.html;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.AllVueFtl;
import lombok.Data;

import java.util.List;

@Data
public class AllHtmlFtl {
    List<AllVueFtl> allVueFtls;//存放所有的前端的之前生成的结果
    private DataJsFtl dataJsFtl;//前端使用的dataJS
}
