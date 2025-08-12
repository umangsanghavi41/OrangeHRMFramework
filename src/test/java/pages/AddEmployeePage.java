package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import utility.JavaFakerClass;

public class AddEmployeePage {
	private WebDriver driver;
	public AddEmployeePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "firstName")
	WebElement firstNameTextfield;
	
	@FindBy(name="lastName")
	WebElement lastNameTextfield;
	
	@FindBy(css = "button[type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "(//h6[contains(@class,'orangehrm-main-title')])[1]")
	WebElement personalDetailsHeading;
	
	public boolean addEmployee()
	{
		String fname=JavaFakerClass.firstName();
		firstNameTextfield.sendKeys(fname);
		System.out.println(fname);
		String lname=JavaFakerClass.lastName();
		lastNameTextfield.sendKeys(lname);
		System.out.println(lname);
		submitButton.click();		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(personalDetailsHeading));
		return personalDetailsHeading.isDisplayed();
	}
}
