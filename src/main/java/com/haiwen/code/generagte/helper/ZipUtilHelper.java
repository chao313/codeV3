package com.haiwen.code.generagte.helper;

import com.haiwen.code.generagte.util.FileUtils;
import demo.spring.boot.demospringboot.controller.generate.GenerateHtmlController;
import demo.spring.boot.demospringboot.controller.generate.GenerateJavaController;
import demo.spring.boot.demospringboot.controller.generate.GenerateVueController;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.FtlJavaInterface;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.html.AllHtmlFtl;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java.AllJavaFtl;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.AllVueFtl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtilHelper {
    private static final int BUFFER_SIZE = 2 * 1024;

    public static final String tmpPath = "tmp/";
    public static final String tmpPathTarget = "tmpTarget/";

    /**
     * 压缩成ZIP 方法1
     *
     * @param srcDir           压缩文件夹路径
     * @param out              压缩文件输出流
     * @param KeepDirStructure 是否保留原来的目录结构,true:保留目录结构;
     *                         <p>
     *                         false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static void toZip(String srcDir, OutputStream out, boolean KeepDirStructure)
            throws RuntimeException {
        long start = System.currentTimeMillis();
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(out);
            File sourceFile = new File(srcDir);
            compress(sourceFile, zos, sourceFile.getName(), KeepDirStructure);
            long end = System.currentTimeMillis();
            System.out.println("压缩完成，耗时：" + (end - start) + " ms");
        } catch (Exception e) {
            throw new RuntimeException("zip error from ZipUtils", e);
        } finally {
            if (zos != null) {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 压缩成ZIP 方法
     *
     * @param srcFiles 需要压缩的文件列表
     * @param out      压缩文件输出流
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static void toZip(List<File> srcFiles, OutputStream out) throws RuntimeException {
        long start = System.currentTimeMillis();
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(out);
            for (File srcFile : srcFiles) {
                byte[] buf = new byte[BUFFER_SIZE];
                zos.putNextEntry(new ZipEntry(srcFile.getName()));
                int len;
                FileInputStream in = new FileInputStream(srcFile);
                while ((len = in.read(buf)) != -1) {
                    zos.write(buf, 0, len);
                }
                zos.closeEntry();
                in.close();
            }
            long end = System.currentTimeMillis();
            System.out.println("压缩完成，耗时：" + (end - start) + " ms");
        } catch (Exception e) {
            throw new RuntimeException("zip error from ZipUtils", e);
        } finally {
            if (zos != null) {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 递归压缩方法
     *
     * @param sourceFile       源文件
     * @param zos              zip输出流
     * @param name             压缩后的名称
     * @param KeepDirStructure 是否保留原来的目录结构,true:保留目录结构;
     *                         <p>
     *                         false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     * @throws Exception
     */
    private static void compress(File sourceFile, ZipOutputStream zos, String name, boolean KeepDirStructure) throws Exception {
        byte[] buf = new byte[BUFFER_SIZE];
        if (sourceFile.isFile()) {                           // 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
            zos.putNextEntry(new ZipEntry(name));            // copy文件到zip输出流中
            int len;
            FileInputStream in = new FileInputStream(sourceFile);
            while ((len = in.read(buf)) != -1) {
                zos.write(buf, 0, len);
            }            // Complete the entry
            zos.closeEntry();
            in.close();
        } else {
            File[] listFiles = sourceFile.listFiles();
            if (listFiles == null || listFiles.length == 0) {          // 需要保留原来的文件结构时,需要对空文件夹进行处理
                if (KeepDirStructure) {                                // 空文件夹的处理
                    zos.putNextEntry(new ZipEntry(name + "/"));  // 没有文件，不需要文件的copy
                    zos.closeEntry();
                }
            } else {
                for (File file : listFiles) {
                    // 判断是否需要保留原来的文件结构
                    if (KeepDirStructure) {
                        // 注意：file.getName()前面需要带上父文件夹的名字加一斜杠,
                        // 不然最后压缩包中就不能保留原来的文件结构,即：所有文件都跑到压缩包根目录下了
                        compress(file, zos, name + "/" + file.getName(), KeepDirStructure);
                    } else {
                        compress(file, zos, file.getName(), KeepDirStructure);
                    }
                }
            }
        }
    }


    /**
     * 目前的生成方式 - maven
     *
     * @param allJavaFtl
     * @param zipFileName
     * @return
     * @throws IOException
     */
    public static byte[] createFilesAndZip(AllJavaFtl allJavaFtl, String zipFileName) throws IOException {

        /**
         * 所有的文件统一处理
         */
        List<FtlJavaInterface> ftlJavaInterfaces = new ArrayList<>();
        ftlJavaInterfaces.add(allJavaFtl.getControllerFtl());
        ftlJavaInterfaces.add(allJavaFtl.getServiceImplFtl());
        ftlJavaInterfaces.add(allJavaFtl.getServiceFtl());
        ftlJavaInterfaces.add(allJavaFtl.getDaoFtl());
        ftlJavaInterfaces.add(allJavaFtl.getVoFtl());
        ftlJavaInterfaces.add(allJavaFtl.getMapperFtl());

        /**
         * 创建文件并写入数据
         */
        for (FtlJavaInterface ftlJavaInterface : ftlJavaInterfaces) {
            BufferedOutputStream outputStream = null;
            String dir = (tmpPath + ftlJavaInterface.getPackageName()).replace(".", "/");
            //创建文件夹
            new File(dir).mkdirs();
            File voFile = new File(dir + "/" + ftlJavaInterface.getFileName());
            voFile.createNewFile();
            outputStream = new BufferedOutputStream(new FileOutputStream(voFile));
            outputStream.write(ftlJavaInterface.getFreeMarkStr().getBytes());
            outputStream.flush();
            outputStream.close();

        }

        String targetZip = tmpPathTarget + zipFileName;
        new File(tmpPathTarget).mkdirs();
        /**
         * 打包压缩
         */
        File file = new File(targetZip);
        OutputStream outputStream = new FileOutputStream(file);
        ZipUtilHelper.toZip(tmpPath, outputStream, true);
        outputStream.flush();
        outputStream.close();

        byte[] bytes = org.apache.commons.io.FileUtils.readFileToByteArray(new File(targetZip));


        FileUtils.deleteDirectory(tmpPath);
        FileUtils.deleteDirectory(tmpPathTarget);

        return bytes;
    }

    /**
     * 目前的生成方式 maven的项目
     *
     * @param allJavaFtls -> 包含多个从vo到controller
     * @param zipFileName
     * @param operateDir  -> 用于存放临时文件夹的目录
     * @return
     * @throws IOException
     */
    public static void createFilesAndZipMavenDemoMaster(List<AllJavaFtl> allJavaFtls, String zipFileName, String operateDir) throws IOException {

        // ---> demoMaster
        String sourceMavenDirPath = GenerateJavaController.demoMasterDirPath;//maven项目地址的文件夹
        // ---> tmp/1580899138501/demoMaster/
        String targetOperateDirPath = tmpPath + operateDir + "/" + GenerateJavaController.demoMasterBasePackage + "/";//操作的目录
        // ---> tmp/1580899138501/src/main/java/
        String codeDirPath = targetOperateDirPath + "src/main/java/";//code存放的地址

        ZipUtilsJavaHelper.deal(allJavaFtls, sourceMavenDirPath, codeDirPath, targetOperateDirPath);
    }


    /**
     * 目前的生成方式 vue前端的项目
     *
     * @param allVueFtls  -> 包含多个从vue
     * @param zipFileName
     * @param operateDir  -> 用于存放临时文件夹的目录
     * @return
     * @throws IOException
     */
    public static void createFilesAndZipVueDemoWeb(List<AllVueFtl> allVueFtls, String zipFileName, String operateDir) throws IOException {

        // ---> demoWeb
        String sourceVueWebDirPath = GenerateVueController.demoWebDirPath;//maven项目地址的文件夹
        // ---> tmp/1580899138501/
        String codeDirPath = tmpPath + operateDir + "/";//code存放的地址
        // ---> tmp/1580899138501/demoWeb/
        String targetOperateDirPath = tmpPath + operateDir + "/" + GenerateVueController.demoWebDirPath + "/";//操作的目录

        ZipUtilsVueHelper.deal(allVueFtls, sourceVueWebDirPath, codeDirPath, targetOperateDirPath);
    }

    /**
     * 目前的生成方式 vue前端的项目
     *
     * @param allHtmlFtl  -> 包含多个从vue
     * @param zipFileName
     * @param operateDir  -> 用于存放临时文件夹的目录
     * @return
     * @throws IOException
     */
    public static void createFilesAndZipDemoHtml(AllHtmlFtl allHtmlFtl, String zipFileName, String operateDir) throws IOException {

        // ---> demoWeb
        String sourceHtmlDirPath = GenerateHtmlController.demoHtmlDirPath;//maven项目地址的文件夹
        // ---> tmp/1580899138501/
        String codeDirPath = tmpPath + operateDir + "/";//code存放的地址
        // ---> tmp/1580899138501/demoWeb/
        String targetOperateDirPath = tmpPath + operateDir + "/" + GenerateHtmlController.demoHtmlDirPath + "/";//操作的目录

        ZipUtilsHtmlHelper.deal(allHtmlFtl, sourceHtmlDirPath, codeDirPath, targetOperateDirPath);

    }


    /**
     * 删除临时目录并且返回字节
     */
    public static byte[] deleteAndReturnByte(String zipFileName, String tmpPathTarget, String tmpPath) throws IOException {
        String targetZip = tmpPathTarget + zipFileName;
        new File(tmpPathTarget).mkdirs();
        /**
         * 打包压缩
         */
        File file = new File(targetZip);
        OutputStream outputStream = new FileOutputStream(file);
        ZipUtilHelper.toZip(tmpPath, outputStream, true);
        outputStream.flush();
        outputStream.close();

        byte[] bytes = org.apache.commons.io.FileUtils.readFileToByteArray(new File(targetZip));


        FileUtils.deleteDirectory(tmpPath);
        FileUtils.deleteDirectory(tmpPathTarget);

        return bytes;
    }


    /**
     * 生成全部的前后端
     *
     * @param allHtmlFtl  -> 包含多个从vue
     * @param zipFileName
     * @param operateDir  -> 用于存放临时文件夹的目录
     * @return
     * @throws IOException
     */
    public static byte[] createFilesAndZipAll(List<AllJavaFtl> allJavaFtls, List<AllVueFtl> allVueFtls, AllHtmlFtl allHtmlFtl, String zipFileName, String operateDir) throws IOException {

        // ---> demoWeb
        String sourceHtmlDirPath = GenerateHtmlController.demoHtmlDirPath;//maven项目地址的文件夹
        // ---> tmp/1580899138501/
        String codeDirPath = tmpPath + operateDir + "/";//code存放的地址
        // ---> tmp/1580899138501/demoWeb/
        String targetOperateDirPath = tmpPath + operateDir + "/" + GenerateHtmlController.demoHtmlDirPath + "/";//操作的目录


        ZipUtilsHtmlHelper.deal(allHtmlFtl, sourceHtmlDirPath, codeDirPath, targetOperateDirPath);

        /**
         * 删除临时目录并且
         */
        byte[] bytes = ZipUtilHelper.deleteAndReturnByte(zipFileName, ZipUtilHelper.tmpPathTarget, ZipUtilHelper.tmpPath);


        return bytes;
    }


}