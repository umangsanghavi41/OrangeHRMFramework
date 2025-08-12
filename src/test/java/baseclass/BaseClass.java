package baseclass;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AddEmployeePage;
import pages.EmployeeList;
import pages.HomePage;
import pages.LoginPage;
import pages.PIMPage;
import utility.GetData;
import utility.ListenerUtil;
import utility.PropertyFileClass;
import utility.ScreenshotUtil;

public class BaseClass {
	protected WebDriver driver;
	public LoginPage loginPage;
	public PropertyFileClass propertyFileClass;
	public GetData getData;
	public HomePage homePage;
	public PIMPage pimPage;
	public AddEmployeePage addEmployeePage;
	public EmployeeList employeeList;
	public ListenerUtil listenerUtil;
	public ScreenshotUtil screenshotUtil;
	@BeforeMethod
	public void setup()
	{
		ChromeOptions chromeOptions=new ChromeOptions();
		Map<String,Object> preferences=new HashMap<>();
		preferences.put("profile.password_manager_leak_detection",false);
		chromeOptions.setExperimentalOption("prefs", preferences);	
		driver=new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		propertyFileClass=new PropertyFileClass();
		loginPage=new LoginPage(driver);
		getData=new GetData(driver);
		homePage=new HomePage(driver);
		pimPage=new PIMPage(driver);
		addEmployeePage=new AddEmployeePage(driver);
		listenerUtil=new ListenerUtil(driver);
		screenshotUtil=new ScreenshotUtil(driver);
		employeeList=new EmployeeList(driver);
		driver.get(propertyFileClass.readData("url"));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@AfterMethod
	public void captureScreenshot(ITestResult iTestResult)
	{
		if(driver!=null)
		{
		if(ITestResult.FAILURE==iTestResult.getStatus())
		{
			ScreenshotUtil screenshotUtil=new ScreenshotUtil(driver);
			screenshotUtil.captureScreenshot();
		}
	}
}
}