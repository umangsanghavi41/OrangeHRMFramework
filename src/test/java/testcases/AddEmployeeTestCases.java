package testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass.BaseClass;

public class AddEmployeeTestCases extends BaseClass{
	@BeforeMethod
	public void start()
	{
		homePage=loginPage.doLogin(propertyFileClass.readData("username"),propertyFileClass.readData("password"));
		pimPage=homePage.validatePIMLink();
		addEmployeePage=pimPage.validateAddEmployeeTab();
	}
  @Test
  public void validateAddEmployee() 
  {
	  boolean result=addEmployeePage.addEmployee();
	  System.out.println(result);
	  Assert.assertTrue(result);
  }
}
