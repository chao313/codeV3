package demomaster.vo.plugin;


/**
 * 这里属性是非主键字段
 *
 * 表名称      :t_project
 * 表类型      :BASE TABLE
 * 表引擎      :InnoDB
 * 表版本      :10
 * 行格式      :Compact
 * 表创建      :2020-6-6
 * 字符集      :utf8_bin
 * 表注释      :
 */
public class TProjectNoPriVo {

    private String projectName;  // 项目名称 
    private String projectPort;  // 端口号 
    private String projectContextPath;  // 项目上下文 
    private String projectRootPackage;  // 项目root包 
    private String projectMailHost;  // 项目邮件主机 
    private String projectMailUserName;  // 项目邮件用户名 
    private String projectMailPassword;  // 项目邮件密码 
    private String projectAuthorName;  // 项目作者name 
    private String projectAuthorQq;  // 项目作者qq 
    private String projectAuthorPhone;  // 项目作者phone 
    private String projectDbDriverClassName;  // 项目数据库驱动 
    private String projectDbUrl;  // 项目数据库地址 
    private String projectDbUserName;  // 项目数据库用户名 
    private String projectDbPassword;  // 项目数据库密码 
    private String projectUrlSwaggerUi;  // 项目swagger_ui地址 


    public String getProjectName() {

        return projectName;

    }

    public void setProjectName(String projectName) {

        this.projectName = projectName;

    }
    public String getProjectPort() {

        return projectPort;

    }

    public void setProjectPort(String projectPort) {

        this.projectPort = projectPort;

    }
    public String getProjectContextPath() {

        return projectContextPath;

    }

    public void setProjectContextPath(String projectContextPath) {

        this.projectContextPath = projectContextPath;

    }
    public String getProjectRootPackage() {

        return projectRootPackage;

    }

    public void setProjectRootPackage(String projectRootPackage) {

        this.projectRootPackage = projectRootPackage;

    }
    public String getProjectMailHost() {

        return projectMailHost;

    }

    public void setProjectMailHost(String projectMailHost) {

        this.projectMailHost = projectMailHost;

    }
    public String getProjectMailUserName() {

        return projectMailUserName;

    }

    public void setProjectMailUserName(String projectMailUserName) {

        this.projectMailUserName = projectMailUserName;

    }
    public String getProjectMailPassword() {

        return projectMailPassword;

    }

    public void setProjectMailPassword(String projectMailPassword) {

        this.projectMailPassword = projectMailPassword;

    }
    public String getProjectAuthorName() {

        return projectAuthorName;

    }

    public void setProjectAuthorName(String projectAuthorName) {

        this.projectAuthorName = projectAuthorName;

    }
    public String getProjectAuthorQq() {

        return projectAuthorQq;

    }

    public void setProjectAuthorQq(String projectAuthorQq) {

        this.projectAuthorQq = projectAuthorQq;

    }
    public String getProjectAuthorPhone() {

        return projectAuthorPhone;

    }

    public void setProjectAuthorPhone(String projectAuthorPhone) {

        this.projectAuthorPhone = projectAuthorPhone;

    }
    public String getProjectDbDriverClassName() {

        return projectDbDriverClassName;

    }

    public void setProjectDbDriverClassName(String projectDbDriverClassName) {

        this.projectDbDriverClassName = projectDbDriverClassName;

    }
    public String getProjectDbUrl() {

        return projectDbUrl;

    }

    public void setProjectDbUrl(String projectDbUrl) {

        this.projectDbUrl = projectDbUrl;

    }
    public String getProjectDbUserName() {

        return projectDbUserName;

    }

    public void setProjectDbUserName(String projectDbUserName) {

        this.projectDbUserName = projectDbUserName;

    }
    public String getProjectDbPassword() {

        return projectDbPassword;

    }

    public void setProjectDbPassword(String projectDbPassword) {

        this.projectDbPassword = projectDbPassword;

    }
    public String getProjectUrlSwaggerUi() {

        return projectUrlSwaggerUi;

    }

    public void setProjectUrlSwaggerUi(String projectUrlSwaggerUi) {

        this.projectUrlSwaggerUi = projectUrlSwaggerUi;

    }

    @Override
    public String toString() {
        return "TProjectNoPriVo{" +
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
