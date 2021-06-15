package demo.spring.boot.demospringboot.service;

import demo.spring.boot.demospringboot.controller.generate.LinkedinController;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class WebDriverService {


    private static Logger LOGGER = LoggerFactory.getLogger(WebDriverService.class);

    public static void test() {
        try {
            File file = ResourceUtils.getFile("classpath:chromedriver");
            // 设置系统属性
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
            // 实例化ChromeDriver
            WebDriver driver = new ChromeDriver(options);


            // 启动浏览器 打开百度
            driver.navigate().to("https://www.linkedin.com/login");

            ChromeDriver chromeDriver = ((ChromeDriver) driver);
            //输入查询的wd
            chromeDriver.findElementById("username").sendKeys("15618622161");
            //点击查询
            chromeDriver.findElementById("password").sendKeys("Ys20140913");
            //点击登陆
            chromeDriver.findElement(By.xpath("//button[text()='登录']")).click();

            //搜索万得
            chromeDriver.findElementByClassName("search-global-typeahead__input").sendKeys("万得");
            Thread.sleep(800);
            chromeDriver.getKeyboard().sendKeys(Keys.DOWN);
            Thread.sleep(800);
            chromeDriver.getKeyboard().sendKeys(Keys.ENTER);

            //点击 查看领英上的全部...
            Thread.sleep(1000);
            chromeDriver.findElement(By.xpath("//span[contains(text(),'查看领英上的全部')]")).click();
            Thread.sleep(1000);
            //点击 全部筛选条件
            chromeDriver.findElement(By.xpath("//span[text()='全部筛选条件']")).click();
            Thread.sleep(1000);
            //设置职位 -> cp
            chromeDriver.findElementById("search-advanced-title").sendKeys("ceo");
            Thread.sleep(1000);
            //点击 确定
            chromeDriver.findElement(By.xpath("//span[text()='确定']")).click();
            Thread.sleep(1000);
            String text = chromeDriver.findElement(By.xpath("//div[@class='display-flex']")).getText();
            LOGGER.info("text:{}", text);


        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
