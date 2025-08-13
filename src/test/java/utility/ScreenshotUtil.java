package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;

public class ScreenshotUtil {
	private WebDriver driver;
	public ScreenshotUtil(WebDriver driver)
	{
		this.driver=driver;
	}
	public void captureScreenshot(String testName)
	{
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		String timestamp=new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		File temporary=takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir") + "\\Screenshots\\" + testName + "_" + timestamp+ ".png");
		try {
			FileUtils.copyFile(temporary, destination);
		} catch (IOException e) {
			System.out.println("No file found");
		}
	}

}
