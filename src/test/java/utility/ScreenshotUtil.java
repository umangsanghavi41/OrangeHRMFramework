package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	private WebDriver driver;
	public ScreenshotUtil(WebDriver driver)
	{
		this.driver=driver;
	}
	public void captureScreenshot()
	{
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File temporary=takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir") + "\\Screenshots");
		try {
			FileUtils.copyFile(temporary, destination);
		} catch (IOException e) {
			System.out.println("No file found");
		}
	}

}
