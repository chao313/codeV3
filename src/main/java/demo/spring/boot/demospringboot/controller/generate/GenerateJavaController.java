package demo.spring.boot.demospringboot.controller.generate;

import demo.spring.boot.demospringboot.config.framework.Code;
import demo.spring.boot.demospringboot.config.framework.Response;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.GenerateFileJava;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java.AllJavaFtl;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 2018/4/6    Created by   juan
 */

@RestController
@RequestMapping(value = "/generate/java")
public class GenerateJavaController {

    private static Logger LOGGER =
            LoggerFactory.getLogger(GenerateJavaController.class);

    public static final String demoMasterBasePackage = "demoMaster";//这里是作为package存在的
    public static final String demoMasterDirPath = "demoMaster/";//这里是作为package存在的

    private static final String tmpPath = "tmp/";


    @ApiOperation(value = "生成code", notes = "生成code:需要提供" +
            "<br>1.数据库名称" +
            "<br>2.表务名" +
            "<br>3.包名称")
    @GetMapping("/generateFile")
    public Response<AllJavaFtl> GenerateFile(@ApiParam(value = "数据库名称", required = true) @RequestParam(value = "dataBase") String dataBase,
                                             @ApiParam(value = "表务名", required = true) @RequestParam(value = "ptableName") String ptableName,
                                             @ApiParam(value = "包名称", required = true) @RequestParam(value = "basePackage") String basePackage) {
        Response<AllJavaFtl> response = new Response<>();
        try {
            AllJavaFtl allJavaFtl = GenerateFileJava.GenerateFile(dataBase, ptableName, basePackage);
            response.setCode(Code.System.OK);
            response.setContent(allJavaFtl);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            LOGGER.error("异常 ：{} ", e.getMessage(), e);
        }
        return response;

    }


    /**
     * 注意->这里的下载目前通过swagger-ui的url是不行的，但是通过url直接访问是可以的
     *
     * @param dataBase
     * @param ptableName
     * @param basePackage
     * @return
     * @throws Exception
     */
    @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownLoad(@RequestParam(value = "dataBase") String dataBase,
                                               @RequestParam(value = "ptableName") String ptableName,
                                               @RequestParam(value = "basePackage") String basePackage) throws Exception {

        AllJavaFtl allJavaFtl = GenerateFileJava.GenerateFile(dataBase, ptableName, basePackage);
        String fileNameZip = new Date().getTime() + ".zip";
        byte[] body = ZipUtils.createFilesAndZip(allJavaFtl, fileNameZip);

        HttpHeaders headers = new HttpHeaders();//设置响应头
        headers.add("Content-Disposition", "attachment;filename=" + fileNameZip);//下载的文件名称
        HttpStatus statusCode = HttpStatus.OK;//设置响应吗
        ResponseEntity<byte[]> response = new ResponseEntity<>(body, headers, statusCode);
        return response;
    }


    /**
     * 注意->这里的下载目前通过swagger-ui的url是不行的，但是通过url直接访问是可以的
     *
     * @param dataBase
     * @param ptableName
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "单表下载", notes = "注意->这里的下载目前通过swagger-ui的url是不行的，但是通过url直接访问是可以的")
    @GetMapping("/downloadMavenDemoMaster")
    public ResponseEntity<byte[]> downloadMavenDemoMaster(@RequestParam(value = "dataBase") String dataBase,
                                                          @RequestParam(value = "ptableName") String ptableName) throws Exception {
        String basePackage = demoMasterBasePackage;
        AllJavaFtl allJavaFtl = GenerateFileJava.GenerateFile(dataBase, ptableName, basePackage);
        String operateDir = String.valueOf(new Date().getTime());
        String fileNameZip = operateDir + ".zip";
        ZipUtils.createFilesAndZipMavenDemoMaster(Arrays.asList(allJavaFtl), fileNameZip, operateDir);

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

    /**
     * 注意->这里的下载目前通过swagger-ui的url是不行的，但是通过url直接访问是可以的
     * 这里兼容了多个table的情况
     *
     * @param dataBase
     * @param ptableNames
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "多表生成", notes = "注意->这里的下载目前通过swagger-ui的url是不行的，但是通过url直接访问是可以的")
    @GetMapping("/downloadMavenDemoMasterMoreTables")
    public ResponseEntity<byte[]> downloadMavenDemoMasterMoreTables(
            @ApiParam(example = "docker2") @RequestParam(value = "dataBase") String dataBase,
            @ApiParam(example = "t_host,t_user") @RequestParam(value = "ptableNames") List<String> ptableNames) throws Exception {

        String basePackage = demoMasterBasePackage;
        List<AllJavaFtl> allJavaFtls = new ArrayList<>();
        for (String ptableName : ptableNames) {
            AllJavaFtl allJavaFtl = GenerateFileJava.GenerateFile(dataBase, ptableName, basePackage);
            allJavaFtls.add(allJavaFtl);
        }
        String operateDir = String.valueOf(new Date().getTime());
        String fileNameZip = operateDir + ".zip";
        ZipUtils.createFilesAndZipMavenDemoMaster(allJavaFtls, fileNameZip, operateDir);

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
