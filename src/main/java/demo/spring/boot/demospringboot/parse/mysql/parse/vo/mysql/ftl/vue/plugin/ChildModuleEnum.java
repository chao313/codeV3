package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.plugin;

/**
 * 专门存放接口的地方
 */
public enum ChildModuleEnum {
    VIEW("View", "Update更新", "view", "true"),
    EDIT("Edit", "Edit编辑", "edit", "true"),
    LIST("List", "List列表", "list", "false"),
    ADD("Add", "Add添加", "add", "true"),
    ;

    /**
     * 操作的接口
     */
    private String childModuleNameSuffix;//子模块名称
    private String metaTitleSuffix;//子模块Title
    private String realPathSuffix;//真正路径的后缀 -> @/views/zipManager/list
    private String isHidden;//是否隐藏


    ChildModuleEnum(String childModuleNameSuffix, String metaTitleSuffix, String realPathSuffix, String isHidden) {
        this.childModuleNameSuffix = childModuleNameSuffix;
        this.metaTitleSuffix = metaTitleSuffix;
        this.realPathSuffix = realPathSuffix;
        this.isHidden = isHidden;
    }

    public String getChildModuleNameSuffix() {
        return childModuleNameSuffix;
    }

    public void setChildModuleNameSuffix(String childModuleNameSuffix) {
        this.childModuleNameSuffix = childModuleNameSuffix;
    }

    public String getMetaTitleSuffix() {
        return metaTitleSuffix;
    }

    public void setMetaTitleSuffix(String metaTitleSuffix) {
        this.metaTitleSuffix = metaTitleSuffix;
    }

    public String getRealPathSuffix() {
        return realPathSuffix;
    }

    public void setRealPathSuffix(String realPathSuffix) {
        this.realPathSuffix = realPathSuffix;
    }

    public String getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(String isHidden) {
        this.isHidden = isHidden;
    }
}
