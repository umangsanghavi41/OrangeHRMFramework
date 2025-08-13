package testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass.BaseClass;

public class HomePageTestCases extends BaseClass {
	@BeforeMethod
	public void start()
	{
		homePage=loginPage.doLogin(propertyFileClass.readData("username"),propertyFileClass.readData("password"));
	}
  @Test(priority=1)
  public void validateLogout() 
  {
	  homePage.validateLogout();
	  String url=getData.getURL();
	  Assert.assertTrue(url.contains("login"));
  }
  @Test(priority=2)
  public void validatePIMLink()
  {
	  homePage.validatePIMLink();
	  String url=getData.getURL();
	  Assert.assertTrue(url.contains("pim"));
  }
}
