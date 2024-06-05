package baseComponents;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectClasses.LoginPage;
public class BaseComponents {
	public WebDriver driver;
	public static LoginPage lp;
	
	public WebDriver launchbrowser() throws IOException
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		 String browserName =prop.getProperty("browser");
		 if(browserName.equalsIgnoreCase("chrome"))
		 {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 }
		 else
		 {
			 WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver(); 
		 }
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		 driver.manage().window().maximize();
		 
		 return driver;
	}
	
	public String getscreenshotoffailedCase(String testcaseName,WebDriver driver) throws IOException
	{
		String path =System.getProperty("user.dir")+"\\reports" +testcaseName+ "\\.png";
		TakesScreenshot src= (TakesScreenshot)driver;
		File source =src.getScreenshotAs(OutputType.FILE);
		File des=new File(path);
		FileUtils.copyFile(source, des);
		return path;
		
	}
	
	@BeforeMethod
	public LoginPage openBrowser() throws IOException
	{
		driver =launchbrowser();
		lp=new LoginPage(driver);
		lp.goTO();
		return lp;
	}
	@AfterMethod
	public void closingbrowser()
	{
		driver.close();
	}

}
