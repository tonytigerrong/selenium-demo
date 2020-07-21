package interview.selenium.integrate.test;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Selenium Server / Grid / Hub / Node / Client
 * Client(test code and logical) ====> Hub ====> Node ( OS/Browser )
 * For Hub: java -jar selenium-server-version.jar -role hub
 * For Node: java -jar selenium-server-version.jar -role webdriver -hub http://IP:4444/grid/register -port 5557
 */
public class GridTest {
    private static Logger logger = LoggerFactory.getLogger(GridTest.class);
    private RemoteWebDriver remoteWebDriver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jianzhong.Rong\\Downloads\\chromedriver_win32_83\\chromedriver.exe");
        DesiredCapabilities dc = new DesiredCapabilities();
        /**
         * As of version 77, ChromeDriver compares the requested platform name to the value returned by Chrome. For the Windows version of Chrome, this is "Windows NT". Chrome does not distinguish different Windows versions. ChromeDriver does a startsWith comparison, so this will match a request for "windows" or "any", but there is no way to match to Vista.
         * <should be WIN10, but only work when ANY>
         */
        dc.setPlatform(Platform.ANY); // should be WIN10, but not. If windows OS, use ANY
        dc.setBrowserName("chrome");
        remoteWebDriver = new RemoteWebDriver(new URL("http://192.168.2.18:5557/wd/hub"), dc);
        remoteWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        remoteWebDriver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        remoteWebDriver.manage().deleteAllCookies();

    }

    @AfterMethod
    public void tearDown() {
        remoteWebDriver.close();
    }

    @Test
    public void googleSearch() {
        remoteWebDriver.navigate().to("https://www.google.ca");
        WebElement inputSearch = remoteWebDriver.findElement(By.xpath("//form[@id='tsf']//div[@class='A8SBwf']//div[@class='a4bIc']/input[@role='combobox']"));
        inputSearch.sendKeys("Selenium Server Download");
        WebElement btnSearch = remoteWebDriver.findElement(By.xpath("/html//form[@id='tsf']//div[@class='A8SBwf']/div[@class='FPdoLc tfB0Bf']/center/input[@name='btnK']"));
        btnSearch.click();
    }
}
