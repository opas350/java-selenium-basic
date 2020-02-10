package academy.basic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryInit implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetry = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetry){
            retryCount++;
            System.out.println("Retrying Test method: " + result.getName() + " For " + retryCount + " times");
            return true;
        }
        return false;
    }
}
