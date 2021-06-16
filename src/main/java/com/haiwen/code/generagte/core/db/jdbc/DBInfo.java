package com.haiwen.code.generagte.core.db.jdbc;

import com.haiwen.code.generagte.base.DBTemplate;
import com.haiwen.code.generagte.core.bo.jdbc.DbConnProperties;
import demo.spring.boot.demospringboot.parse.mysql.parse.db.util.MysqlBD;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.MysqlTable;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.MysqlField;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DBInfo {
    /**
     * 获取表的信息
     *
     * @return 返回这个表的所有相关信息:表名称,表类型,引擎,表的字符集,表的注释<br>
     * String tableName;                             //TABLE_NAME      表名称
     * String tableType;                             //TABLE_TYPE      表类型   [BASE TABLE\VIEW|SYSTEM VIEW]
     * String engine;                                //ENGINE          引擎     [MEMORY|InnoDB|MyISAM\CSV|PERFORMANCE_SCHEMA]
     * int version;                                  //VERSION         版本
     * String rowFormat;                             //ROW_FORMAT      行格式    [Fixed|Dynamic]
     * Date createTime;                              //CREATE_TIME     创建时间
     * String tableCollation;                        //TABLE_COLLATION 表的字符集 [utf8_general_ci|utf8_croatian_ci]
     * String tableComment;                          //TABLE_COMMENT   表的注释
     * private List<MysqlField> mysqlFields;         //表的字段!! 这里没有被注入
     * private List<MysqlField> primaryKeys;         //表的主键!! 这里没有被注入
     */
    public MysqlTable obtainTableInfo(String dataBase, String ptableName, DbConnProperties dbConnProperties) throws Exception {
        MysqlBD mysqlBD = MysqlBD.getInstance(true);
        String sql = "SELECT " +
                "tab.TABLE_NAME AS TABLE_NAME, " +
                "tab.TABLE_TYPE AS TABLE_TYPE, " +
                "tab.`ENGINE` AS ENGINE , " +
                "tab.VERSION AS VERSION , " +
                "tab.ROW_FORMAT AS ROW_FORMAT, " +
                "tab.CREATE_TIME AS CREATE_TIME, " +
                "tab.TABLE_COLLATION AS TABLE_COLLATION, " +
                "tab.TABLE_COMMENT AS TABLE_COMMENT " +
                "FROM information_schema.TABLES tab " +
                "WHERE table_schema =''{0}'' and table_name = ''{1}''";

        sql = MessageFormat.format(sql, dataBase, ptableName);
        MysqlTable table = DBTemplate.executeQuery(dbConnProperties, sql, resultSet -> {
            MysqlTable resultTable = new MysqlTable();
            try {
                while (resultSet.next()) {
                    String tableName = resultSet.getString("TABLE_NAME");
                    String tableType = resultSet.getString("TABLE_TYPE");
                    String engine = resultSet.getString("ENGINE");
                    int version = resultSet.getInt("VERSION");
                    String rowFormat = resultSet.getString("ROW_FORMAT");
                    Date createTime = resultSet.getDate("CREATE_TIME");
                    String tableCollation = resultSet.getString("TABLE_COLLATION");
                    String tableComment = resultSet.getString("TABLE_COMMENT");

                    resultTable.setCreateTime(createTime);
                    resultTable.setEngine(engine);
                    resultTable.setRowFormat(rowFormat);
                    resultTable.setTableCollation(tableCollation);
                    resultTable.setVersion(version);
                    resultTable.setTableType(tableType);
                    resultTable.setTableName(tableName);
                    resultTable.setTableComment(tableComment);
                }
            } catch (Exception e) {
                log.info("[mysql解析][获取表信息错误]{}", e.toString(), e);
            }
            return resultTable;
        });
        log.info("[mysql解析][获取表的信息]{}", table);
        return table;
    }


    /**
     * 获取字段的信息：字段名称,字段类型,字段注释,字段是否允许为null,字段是否为主键
     *
     * @return <br>
     * private String name;       //字段名称
     * private String type;       //字段类型
     * private String comment;    //字段注释
     * private Boolean isNotNull; //字段是否允许为null
     * private Boolean isPRI;     //字段是否为主键
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<MysqlField> obtainFieldsInfo(String dataBase, String ptableName, DbConnProperties dbConnProperties) throws Exception {
        MysqlBD mysqlBD = MysqlBD.getInstance(true);
        String sql = "select * from information_schema.columns where table_schema = ''{0}'' and table_name = ''{1}''";
        sql = MessageFormat.format(sql, dataBase, ptableName);
        List<MysqlField> mysqlFields = DBTemplate.executeQuery(dbConnProperties, sql, resultSet -> {
            List<MysqlField> resultFields = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    MysqlField field = new MysqlField();
                    String name = resultSet.getString("COLUMN_NAME");
                    String type = resultSet.getString("DATA_TYPE");
                    String coment = resultSet.getString("COLUMN_COMMENT");
                    boolean isNotNull = resultSet.getString("IS_NULLABLE").equalsIgnoreCase("YES") ? true : false;
                    boolean isPRI = resultSet.getString("COLUMN_KEY").equalsIgnoreCase("PRI") ? true : false;
                    field.setName(name);
                    field.setComment(coment);
                    field.setIsNotNull(isNotNull);
                    field.setIsPRI(isPRI);
                    field.setType(type);
                    resultFields.add(field);

                }
            } catch (Exception e) {
                log.info("[mysql解析][获取字段信息错误]{}", e.toString(), e);
            }
            return resultFields;
        });
        log.info("[mysql解析][获取字段信息]{}", mysqlFields);
        return mysqlFields;
    }

}
