package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.plugin;

import lombok.Data;

@Data
public class KeyToUrlVo {
    private String vueKey;//vue api.self使用的key updateTPicByPrimaryKey
    private String url; //TPicController/updateByPrimaryKey
    private String comment;//根据主键更新TPic
}