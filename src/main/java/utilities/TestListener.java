package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult Result) {
        LogUtils.info("Start test case: " + Result.getMethod().getDescription());
        LogUtils.info("============================================================");
    }

    @Override
    public void onTestSuccess(ITestResult Result) {
        LogUtils.info("Test case status: PASSED");
        LogUtils.info("------------------------------------------------------------");
        LogUtils.info("");
    }

    @Override
    public void onTestFailure(ITestResult Result) {
        LogUtils.info("Test case status: FAILED");
        LogUtils.info("------------------------------------------------------------");
        LogUtils.info("");
    }

    @Override
    public void onTestSkipped(ITestResult Result) {
    }

    @Override
    public void onStart(ITestContext Result) {
    }

    @Override
    public void onFinish(ITestContext Result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
    }

}
