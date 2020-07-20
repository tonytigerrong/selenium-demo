package interview.selenium.integrate.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Listener2 implements WebDriverEventListener {
    private static Logger logger = LoggerFactory.getLogger(Listener2.class);
    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        logger.info("on beforeAlertAccept {}",webDriver);
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        logger.info("on afterAlertAccept {}",webDriver);
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        logger.info("on afterAlertDismiss {}",webDriver);
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        logger.info("on beforeAlertDismiss {}",webDriver);
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        logger.info("on beforeNavigateTo {}",webDriver);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        logger.info("on afterNavigateTo {}",webDriver);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        logger.info("on beforeNavigateBack {}",webDriver);
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        logger.info("on afterNavigateBack {}",webDriver);
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        logger.info("on beforeNavigateForward {}",webDriver);
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        logger.info("on afterNavigateForward {}",webDriver);
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        logger.info("on beforeNavigateRefresh {}",webDriver);
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        logger.info("on afterNavigateRefresh {}",webDriver);
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("on beforeFindBy {}",webElement);
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("on afterFindBy {}",webElement);
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("on beforeClickOn {}",webElement);
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("on afterClickOn {}",webElement);
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        logger.info("on beforeChangeValueOf {}",webElement);
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        logger.info("on afterChangeValueOf {}",webElement);
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        logger.info("on beforeScript {}",webDriver);
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        logger.info("on afterScript {}",webDriver);
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        logger.info("on beforeSwitchToWindow {}",webDriver);
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        logger.info("on afterSwitchToWindow {}",webDriver);
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        logger.info("on onException {}",webDriver);
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        logger.info("on beforeGetScreenshotAs {}",outputType);
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        logger.info("on afterGetScreenshotAs {}",outputType);
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        logger.info("on beforeGetText {}",webElement);
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        logger.info("on afterGetText {}",webElement);
    }
}
