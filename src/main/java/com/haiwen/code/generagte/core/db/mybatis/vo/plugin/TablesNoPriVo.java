package com.haiwen.code.generagte.core.db.mybatis.vo.plugin;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * 这里属性是非主键字段
 *
 * 表名称      :TABLES
 * 表类型      :SYSTEM VIEW
 * 表引擎      :MEMORY
 * 表版本      :10
 * 行格式      :Fixed
 * 表创建      :2020-5-30
 * 字符集      :utf8_general_ci
 * 表注释      :
 */
public class TablesNoPriVo {

    private String tableCatalog; 
    private String tableSchema; 
    private String tableName; 
    private String tableType; 
    private String engine; 
    private Long version; 
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
    private String tableComment; 


    public String getTableCatalog() {

        return tableCatalog;

    }

    public void setTableCatalog(String tableCatalog) {

        this.tableCatalog = tableCatalog;

    }
    public String getTableSchema() {

        return tableSchema;

    }

    public void setTableSchema(String tableSchema) {

        this.tableSchema = tableSchema;

    }
    public String getTableName() {

        return tableName;

    }

    public void setTableName(String tableName) {

        this.tableName = tableName;

    }
    public String getTableType() {

        return tableType;

    }

    public void setTableType(String tableType) {

        this.tableType = tableType;

    }
    public String getEngine() {

        return engine;

    }

    public void setEngine(String engine) {

        this.engine = engine;

    }
    public Long getVersion() {

        return version;

    }

    public void setVersion(Long version) {

        this.version = version;

    }
    public String getRowFormat() {

        return rowFormat;

    }

    public void setRowFormat(String rowFormat) {

        this.rowFormat = rowFormat;

    }
    public Long getTableRows() {

        return tableRows;

    }

    public void setTableRows(Long tableRows) {

        this.tableRows = tableRows;

    }
    public Long getAvgRowLength() {

        return avgRowLength;

    }

    public void setAvgRowLength(Long avgRowLength) {

        this.avgRowLength = avgRowLength;

    }
    public Long getDataLength() {

        return dataLength;

    }

    public void setDataLength(Long dataLength) {

        this.dataLength = dataLength;

    }
    public Long getMaxDataLength() {

        return maxDataLength;

    }

    public void setMaxDataLength(Long maxDataLength) {

        this.maxDataLength = maxDataLength;

    }
    public Long getIndexLength() {

        return indexLength;

    }

    public void setIndexLength(Long indexLength) {

        this.indexLength = indexLength;

    }
    public Long getDataFree() {

        return dataFree;

    }

    public void setDataFree(Long dataFree) {

        this.dataFree = dataFree;

    }
    public Long getAutoIncrement() {

        return autoIncrement;

    }

    public void setAutoIncrement(Long autoIncrement) {

        this.autoIncrement = autoIncrement;

    }
    public Timestamp getCreateTime() {

        return createTime;

    }

    public void setCreateTime(Timestamp createTime) {

        this.createTime = createTime;

    }
    public Timestamp getUpdateTime() {

        return updateTime;

    }

    public void setUpdateTime(Timestamp updateTime) {

        this.updateTime = updateTime;

    }
    public Timestamp getCheckTime() {

        return checkTime;

    }

    public void setCheckTime(Timestamp checkTime) {

        this.checkTime = checkTime;

    }
    public String getTableCollation() {

        return tableCollation;

    }

    public void setTableCollation(String tableCollation) {

        this.tableCollation = tableCollation;

    }
    public Long getChecksum() {

        return checksum;

    }

    public void setChecksum(Long checksum) {

        this.checksum = checksum;

    }
    public String getCreateOptions() {

        return createOptions;

    }

    public void setCreateOptions(String createOptions) {

        this.createOptions = createOptions;

    }
    public String getTableComment() {

        return tableComment;

    }

    public void setTableComment(String tableComment) {

        this.tableComment = tableComment;

    }

    @Override
    public String toString() {
        return "TablesNoPriVo{" +
                ", tableCatalog '" + tableCatalog + '\'' +
                ", tableSchema '" + tableSchema + '\'' +
                ", tableName '" + tableName + '\'' +
                ", tableType '" + tableType + '\'' +
                ", engine '" + engine + '\'' +
                ", version '" + version +
                ", rowFormat '" + rowFormat + '\'' +
                ", tableRows '" + tableRows +
                ", avgRowLength '" + avgRowLength +
                ", dataLength '" + dataLength +
                ", maxDataLength '" + maxDataLength +
                ", indexLength '" + indexLength +
                ", dataFree '" + dataFree +
                ", autoIncrement '" + autoIncrement +
                ", createTime '" + createTime +
                ", updateTime '" + updateTime +
                ", checkTime '" + checkTime +
                ", tableCollation '" + tableCollation + '\'' +
                ", checksum '" + checksum +
                ", createOptions '" + createOptions + '\'' +
                ", tableComment '" + tableComment + '\'' +
                '}';
    }

}
