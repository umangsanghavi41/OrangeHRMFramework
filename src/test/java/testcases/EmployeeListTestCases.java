package testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import junit.framework.Assert;

public class EmployeeListTestCases extends BaseClass {
	@BeforeMethod
	public void start()
	{
		homePage=loginPage.doLogin(propertyFileClass.readData("username"),propertyFileClass.readData("password"));
		pimPage=homePage.validatePIMLink();
		employeeList=pimPage.validateEmployeeListTab();
	}
  @Test(priority = 1)
  public void searchEmployee() 
  {
	  boolean result=employeeList.searchEmployee();
	  Assert.assertTrue(result);
  }
  @Test(priority = 2)
  public void validateRandomSearch()
  {
	  boolean result=employeeList.noRecordValidation();
	  Assert.assertTrue(result);
  }
}
