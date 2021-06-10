package demo.spring.boot.demospringboot.util;

import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.FtlHtmlInterface;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.html.AllHtmlFtl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ZipUtilsHtml {

    /**
     * @param allHtmlFtl
     * @param sourceHtmlDirPath
     * @param codeDirPath
     * @param targetOperateDirPath
     * @throws IOException
     */
    public static void deal(AllHtmlFtl allHtmlFtl, String sourceHtmlDirPath, String codeDirPath, String targetOperateDirPath) throws IOException {
        /**
         * 1.把html项目复制到操作目录下
         */
        File sourceHtmlDir = new File(sourceHtmlDirPath);
        sourceHtmlDir.mkdirs();//创建文件夹
        File targetOperateDir = new File(targetOperateDirPath);
        org.apache.commons.io.FileUtils.copyDirectory(sourceHtmlDir, targetOperateDir);//项目复制到目标文件夹下

        /**
         * 所有的文件统一处理
         */
        List<FtlHtmlInterface> ftlHtmlInterfaces = new ArrayList<>();
        ftlHtmlInterfaces.add(allHtmlFtl.getDataJsFtl());


        /**
         * 创建文件并写入数据
         */
        for (FtlHtmlInterface ftlVueInterface : ftlHtmlInterfaces) {
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
