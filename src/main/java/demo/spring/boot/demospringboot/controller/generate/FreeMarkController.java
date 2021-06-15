package demo.spring.boot.demospringboot.controller.generate;

import demo.spring.boot.demospringboot.framework.Response;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.GenerateFileJava;
import demo.spring.boot.demospringboot.parse.mysql.parse.vo.mysql.ftl.java.AllJavaFtl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping(value = "/freemark")
public class FreeMarkController {

    private static Logger LOGGER =
            LoggerFactory.getLogger(FreeMarkController.class);


    @GetMapping("/index")
    public String GenerateFile(Map<String, Object> map, @RequestParam(value = "dataBase") String dataBase,
                               @RequestParam(value = "ptableName") String ptableName,
                               @RequestParam(value = "basePackage") String basePackage) {
        Response response = new Response<>();
        try {
            AllJavaFtl allJavaFtl = GenerateFileJava.GenerateFile(dataBase, ptableName, basePackage);
            response.setContent(allJavaFtl);
            map.put("javaTable", allJavaFtl);
        } catch (Exception e) {
            map.put("e", e.toString());
            LOGGER.error("异常 ：{} ", e.getMessage(), e);
        }
        return "index";

    }
}
