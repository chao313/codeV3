package demo.spring.boot.demospringboot.controller.generate;

import demo.spring.boot.demospringboot.framework.Response;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.GenerateFileHtml;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.GenerateFileJava;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.GenerateFileVue;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.html.AllHtmlFtl;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java.AllJavaFtl;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.vue.AllVueFtl;
import demo.spring.boot.demospringboot.util.ZipUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 2018/4/6    Created by   juan
 */

@RestController
@RequestMapping(value = "/generate/html")
public class GenerateHtmlController {

    private static Logger LOGGER =
            LoggerFactory.getLogger(GenerateHtmlController.class);

    public static final String demoMasterBasePackage = "demoHtml";//这里是作为package存在的
    public static final String demoHtmlDirPath = "demoHtml/";//项目路径

    private static final String tmpPath = "tmp/";


    /**
     * 注意->这里的下载目前通过swagger-ui的url是不行的，但是通过url直接访问是可以的
     * 这里兼容了多个table的情况
     *
     * @param dataBase
     * @param ptableNames
     * @return
     * @throws Exception
     */
    @GetMapping("/generateDemoHtmlMoreTables")
    public Response generateDemoHtmlMoreTables(
            @ApiParam(example = "docker2") @RequestParam(value = "dataBase") String dataBase,
            @ApiParam(example = "t_host,t_user") @RequestParam(value = "ptableNames") List<String> ptableNames) throws Exception {

        Response response = new Response();
        List<AllJavaFtl> allJavaFtls = new ArrayList<>();//存放所有的Java code -> controller
        /**
         * 这里由于是单个的 -> 现在分开
         */
        String basePackage = demoMasterBasePackage;
        for (String ptableName : ptableNames) {
            AllJavaFtl allJavaFtl = GenerateFileJava.GenerateFile(dataBase, ptableName, basePackage);
            allJavaFtls.add(allJavaFtl);
        }

        List<AllVueFtl> allVueFtls = new ArrayList<>();
        for (AllJavaFtl allJavaFtl : allJavaFtls) {
            AllVueFtl allVueFtl = GenerateFileVue.GenerateFile(allJavaFtl, allJavaFtls);
            allVueFtls.add(allVueFtl);
        }
        AllHtmlFtl allHtmlFtl = GenerateFileHtml.GenerateFile(allVueFtls);
        response.setContent(allHtmlFtl);
        return response;
    }


    /**
     * 注意->这里的下载目前通过swagger-ui的url是不行的，但是通过url直接访问是可以的
     * 这里兼容了多个table的情况
     *
     * @param dataBase
     * @param ptableNames
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "注意->这里的下载目前通过swagger-ui的url是不行的，但是通过url直接访问是可以的")
    @GetMapping("/downloadDemoHtmlMoreTables")
    public ResponseEntity<byte[]> downloadDemoHtmlMoreTables(
            @ApiParam(example = "docker2") @RequestParam(value = "dataBase") String dataBase,
            @ApiParam(example = "t_host,t_user") @RequestParam(value = "ptableNames") List<String> ptableNames) throws Exception {


        List<AllJavaFtl> allJavaFtls = new ArrayList<>();//存放所有的Java code -> controller
        /**
         * 这里由于是单个的 -> 现在分开
         */
        String basePackage = demoMasterBasePackage;
        for (String ptableName : ptableNames) {
            AllJavaFtl allJavaFtl = GenerateFileJava.GenerateFile(dataBase, ptableName, basePackage);
            allJavaFtls.add(allJavaFtl);
        }

        List<AllVueFtl> allVueFtls = new ArrayList<>();
        for (AllJavaFtl allJavaFtl : allJavaFtls) {
            AllVueFtl allVueFtl = GenerateFileVue.GenerateFile(allJavaFtl, allJavaFtls);
            allVueFtls.add(allVueFtl);
        }
        AllHtmlFtl allHtmlFtl = GenerateFileHtml.GenerateFile(allVueFtls);

        String operateDir = String.valueOf(new Date().getTime());
        String fileNameZip = operateDir + ".zip";
        ZipUtils.createFilesAndZipDemoHtml(allHtmlFtl, fileNameZip, operateDir);
        /**
         * 删除临时目录并返回压缩后的字节
         */
        byte[] body = ZipUtils.deleteAndReturnByte(fileNameZip, ZipUtils.tmpPathTarget, ZipUtils.tmpPath);

        HttpHeaders headers = new HttpHeaders();//设置响应头
        headers.add("Content-Disposition", "attachment;filename=" + fileNameZip);//下载的文件名称
        HttpStatus statusCode = HttpStatus.OK;//设置响应吗
        ResponseEntity<byte[]> response = new ResponseEntity<>(body, headers, statusCode);
        return response;
    }


}
