package interview.selenium.integrate.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * --------------------------------------------
 * TestNG :
 * 1. mvn clean install
 * 2. mvn package -DskipTests
 * 3. mvn package -Dmaven.test.skip=true
 * 4. mvn test
 *---------------------------------------------
 * Tiers:
 * Test Suit  -> Test Case  -> Test Method
 * TestNg.xml -> Test Class -> @Test
 *--------------------------------------------
 * Implicit vs Explicit wait
 * --------------------------------------------
 */
public class TestDemo {
    private static Logger logger = LoggerFactory.getLogger(TestDemo.class);
    WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        logger.info("@BeforeMethod");
        String path = "C:\\Users\\jianzhong.Rong\\Downloads\\chromedriver_win32_83\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        // implicit wait : wait time between two test/step
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void loginGmail() {
        webDriver.get("http://gmail.com");
        WebElement emailInput = webDriver.findElement(By.xpath("/html//input[@id='identifierId']"));
        emailInput.sendKeys("rjianzhong78@gmail.com");
        // define Explicit wait
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        String loginBtnXpath = "//div[@id='identifierNext']//button[@type='button']/div[@class='VfPpkd-RLmnJb']";
        // wait 30 sec until loginBtn show up and click-able
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginBtnXpath)));
        WebElement loginBtn = webDriver.findElement(By.xpath(loginBtnXpath));
        loginBtn.click();
        logger.info("Login Gmail Successfully");
    }

    @AfterMethod
    public void tearDown() {
        logger.info("@AfterMethod");
        webDriver.close();
    }
}
