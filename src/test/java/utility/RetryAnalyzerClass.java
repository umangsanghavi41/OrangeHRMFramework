package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerClass implements IRetryAnalyzer {
	private int retryCount=0;
	private static int maxRetryCount=2;
	
	@Override
	public boolean retry(ITestResult arg0) {
		if(retryCount<maxRetryCount)
		{
			retryCount++;
			return true;
		}
		return false;
	}	
}
