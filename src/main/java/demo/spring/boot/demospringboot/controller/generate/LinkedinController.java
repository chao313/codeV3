package demo.spring.boot.demospringboot.controller.generate;

import demo.spring.boot.demospringboot.config.DemoEventListenter;
import demo.spring.boot.demospringboot.framework.Code;
import demo.spring.boot.demospringboot.framework.Response;
import demo.spring.boot.demospringboot.service.WebDriverCookieService;
import demo.spring.boot.demospringboot.service.WebDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/linkedin")
public class LinkedinController {


    private static Logger LOGGER = LoggerFactory.getLogger(LinkedinController.class);

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/publishEvent")
    public Response publishEvent() {
        /**
         * 创建事件
         */
        DemoEventListenter demoEventListenter = new DemoEventListenter();
        DemoEventListenter.DemoEvent demoEvent = demoEventListenter.new DemoEvent(this, "此次发送msg");
        /**
         * 发布事件
         */
        applicationContext.publishEvent(demoEvent);
        return Response.OK();
    }


    @GetMapping("/test")
    public Response test() {
        Response response = new Response<>();
        LOGGER.info("Thread:{}", Thread.currentThread());
        Thread.currentThread().getThreadGroup();
        try {
            WebDriverService.test();
            response.setCode(Code.System.OK);
            response.setContent("");
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            LOGGER.error("异常 ：{} ", e.getMessage(), e);
        }
        return response;

    }

    @GetMapping("/testCookie")
    public Response testCookie() {
        Response response = new Response<>();
        try {
            WebDriverCookieService.test();
            response.setCode(Code.System.OK);
            response.setContent("");
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            LOGGER.error("异常 ：{} ", e.getMessage(), e);
        }
        return response;

    }

    @GetMapping("/dealDir")
    public Response dealDir() {
        Response response = new Response<>();
        try {
            List<String> strings = WebDriverCookieService.dealDir();
            response.setCode(Code.System.OK);
            response.setContent(strings);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            LOGGER.error("异常 ：{} ", e.getMessage(), e);
        }
        return response;

    }

    @GetMapping("/download")
    public Response download() {
        Response response = new Response<>();
        try {
            String string = WebDriverCookieService.download();
            LOGGER.error(":{}", string);
            response.setCode(Code.System.OK);
            response.setContent(string);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            LOGGER.error("异常 ：{} ", e.getMessage(), e);
        }
        return response;

    }


}
