package pageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstarctComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {

	 WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement pwd;
	
	@FindBy(id="login")
	WebElement submit_button;
	
	
	public void goTO()
	{
		driver.get("https://rahulshettyacademy.com/client/");	
	}
	public ProductPage loginToAPP(String email_id, String password)
	{
		email.sendKeys(email_id);
		pwd.sendKeys(password);
		submit_button.click();
		return  new ProductPage(driver);
	}
	
}
