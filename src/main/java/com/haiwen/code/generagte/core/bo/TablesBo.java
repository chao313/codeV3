package com.haiwen.code.generagte.core.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;


/**
 * 数据表信息
 * 表名称      :TABLES
 * 表类型      :SYSTEM VIEW
 * 表引擎      :MEMORY
 * 表版本      :10
 * 行格式      :Fixed
 * 表创建      :2020-5-30
 * 字符集      :utf8_general_ci
 * 表注释      :
 */
@Data
public class TablesBo {

    private String tableCatalog; //表目录
    private String tableSchema; //表所在的库名
    private String tableName; //表名
    private String tableType; //表类型(普通表|视图)
    private String engine; //表引擎
    private Long version; //表版本
    private String rowFormat;
    private Long tableRows;
    private Long avgRowLength;
    private Long dataLength;
    private Long maxDataLength;
    private Long indexLength;
    private Long dataFree;
    private Long autoIncrement;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(dataType = "date", example = "1970-01-01 12:12:12")
    private Timestamp createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(dataType = "date", example = "1970-01-01 12:12:12")
    private Timestamp updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(dataType = "date", example = "1970-01-01 12:12:12")
    private Timestamp checkTime;
    private String tableCollation;
    private Long checksum;
    private String createOptions;
    private String tableComment; //表注释


}
