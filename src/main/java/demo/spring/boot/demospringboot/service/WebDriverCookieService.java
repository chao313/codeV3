package demo.spring.boot.demospringboot.service;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebDriverCookieService {


    private static Logger LOGGER = LoggerFactory.getLogger(WebDriverCookieService.class);

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

    //    https://www.linkedin.com/voyager/api/typeahead/hitsV2?keywords=%E4%B8%87%E5%BE%97&origin=GLOBAL_SEARCH_HEADER&q=blended
//    public static void test() {
//        PropertiesUtils.getProperty("linkedin.companyUrl");
//        String url = "https://www.linkedin.com/voyager/api/typeahead/hitsV2?keywords=xxx&origin=GLOBAL_SEARCH_HEADER&q=blended"
//        try {
////            authority:www.linkedin.com
////            x-restli-protocol-version:2.0.0
////            x-li-lang:zh_CN
////            user-agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36
////            x-li-page-instance:urn:li:page:d_flagship3_company;Stx9nYQ2RkGvz1g1AFmINg==
////                    accept:application/vnd.linkedin.normalized+json+2.1
////            csrf-token:ajax:8687130264130075351
////            x-li-track:{"clientVersion":"1.5.*","osName":"web","timezoneOffset":8,"deviceFormFactor":"DESKTOP","mpName":"voyager-web"}
////            sec-fetch-site:same-origin
////            sec-fetch-mode:cors
////            referer:https://www.linkedin.com/company/wind-information/
////            accept-encoding:gzip, deflate, br
////            accept-language:zh-CN,zh;q=0.9
////            cookie:JSESSIONID="ajax:8687130264130075351"; bcookie="v=2&8dd602af-b1ff-4cab-8a14-ec23a113b388"; bscookie="v=1&20191212142939f8f2cc3a-730c-4f3b-854c-e8f360bd9f15AQFPpD7sJnOOfhQ4qX96t8qkKGT8C-8W"; li_at=AQEDAS6PwqwAYoydAAABbvqD8NEAAAFvHpB00VEARBImVQG3QKlkWn4C3IKOwSgekRwUJMhcfsp6k8KUksZegbAG1UGUGewvgXHunVZf9DBBbbdRdzTIjwH5zvXD2a_O_9BrXDgvcsFJPYaoXaeaQ4Sr; sl=v=1&BMejJ; liap=true; li_cc=AQEyUA9wZC40XAAAAW76g_NyCLuu8dKvUSKj1iweBY5TSFIpCHQDojjoc80yhXnImheFfVXbE90B; lang=v=2&lang=zh-cn; _lipt=CwEAAAFu-oP4kYeqF57ltKi--p6iy4XJNjfYJoaA5zpEt8H2je_44STFC0ZjKm5k-fJxE0geDNXPtvCTK8Xz_RQv6Lk6s9Qtn_oIo7j7q65zgjhtd4SeKtBhCWJgHt1ZgynlPPVWRswq1NpcEcILJuoGlnu8UOMhB34BbhUzEay33IJ7rrb0ESzo4g; _guid=c130af38-5ef2-4673-9b83-4b162bf66965; UserMatchHistory=AQIw9Gw7yoA4xwAAAW76g_wTj3sq-RuBKTKhoPgv0p1UDazXdt5DwMKn2bjEqlj9AZVRp0a0B8qxVp9MrUckTCD-sEEQh6NpJipQl-fK8YS6ovpVsvAEjF0xNxXNS53Mnpe5NfU7bldcnvo__iLlHpfc51q8V10osyikuRZvcDA; AMCVS_14215E3D5995C57C0A495C55%40AdobeOrg=1; AMCV_14215E3D5995C57C0A495C55%40AdobeOrg=-1303530583%7CMCIDTS%7C18243%7CMCMID%7C51921270873544917530739660890870756029%7CMCAAMLH-1576765783%7C11%7CMCAAMB-1576765783%7C6G1ynYcLPuiQxYZrsz_pkqfLG9yMXBpb2zX5dvJdYQJzPXImdj0y%7CMCOPTOUT-1576168183s%7CNONE%7CMCCIDH%7C1333994819%7CvVersion%7C3.3.0; aam_uuid=52424837380377314900760231570763891062; spectroscopyId=673eee3a-fd56-4f26-a715-a91efa7b6cac; lidc="b=SB20:g=233:u=3:i=1576161027:t=1576241894:s=AQFzuAONJ5tPYkvfRoz9wUhKPInW0FWz"
////            HttpClientUtils.setHeader();
////            HttpClientUtils.doGet()
//
//        } catch (FileNotFoundException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public static List<String> dealDir() throws IOException {
        File file = ResourceUtils.getFile("classpath:city.json");
        List<String> result = new ArrayList<>();
        FileUtils.readLines(file).forEach(line -> {


            result.add(line);
        });
        return result;

    }

    private static WebDriver driver;

    static {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:chromedriver");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 设置系统属性
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        // 实例化ChromeDriver

    }

    public static String download() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        driver = new ChromeDriver();
        // 启动浏览器 打开百度
        driver.navigate().to("http://www.xianqihaotianmi.com/read/9078_5391023.html");
        WebElement element = driver.findElement(By.xpath("//a[text()='下一篇']"));
        String text = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[3]")).getText();
        stringBuffer.append(text);
        while (null != element) {
            LOGGER.info(":{}", stringBuffer.toString());
            element.click();
            element = driver.findElement(By.xpath("//a[text()='下一篇']"));
            String text2 = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[3]")).getText();
            stringBuffer.append(text2);
        }
        return stringBuffer.toString();

    }


}
