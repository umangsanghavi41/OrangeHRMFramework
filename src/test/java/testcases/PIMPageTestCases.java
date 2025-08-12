package testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import junit.framework.Assert;

public class PIMPageTestCases extends BaseClass{
	@BeforeMethod
	public void start()
	{
		homePage=loginPage.doLogin(propertyFileClass.readData("username"),propertyFileClass.readData("password"));
		pimPage=homePage.validatePIMLink();
	}
  @Test
  public void validateAddEmployeeTab()
  {
	  pimPage.validateAddEmployeeTab();
	  String url=getData.getURL();
	  Assert.assertTrue(url.contains("addEmployee"));
  }
}
