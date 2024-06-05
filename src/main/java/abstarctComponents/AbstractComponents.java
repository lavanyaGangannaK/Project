package abstarctComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
     this.driver=driver;
     PageFactory.initElements(driver, this);

	}
	
	//driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	public void waitForElementToInvisible(WebElement toaster)
	{
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(toaster));
	}
	
	public void clickCartButton()
	{
		cartButton.click();
	}

}
