package pageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstarctComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;
	public CartPage(WebDriver driver) 
	{
		super(driver);
	      this.driver=driver;
	      PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.cssSelector("div[class*='star-inserted'] button")).click();
	
	@FindBy(css="div[class*='star-inserted'] button")
	WebElement checkoutButton;
	
	public void proceedToCheckout()
	{
		checkoutButton.click();
	}

}
