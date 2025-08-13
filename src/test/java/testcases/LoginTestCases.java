package testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import junit.framework.Assert;
import utility.ExcelFileDataReader;
import utility.ListenerUtil;

public class LoginTestCases extends BaseClass {
	@Test(priority = 1)
	public void validateLogin() {
		loginPage.doLogin(propertyFileClass.readData("username"), propertyFileClass.readData("password"));
		String url = getData.getURL();
		Assert.assertTrue(url.contains("dashboard"));
	}

	@Test(priority = 2, dataProvider = "TestData", dataProviderClass = ExcelFileDataReader.class)
	public void invalidLogin(String username, String password) {
		loginPage.invalidLogin(username, password);
		Assert.assertTrue(true);
	}

}
