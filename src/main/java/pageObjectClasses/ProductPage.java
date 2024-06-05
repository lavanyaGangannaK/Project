package pageObjectClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstarctComponents.AbstractComponents;

public class ProductPage extends AbstractComponents {
	WebDriver driver;
	public ProductPage(WebDriver driver) 
	{
      super(driver);
      this.driver=driver;
      PageFactory.initElements(driver, this);

	}

	@FindBy(css="#toast-container")
	WebElement toaster;
	@FindBy(css="div[class='card']")
	List<WebElement> products;
	By value =By.cssSelector("div[class='text-muted']");
	By value1=By.cssSelector("button[class='btn w-10 rounded']");
	
	public List<WebElement> getProductsList()
	{
		waitForElementToInvisible(toaster);
		return products;
	}
	
	public CartPage selectproduct(String product) throws InterruptedException
	{
		WebElement prod =getProductsList().stream().filter(s->s.findElement(value).getText().equalsIgnoreCase(product)).findFirst().orElse(null);
		 prod.findElement(value1).click();
		 waitForElementToInvisible(toaster);
		Thread.sleep(400);
		clickCartButton();
		return new CartPage(driver);
		
	}
	
	
	
}
