package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".oxd-userdropdown-name")
	WebElement userDropdown;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutLink;
	
	@FindBy(xpath = "(//span[contains(@class,'oxd-main-menu-item--name')])[2]")
	WebElement PIMLink;
	
	public LoginPage validateLogout()
	{
		userDropdown.click();
		logoutLink.click();
		return new LoginPage(driver);
	}
	
	public PIMPage validatePIMLink()
	{
		PIMLink.click();
		return new PIMPage(driver);
	}
}
