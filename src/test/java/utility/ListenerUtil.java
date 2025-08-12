package utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerUtil implements ITestListener
{
	private WebDriver driver;
	public ListenerUtil(WebDriver driver)
	{
		this.driver=driver;
	}
	@Override
	public void onTestFailure(ITestResult iTestResult)
	{
		ScreenshotUtil screenshotUtil=new ScreenshotUtil(driver);
		screenshotUtil.captureScreenshot();
	}
}
