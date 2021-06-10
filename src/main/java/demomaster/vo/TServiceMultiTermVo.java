package demomaster.vo;

import demo.spring.boot.demospringboot.config.framework.MultiTerm;

/**
 * 表名称      :t_service
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public class TServiceMultiTermVo {

    private MultiTerm<String> dbName;  // 库名
    private MultiTerm<String> dbTableName;  // 表名
    private MultiTerm<String> dbTableComment;  // 表注释
    private MultiTerm<String> packageName;  // 包名
    private MultiTerm<String> className;  // 类名
    private MultiTerm<String> fileName;  // 文件名
    private MultiTerm<String> freemarkPath;  // freemark路径
    private MultiTerm<String> freemarkContent;  // freemark内容
    private MultiTerm<String> freemarkValue;  // freemark生成结果
    private MultiTerm<String> imports;  // vo 需要注入的类型 ,逗号分隔


    public MultiTerm<String> getDbName() {

        return dbName;

    }

    public void setDbName(MultiTerm<String> dbName) {

        this.dbName = dbName;

    }
    public MultiTerm<String> getDbTableName() {

        return dbTableName;

    }

    public void setDbTableName(MultiTerm<String> dbTableName) {

        this.dbTableName = dbTableName;

    }
    public MultiTerm<String> getDbTableComment() {

        return dbTableComment;

    }

    public void setDbTableComment(MultiTerm<String> dbTableComment) {

        this.dbTableComment = dbTableComment;

    }
    public MultiTerm<String> getPackageName() {

        return packageName;

    }

    public void setPackageName(MultiTerm<String> packageName) {

        this.packageName = packageName;

    }
    public MultiTerm<String> getClassName() {

        return className;

    }

    public void setClassName(MultiTerm<String> className) {

        this.className = className;

    }
    public MultiTerm<String> getFileName() {

        return fileName;

    }

    public void setFileName(MultiTerm<String> fileName) {

        this.fileName = fileName;

    }
    public MultiTerm<String> getFreemarkPath() {

        return freemarkPath;

    }

    public void setFreemarkPath(MultiTerm<String> freemarkPath) {

        this.freemarkPath = freemarkPath;

    }
    public MultiTerm<String> getFreemarkContent() {

        return freemarkContent;

    }

    public void setFreemarkContent(MultiTerm<String> freemarkContent) {

        this.freemarkContent = freemarkContent;

    }
    public MultiTerm<String> getFreemarkValue() {

        return freemarkValue;

    }

    public void setFreemarkValue(MultiTerm<String> freemarkValue) {

        this.freemarkValue = freemarkValue;

    }
    public MultiTerm<String> getImports() {

        return imports;

    }

    public void setImports(MultiTerm<String> imports) {

        this.imports = imports;

    }

    @Override
    public String toString() {
        return "TServiceMultiTermVo{" +
                ", dbName '" + dbName + '\'' +
                ", dbTableName '" + dbTableName + '\'' +
                ", dbTableComment '" + dbTableComment + '\'' +
                ", packageName '" + packageName + '\'' +
                ", className '" + className + '\'' +
                ", fileName '" + fileName + '\'' +
                ", freemarkPath '" + freemarkPath + '\'' +
                ", freemarkContent '" + freemarkContent + '\'' +
                ", freemarkValue '" + freemarkValue + '\'' +
                ", imports '" + imports + '\'' +
                '}';
    }

}
