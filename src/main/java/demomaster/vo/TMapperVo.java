package demomaster.vo;




/**
 * 表名称      :t_mapper
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public class TMapperVo {

    private String dbName;  // 库名 
    private String dbTableName;  // 表名 
    private String dbTableComment;  // 表注释 
    private String dirName;  // 文件夹名称 
    private String fileName;  // 文件名 
    private String freemarkPath;  // freemark路径 
    private String freemarkContent;  // freemark内容 
    private String freemarkValue;  // freemark生成结果 


    public String getDbName() {

        return dbName;

    }

    public void setDbName(String dbName) {

        this.dbName = dbName;

    }

    public String getDbTableName() {

        return dbTableName;

    }

    public void setDbTableName(String dbTableName) {

        this.dbTableName = dbTableName;

    }

    public String getDbTableComment() {

        return dbTableComment;

    }

    public void setDbTableComment(String dbTableComment) {

        this.dbTableComment = dbTableComment;

    }

    public String getDirName() {

        return dirName;

    }

    public void setDirName(String dirName) {

        this.dirName = dirName;

    }

    public String getFileName() {

        return fileName;

    }

    public void setFileName(String fileName) {

        this.fileName = fileName;

    }

    public String getFreemarkPath() {

        return freemarkPath;

    }

    public void setFreemarkPath(String freemarkPath) {

        this.freemarkPath = freemarkPath;

    }

    public String getFreemarkContent() {

        return freemarkContent;

    }

    public void setFreemarkContent(String freemarkContent) {

        this.freemarkContent = freemarkContent;

    }

    public String getFreemarkValue() {

        return freemarkValue;

    }

    public void setFreemarkValue(String freemarkValue) {

        this.freemarkValue = freemarkValue;

    }


    @Override
    public String toString() {
        return "TMapperVo{" +
                ", dbName '" + dbName + '\'' +
                ", dbTableName '" + dbTableName + '\'' +
                ", dbTableComment '" + dbTableComment + '\'' +
                ", dirName '" + dirName + '\'' +
                ", fileName '" + fileName + '\'' +
                ", freemarkPath '" + freemarkPath + '\'' +
                ", freemarkContent '" + freemarkContent + '\'' +
                ", freemarkValue '" + freemarkValue + '\'' +
                '}';
    }

}
