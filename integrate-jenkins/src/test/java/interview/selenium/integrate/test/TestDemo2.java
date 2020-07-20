package interview.selenium.integrate.test;

import interview.selenium.integrate.listener.Listener2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestDemo2 {

    private WebDriver webDriver;
    private EventFiringWebDriver eventHandler;
    @BeforeMethod
    public void setUp() {
        String path = "C:\\Users\\jianzhong.Rong\\Downloads\\chromedriver_win32_83\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();

        eventHandler = new EventFiringWebDriver(webDriver);
        Listener2 eventListener = new Listener2();
        eventHandler.register(eventListener);


    }

    @AfterMethod
    public void tearDown() {
        webDriver.close();
    }

    @Test
    public void loginFacebook() {
        eventHandler.get("https://www.facebook.com/");
        By usernameBy = By.xpath("//html[@id='facebook']//input[@id='email']");
        // Fluent wait demo
        FluentWait<WebDriver> fluentWait = new FluentWait<>(eventHandler);
        fluentWait.withTimeout(Duration.ofSeconds(10)) // sleep 10 secs
                .pollingEvery(Duration.ofSeconds(3)) // try every 3 secs
                .ignoring(NoSuchElementException.class);
        WebElement usernameInput = fluentWait.until(driver -> driver.findElement(usernameBy));
        usernameInput.sendKeys("tonyrong@2008.sina.com");
    }
}
