package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {
	private WebDriver driver;
	public PIMPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//a[@class='oxd-topbar-body-nav-tab-item'])[2]")
	WebElement addEmployeeTab;
	
	@FindBy(xpath = "(//a[@class='oxd-topbar-body-nav-tab-item'])[1]")
	WebElement employeeListTab;
	
	public AddEmployeePage validateAddEmployeeTab()
	{
		addEmployeeTab.click();
		return new AddEmployeePage(driver);
	}
	public EmployeeList validateEmployeeListTab()
	{
		employeeListTab.click();
		return new EmployeeList(driver);
	}

}
