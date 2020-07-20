package interview.selenium.integrate.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * TestNG :
 *  1. mvn clean install
 *  2. mvn package -DskipTests
 *  3. mvn package -Dmaven.test.skip=true
 *  4. mvn test
 *  Tiers:
 *      Test Suit  -> Test Case  -> Test Method
 *      TestNg.xml -> Test Class -> @Test
 */
public class TestDemo {
    private static Logger logger = LoggerFactory.getLogger(TestDemo.class);
    WebDriver webDriver;
    @BeforeMethod
    public void setUp(){
        logger.info("@BeforeMethod");
        //C:\Users\jianzhong.Rong\Downloads\IEDriverServer_x64_3.150.1
        String path = "C:\\Users\\jianzhong.Rong\\Downloads\\chromedriver_win32_83\\chromedriver.exe";
//        String path = "C:\\Users\\jianzhong.Rong\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        webDriver.get("http://www.google.ca");

    }
    @Test
    public void getTitle(){
        String title = webDriver.getTitle();
        logger.info("Get Title {} ",title);
    }
    @Test
    public void sum(){
        logger.info("Sum Test");
        int a = 2; int b = 3;
        Assert.assertEquals(5, a+b);
    }

    @Test
    public void divid(){
        logger.info("Divid Test");
        int a = 2; int b = 3;
        Assert.assertEquals(1, b/a);
    }

    @AfterMethod
    public void tearDown(){
        logger.info("@AfterMethod");
    }
}
