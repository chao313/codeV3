package demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.plugin;

/**
 * 专门存放接口的地方
 */
public enum InterfaceEnum {
    updateByPrimaryKey("updateByPrimaryKey", "update", "ByPrimaryKey", "根据主键更新"),
    deleteByPrimaryKey("deleteByPrimaryKey", "delete", "ByPrimaryKey", "根据主键删除"),
    queryByPrimaryKey("queryByPrimaryKey", "query", "ByPrimaryKey", "根据主键查询"),
    updateBase("updateBase", "updateBase", "", "多条件更新"),
    queryBase("queryBase", "queryBase", "", "多条件查询"),
    inserts("inserts", "inserts", "", "批量插入"),
    insert("insert", "insert", "", "单条插入"),
    QueryBasePageHelper("queryBasePageHelper", "queryBasePageHelper", "", "分页查询"),//注意这里是突然加入了分页查重，可能有问题
    ;

    /**
     * 操作的接口
     */
    private String key;//作为key的存在
    private String prefix;//二级key的前缀
    private String suffix;//二级key的后缀
    private String comment;//注释

    InterfaceEnum(String key, String prefix, String suffix, String comment) {
        this.key = key;
        this.prefix = prefix;
        this.suffix = suffix;
        this.comment = comment;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
