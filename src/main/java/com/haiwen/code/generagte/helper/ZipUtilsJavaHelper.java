package com.haiwen.code.generagte.helper;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.FtlJavaInterface;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java.AllJavaFtl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ZipUtilsJavaHelper {

    /**
     * @param codeDirPath
     * @param targetOperateDirPath
     * @throws IOException
     */
    public static void deal(List<AllJavaFtl> allJavaFtls, String sourceMavenDirPath, String codeDirPath, String targetOperateDirPath) throws IOException {
        /**
         * 1.把maven项目复制到操作目录下
         */
        File sourceMavenDir = new File(sourceMavenDirPath);
        sourceMavenDir.mkdirs();//创建文件夹
        File targetOperateDir = new File(targetOperateDirPath);
        org.apache.commons.io.FileUtils.copyDirectory(sourceMavenDir, targetOperateDir);//项目复制到目标文件夹下

        for (AllJavaFtl allJavaFtl : allJavaFtls) {
            /**
             * 2.生成code
             */

            /**
             * 所有的文件统一处理
             */
            List<FtlJavaInterface> ftlJavaInterfaces = new ArrayList<>();
            ftlJavaInterfaces.add(allJavaFtl.getControllerFtl());
            ftlJavaInterfaces.add(allJavaFtl.getServiceImplFtl());
            ftlJavaInterfaces.add(allJavaFtl.getServiceFtl());
            ftlJavaInterfaces.add(allJavaFtl.getDaoFtl());
            /**
             * 移除两种文件 -> 后期可能回退
             * 控制生成文化的地方
             */
//            ftlJavaInterfaces.add(allJavaFtl.getRequestUpdatePrimaryKeyFtl());
//            ftlJavaInterfaces.add(allJavaFtl.getRequestUpdateBaseFtl());
            ftlJavaInterfaces.add(allJavaFtl.getVoNoPriFtl());
            ftlJavaInterfaces.add(allJavaFtl.getVoPriFtl());
            ftlJavaInterfaces.add(allJavaFtl.getVoFtl());
            ftlJavaInterfaces.add(allJavaFtl.getMultiTermVoFtl());
            ftlJavaInterfaces.add(allJavaFtl.getMapperFtl());

            /**
             * 创建文件并写入数据
             */
            for (FtlJavaInterface ftlJavaInterface : ftlJavaInterfaces) {
                BufferedOutputStream outputStream = null;
                String dir = (codeDirPath + ftlJavaInterface.getPackageName()).replace(".", "/");
                //创建文件夹
                new File(dir).mkdirs();
                File voFile = new File(dir + "/" + ftlJavaInterface.getFileName());
                voFile.createNewFile();
                outputStream = new BufferedOutputStream(new FileOutputStream(voFile));
                outputStream.write(ftlJavaInterface.getFreeMarkStr().getBytes());
                outputStream.flush();
                outputStream.close();

            }
        }

    }
}
