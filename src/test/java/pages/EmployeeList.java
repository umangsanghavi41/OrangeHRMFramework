package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeList {
	private WebDriver driver;
	public EmployeeList(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'oxd-table-row')])[4]//div[contains(@class,'oxd-padding-cell')][3]")
	WebElement texttoFetch;
	
	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
	WebElement nameTextField;
	
	@FindBy(xpath = "(//div[contains(@class,'oxd-table-cell')])[3]")
	WebElement resultText;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;
	
	@FindBy(xpath = "//span[text()='No Records Found']")
	WebElement noRecordsFoundText;
	
	public boolean searchEmployee()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(texttoFetch));
		String name=texttoFetch.getText();
		nameTextField.sendKeys(name);
		searchButton.click();
		String expectedName=resultText.getText();
		return expectedName.equals(name);
	}
	
	public boolean noRecordValidation()
	{
		nameTextField.sendKeys("random");
		searchButton.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(noRecordsFoundText));
		return noRecordsFoundText.isDisplayed();
	}

}
