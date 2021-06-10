package ${ftlVo.packageName};

import ${allJavaFtl.voFtl.packageName}.${allJavaFtl.voFtl.className};

/**
 * 这个是用于updateBase的request使用
 */
public class ${ftlVo.className} {

    /**
     * source -> 需要更新的
     */
    private ${allJavaFtl.voFtl.className} source;

    /**
     * target -> 目标条件
     */
    private ${allJavaFtl.voFtl.className} target;



    public ${allJavaFtl.voFtl.className} getSource() {
        return source;
    }

    public void setSource(${allJavaFtl.voFtl.className} source) {
        this.source = source;
    }

    public ${allJavaFtl.voFtl.className} getTarget() {
        return target;
    }

    public void setTarget(${allJavaFtl.voFtl.className} target) {
        this.target = target;
    }


    @Override
    public String toString() {
        return "${ftlVo.className}{" +
                "source=" + source +
                ", target=" + target +
                '}';
    }

}
