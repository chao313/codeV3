package demo.spring.boot.demospringboot.mybatis.vo;

import demo.spring.boot.demospringboot.config.framework.MultiTerm;

/**
 * 表名称      :TABLES
 * 表类型      :SYSTEM VIEW
 * 表引擎      :MEMORY
 * 表版本      :10
 * 行格式      :Fixed
 * 表创建      :2020-5-30
 * 字符集      :utf8_general_ci
 * 表注释      :
 */
public class TablesMultiTermVo {

    private MultiTerm<String> tableCatalog; 
    private MultiTerm<String> tableSchema; 
    private MultiTerm<String> tableName; 
    private MultiTerm<String> tableType; 
    private MultiTerm<String> engine; 
    private MultiTerm<Long> version; 
    private MultiTerm<String> rowFormat; 
    private MultiTerm<Long> tableRows; 
    private MultiTerm<Long> avgRowLength; 
    private MultiTerm<Long> dataLength; 
    private MultiTerm<Long> maxDataLength; 
    private MultiTerm<Long> indexLength; 
    private MultiTerm<Long> dataFree; 
    private MultiTerm<Long> autoIncrement; 
    private MultiTerm<String> createTime; 
    private MultiTerm<String> updateTime; 
    private MultiTerm<String> checkTime; 
    private MultiTerm<String> tableCollation; 
    private MultiTerm<Long> checksum; 
    private MultiTerm<String> createOptions; 
    private MultiTerm<String> tableComment; 


    public MultiTerm<String> getTableCatalog() {

        return tableCatalog;

    }

    public void setTableCatalog(MultiTerm<String> tableCatalog) {

        this.tableCatalog = tableCatalog;

    }
    public MultiTerm<String> getTableSchema() {

        return tableSchema;

    }

    public void setTableSchema(MultiTerm<String> tableSchema) {

        this.tableSchema = tableSchema;

    }
    public MultiTerm<String> getTableName() {

        return tableName;

    }

    public void setTableName(MultiTerm<String> tableName) {

        this.tableName = tableName;

    }
    public MultiTerm<String> getTableType() {

        return tableType;

    }

    public void setTableType(MultiTerm<String> tableType) {

        this.tableType = tableType;

    }
    public MultiTerm<String> getEngine() {

        return engine;

    }

    public void setEngine(MultiTerm<String> engine) {

        this.engine = engine;

    }
    public MultiTerm<Long> getVersion() {

        return version;

    }

    public void setVersion(MultiTerm<Long> version) {

        this.version = version;

    }
    public MultiTerm<String> getRowFormat() {

        return rowFormat;

    }

    public void setRowFormat(MultiTerm<String> rowFormat) {

        this.rowFormat = rowFormat;

    }
    public MultiTerm<Long> getTableRows() {

        return tableRows;

    }

    public void setTableRows(MultiTerm<Long> tableRows) {

        this.tableRows = tableRows;

    }
    public MultiTerm<Long> getAvgRowLength() {

        return avgRowLength;

    }

    public void setAvgRowLength(MultiTerm<Long> avgRowLength) {

        this.avgRowLength = avgRowLength;

    }
    public MultiTerm<Long> getDataLength() {

        return dataLength;

    }

    public void setDataLength(MultiTerm<Long> dataLength) {

        this.dataLength = dataLength;

    }
    public MultiTerm<Long> getMaxDataLength() {

        return maxDataLength;

    }

    public void setMaxDataLength(MultiTerm<Long> maxDataLength) {

        this.maxDataLength = maxDataLength;

    }
    public MultiTerm<Long> getIndexLength() {

        return indexLength;

    }

    public void setIndexLength(MultiTerm<Long> indexLength) {

        this.indexLength = indexLength;

    }
    public MultiTerm<Long> getDataFree() {

        return dataFree;

    }

    public void setDataFree(MultiTerm<Long> dataFree) {

        this.dataFree = dataFree;

    }
    public MultiTerm<Long> getAutoIncrement() {

        return autoIncrement;

    }

    public void setAutoIncrement(MultiTerm<Long> autoIncrement) {

        this.autoIncrement = autoIncrement;

    }
    public MultiTerm<String> getCreateTime() {

        return createTime;

    }

    public void setCreateTime(MultiTerm<String> createTime) {

        this.createTime = createTime;

    }
    public MultiTerm<String> getUpdateTime() {

        return updateTime;

    }

    public void setUpdateTime(MultiTerm<String> updateTime) {

        this.updateTime = updateTime;

    }
    public MultiTerm<String> getCheckTime() {

        return checkTime;

    }

    public void setCheckTime(MultiTerm<String> checkTime) {

        this.checkTime = checkTime;

    }
    public MultiTerm<String> getTableCollation() {

        return tableCollation;

    }

    public void setTableCollation(MultiTerm<String> tableCollation) {

        this.tableCollation = tableCollation;

    }
    public MultiTerm<Long> getChecksum() {

        return checksum;

    }

    public void setChecksum(MultiTerm<Long> checksum) {

        this.checksum = checksum;

    }
    public MultiTerm<String> getCreateOptions() {

        return createOptions;

    }

    public void setCreateOptions(MultiTerm<String> createOptions) {

        this.createOptions = createOptions;

    }
    public MultiTerm<String> getTableComment() {

        return tableComment;

    }

    public void setTableComment(MultiTerm<String> tableComment) {

        this.tableComment = tableComment;

    }

    @Override
    public String toString() {
        return "TablesMultiTermVo{" +
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
