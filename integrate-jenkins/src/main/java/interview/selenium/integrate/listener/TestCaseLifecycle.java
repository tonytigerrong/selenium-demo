package interview.selenium.integrate.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * sequence of invocation:
 * 1. onStart
 * 2. @BeforeMethod
 * 3. onTestStart
 * 4. onTestSuccess / onTestFailure
 * 5. @AfterMethod
 * 6. onFinish
 */
public class TestCaseLifecycle implements ITestListener {
    private static Logger logger = LoggerFactory.getLogger(TestCaseLifecycle.class);
    @Override
    public void onTestStart(ITestResult result) {
        logger.info("In 'OnTestStart': {}",result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("In 'onTestSuccess': {}",result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("In 'onTestFailure': {}",result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("In 'onTestSkipped': {}",result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info("In 'onTestFailedButWithinSuccessPercentage': {}",result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        logger.info("In 'onTestFailedWithTimeout': {}",result);
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("In 'onStart': {}",context);
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("In 'onFinish': {}",context);
    }
}
