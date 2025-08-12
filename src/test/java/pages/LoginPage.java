package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "username")
	WebElement usernameTextfield;
	
	@FindBy(name = "password")
	WebElement passwordTextfield;
	
	@FindBy(css="button[type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
	WebElement validationMessage;
	
	public HomePage doLogin(String username,String password)
	{
		usernameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		loginButton.click();
		return new HomePage(driver);
	}
	
	public Boolean invalidLogin(String username,String password)
	{
		usernameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		loginButton.click();
		if(validationMessage.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
