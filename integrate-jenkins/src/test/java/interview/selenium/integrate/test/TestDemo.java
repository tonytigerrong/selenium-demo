package interview.selenium.integrate.test;


import interview.selenium.integrate.listener.TestCaseLifecycle_Testng_listener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
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
 * Implicit wait vs Explicit wait                vs Fluent wait
 * Thread.sleep  vs util expected condition meet vs Thread.sleep + try interval
 * --------------------------------------------
 *
 * integrate with Jenkins
 * 1. run jenkins by administrator
 * 2. create new item of maven project
 *  2.1 set up git/maven(mvn clean install -DskipTests)
 *  2.2 set up git username / password
 * 3. build now the item
 * ISSUES: can't run test by mvn test, or build by 'mvn clean install', have to skip test
 *         test execution blocked on 'onStart'
 */
@Listeners(TestCaseLifecycle_Testng_listener.class)
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

    @Test(priority = 1, groups = "Demo0")
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

    @Test(priority = 2, dependsOnMethods = "loginGmail", groups = "Demo0")
    public void loginFacebook(){
        webDriver.get("https://www.facebook.com/");
        By usernameBy = By.xpath("//html[@id='facebook']//input[@id='email']");
        // Fluent wait demo
        FluentWait<WebDriver> fluentWait = new FluentWait<>(webDriver);
        fluentWait.withTimeout(Duration.ofSeconds(10)) // sleep 10 secs
                  .pollingEvery(Duration.ofSeconds(3)) // try every 3 secs
                  .ignoring(NoSuchElementException.class);
        WebElement usernameInput = fluentWait.until(driver -> driver.findElement(usernameBy));
        usernameInput.sendKeys("tonyrong@2008.sina.com");


    }
    @AfterMethod
    public void tearDown() {
        logger.info("@AfterMethod");
        webDriver.close();
    }
}
