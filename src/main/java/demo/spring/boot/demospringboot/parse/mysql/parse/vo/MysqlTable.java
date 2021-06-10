package demo.spring.boot.demospringboot.parse.mysql.parse.vo;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.MysqlField;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * information_schema.TABLES 详解
 * Table_catalog	数据表登记目录
 * Table_schema	    数据表所属的数据库名
 * Table_name	    表名称
 * Table_type    	表类型[system view|base table]
 * Engine	        使用的数据库引擎[MyISAM|CSV|InnoDB]
 * Version	        版本，默认值10
 * Row_format	    行格式[Compact|Dynamic|Fixed] 如果不存在varchar、text以及其变形、blob以及其变形 -> 就是Dynamic | 存在varchar、text以及其变形、blob以及其变形 就是Fixed
 * Table_rows	    表里所存多少行数据
 * Avg_row_length	平均行长度
 * Data_length	    数据长度
 * Max_data_length	最大数据长度
 * Index_length	    索引长度
 * Data_free	    空间碎片
 * Auto_increment	做自增主键的自动增量当前值
 * Create_time	    表的创建时间
 * Update_time	    表的更新时间
 * Check_time	    表的检查时间
 * Table_collation	表的字符校验编码集
 * Checksum	        校验和
 * Create_options	创建选项
 * Table_comment	表的注释、备注
 */

@Data
@Slf4j
@ToString
public class MysqlTable {
    String tableName;                  //TABLE_NAME      表名称
    String tableType;                  //TABLE_TYPE      表类型   [BASE TABLE\VIEW|SYSTEM VIEW]
    String engine;                     //ENGINE          引擎     [MEMORY|InnoDB|MyISAM\CSV|PERFORMANCE_SCHEMA]
    int version;                       //VERSION         版本
    String rowFormat;                  //ROW_FORMAT      行格式    [Fixed|Dynamic]
    Date createTime;                   //CREATE_TIME     创建时间
    String tableCollation;             //TABLE_COLLATION 表的字符集 [utf8_general_ci|utf8_croatian_ci]
    String tableComment;               //TABLE_COMMENT   表的注释
    private List<MysqlField> mysqlFields;
    private List<MysqlField> primaryKeys;//sql key

    /**
     * 获得处理好的
     * 把字段中属于主键的部分筛选出来
     *
     * @param mysqlTable
     * @return
     */
    public static MysqlTable transByMysqlTable(MysqlTable mysqlTable) {
        List<MysqlField> primaryKeys = new ArrayList<>();
        mysqlTable.getMysqlFields().forEach(mysqlField -> {
            if (mysqlField.getIsPRI()) {
                primaryKeys.add(mysqlField);
            }
        });
        mysqlTable.setPrimaryKeys(primaryKeys);
        return mysqlTable;
    }

    /**
     * 把主键字段中从全部字段中筛选出来
     *
     * @param mysqlFields 全部的字段
     * @return 筛选出来的字段
     */
    public static List<MysqlField> getPRIFromFields(List<MysqlField> mysqlFields) {
        List<MysqlField> primaryKeys = new ArrayList<>();
        mysqlFields.forEach(mysqlField -> {
            if (mysqlField.getIsPRI()) {
                primaryKeys.add(mysqlField);
            }
        });
        return primaryKeys;
    }
}
