package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql;

import lombok.Data;

import java.sql.Date;

/**
 * Table的信息,只包含:表名称,表类型,引擎,表的字符集,表的注释
 */
@Data
public class Table {
    String tableName;                  //TABLE_NAME      表名称
    String tableType;                  //TABLE_TYPE      表类型   [BASE TABLE\VIEW|SYSTEM VIEW]
    String engine;                     //ENGINE          引擎     [MEMORY|InnoDB|MyISAM\CSV|PERFORMANCE_SCHEMA]
    int version;                       //VERSION         版本
    String rowFormat;                  //ROW_FORMAT      行格式    [Fixed|Dynamic]
    Date createTime;                   //CREATE_TIME     创建时间
    String tableCollation;             //TABLE_COLLATION 表的字符集 [utf8_general_ci|utf8_croatian_ci]
    String tableComment;               //TABLE_COMMENT   表的注释
}
