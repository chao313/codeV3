package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class JavaField {
    private String name;
    private String dbType;//数据库中的类型
    private String type;//java的字段类型
    private String comment;
    private Boolean isNotNull;
    private Boolean isPRI;
}
