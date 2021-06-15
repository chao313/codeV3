package demomaster.vo;

import demo.spring.boot.demospringboot.framework.MultiTerm;

/**
 * 表名称      :t_project
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public class TProjectMultiTermVo {

    private MultiTerm<String> dbName;  // 库名
    private MultiTerm<String> projectName;  // 项目名称
    private MultiTerm<String> projectPort;  // 端口号
    private MultiTerm<String> projectContextPath;  // 项目上下文
    private MultiTerm<String> projectRootPackage;  // 项目root包
    private MultiTerm<String> projectMailHost;  // 项目邮件主机
    private MultiTerm<String> projectMailUserName;  // 项目邮件用户名
    private MultiTerm<String> projectMailPassword;  // 项目邮件密码
    private MultiTerm<String> projectAuthorName;  // 项目作者name
    private MultiTerm<String> projectAuthorQq;  // 项目作者qq
    private MultiTerm<String> projectAuthorPhone;  // 项目作者phone
    private MultiTerm<String> projectDbDriverClassName;  // 项目数据库驱动
    private MultiTerm<String> projectDbUrl;  // 项目数据库地址
    private MultiTerm<String> projectDbUserName;  // 项目数据库用户名
    private MultiTerm<String> projectDbPassword;  // 项目数据库密码
    private MultiTerm<String> projectUrlSwaggerUi;  // 项目swagger_ui地址


    public MultiTerm<String> getDbName() {

        return dbName;

    }

    public void setDbName(MultiTerm<String> dbName) {

        this.dbName = dbName;

    }
    public MultiTerm<String> getProjectName() {

        return projectName;

    }

    public void setProjectName(MultiTerm<String> projectName) {

        this.projectName = projectName;

    }
    public MultiTerm<String> getProjectPort() {

        return projectPort;

    }

    public void setProjectPort(MultiTerm<String> projectPort) {

        this.projectPort = projectPort;

    }
    public MultiTerm<String> getProjectContextPath() {

        return projectContextPath;

    }

    public void setProjectContextPath(MultiTerm<String> projectContextPath) {

        this.projectContextPath = projectContextPath;

    }
    public MultiTerm<String> getProjectRootPackage() {

        return projectRootPackage;

    }

    public void setProjectRootPackage(MultiTerm<String> projectRootPackage) {

        this.projectRootPackage = projectRootPackage;

    }
    public MultiTerm<String> getProjectMailHost() {

        return projectMailHost;

    }

    public void setProjectMailHost(MultiTerm<String> projectMailHost) {

        this.projectMailHost = projectMailHost;

    }
    public MultiTerm<String> getProjectMailUserName() {

        return projectMailUserName;

    }

    public void setProjectMailUserName(MultiTerm<String> projectMailUserName) {

        this.projectMailUserName = projectMailUserName;

    }
    public MultiTerm<String> getProjectMailPassword() {

        return projectMailPassword;

    }

    public void setProjectMailPassword(MultiTerm<String> projectMailPassword) {

        this.projectMailPassword = projectMailPassword;

    }
    public MultiTerm<String> getProjectAuthorName() {

        return projectAuthorName;

    }

    public void setProjectAuthorName(MultiTerm<String> projectAuthorName) {

        this.projectAuthorName = projectAuthorName;

    }
    public MultiTerm<String> getProjectAuthorQq() {

        return projectAuthorQq;

    }

    public void setProjectAuthorQq(MultiTerm<String> projectAuthorQq) {

        this.projectAuthorQq = projectAuthorQq;

    }
    public MultiTerm<String> getProjectAuthorPhone() {

        return projectAuthorPhone;

    }

    public void setProjectAuthorPhone(MultiTerm<String> projectAuthorPhone) {

        this.projectAuthorPhone = projectAuthorPhone;

    }
    public MultiTerm<String> getProjectDbDriverClassName() {

        return projectDbDriverClassName;

    }

    public void setProjectDbDriverClassName(MultiTerm<String> projectDbDriverClassName) {

        this.projectDbDriverClassName = projectDbDriverClassName;

    }
    public MultiTerm<String> getProjectDbUrl() {

        return projectDbUrl;

    }

    public void setProjectDbUrl(MultiTerm<String> projectDbUrl) {

        this.projectDbUrl = projectDbUrl;

    }
    public MultiTerm<String> getProjectDbUserName() {

        return projectDbUserName;

    }

    public void setProjectDbUserName(MultiTerm<String> projectDbUserName) {

        this.projectDbUserName = projectDbUserName;

    }
    public MultiTerm<String> getProjectDbPassword() {

        return projectDbPassword;

    }

    public void setProjectDbPassword(MultiTerm<String> projectDbPassword) {

        this.projectDbPassword = projectDbPassword;

    }
    public MultiTerm<String> getProjectUrlSwaggerUi() {

        return projectUrlSwaggerUi;

    }

    public void setProjectUrlSwaggerUi(MultiTerm<String> projectUrlSwaggerUi) {

        this.projectUrlSwaggerUi = projectUrlSwaggerUi;

    }

    @Override
    public String toString() {
        return "TProjectMultiTermVo{" +
                ", dbName '" + dbName + '\'' +
                ", projectName '" + projectName + '\'' +
                ", projectPort '" + projectPort + '\'' +
                ", projectContextPath '" + projectContextPath + '\'' +
                ", projectRootPackage '" + projectRootPackage + '\'' +
                ", projectMailHost '" + projectMailHost + '\'' +
                ", projectMailUserName '" + projectMailUserName + '\'' +
                ", projectMailPassword '" + projectMailPassword + '\'' +
                ", projectAuthorName '" + projectAuthorName + '\'' +
                ", projectAuthorQq '" + projectAuthorQq + '\'' +
                ", projectAuthorPhone '" + projectAuthorPhone + '\'' +
                ", projectDbDriverClassName '" + projectDbDriverClassName + '\'' +
                ", projectDbUrl '" + projectDbUrl + '\'' +
                ", projectDbUserName '" + projectDbUserName + '\'' +
                ", projectDbPassword '" + projectDbPassword + '\'' +
                ", projectUrlSwaggerUi '" + projectUrlSwaggerUi + '\'' +
                '}';
    }

}
