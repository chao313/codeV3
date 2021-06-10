package ${ftlVo.packageName};

import ${allJavaFtl.voNoPriFtl.packageName}.${allJavaFtl.voNoPriFtl.className};
import ${allJavaFtl.voPriFtl.packageName}.${allJavaFtl.voPriFtl.className};

/**
 * 这个是用于updateByKey的request使用
 */
public class ${ftlVo.className} {

    /**
     * source -> 需要更新的
     */
    private ${allJavaFtl.voNoPriFtl.className} source;

    /**
     * target -> 目标条件
     */
    private ${allJavaFtl.voPriFtl.className} target;


    public ${allJavaFtl.voNoPriFtl.className} getSource() {
        return source;
    }

    public void setSource(${allJavaFtl.voNoPriFtl.className} source) {
        this.source = source;
    }

    public ${allJavaFtl.voPriFtl.className} getTarget() {
        return target;
    }

    public void setTarget(${allJavaFtl.voPriFtl.className} target) {
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
