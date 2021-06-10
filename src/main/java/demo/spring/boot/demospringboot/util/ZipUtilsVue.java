package demo.spring.boot.demospringboot.util;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.FtlVueInterface;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.AllVueFtl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ZipUtilsVue {

    /**
     * @param codeDirPath
     * @param targetOperateDirPath
     * @throws IOException
     */
    public static void deal(List<AllVueFtl> allVueFtls, String sourceVueWebDirPath, String codeDirPath, String targetOperateDirPath) throws IOException {
        /**
         * 1.把maven项目复制到操作目录下
         */
        File sourceVueWebDir = new File(sourceVueWebDirPath);
        sourceVueWebDir.mkdirs();//创建文件夹
        File targetOperateDir = new File(targetOperateDirPath);
        org.apache.commons.io.FileUtils.copyDirectory(sourceVueWebDir, targetOperateDir);//项目复制到目标文件夹下

        for (AllVueFtl allVueFtl : allVueFtls) {
            /**
             * 所有的文件统一处理
             */
            List<FtlVueInterface> ftlVueInterfaces = new ArrayList<>();
            ftlVueInterfaces.add(allVueFtl.getIndexJsFtl());
            ftlVueInterfaces.add(allVueFtl.getApiJsFtl());
            ftlVueInterfaces.add(allVueFtl.getEditVueFtl());
            ftlVueInterfaces.add(allVueFtl.getListVueFtl());
            ftlVueInterfaces.add(allVueFtl.getViewVueFtl());
            ftlVueInterfaces.add(allVueFtl.getAddVueFtl());

            /**
             * 创建文件并写入数据
             */
            for (FtlVueInterface ftlVueInterface : ftlVueInterfaces) {
                BufferedOutputStream outputStream = null;
                String dir = codeDirPath + ftlVueInterface.getDirPath();
                //创建文件夹
                new File(dir).mkdirs();
                File voFile = new File(dir + "/" + ftlVueInterface.getFileName());
                voFile.createNewFile();
                outputStream = new BufferedOutputStream(new FileOutputStream(voFile));
                outputStream.write(ftlVueInterface.getFreeMarkStr().getBytes());
                outputStream.flush();
                outputStream.close();

            }
        }


    }
}
