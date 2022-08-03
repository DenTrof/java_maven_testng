package tests.autopro_login_page;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int count = 0;
    private static  final int MAX_RETRY = 3;

    public boolean retry (ITestResult result) {
        if(count < MAX_RETRY) {
            count++;
            return true;
        } else {
            return false;
        }
    }
};
