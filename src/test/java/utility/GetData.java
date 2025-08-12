package utility;

import org.openqa.selenium.WebDriver;

public class GetData {
	private WebDriver driver;
	public GetData(WebDriver driver)
	{
		this.driver=driver;
	}
	public String getURL()
	{
		return driver.getCurrentUrl();
	}
	public String getTitle()
	{
		return driver.getTitle();
	}
}
