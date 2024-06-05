package testcase;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseComponents.BaseComponents;
import pageObjectClasses.CartPage;
import pageObjectClasses.ProductPage;

public class Case1 extends BaseComponents {

	@Test(dataProvider="data")
	public void test1(HashMap<String,String> data) throws InterruptedException {
		
		ProductPage pp=lp.loginToAPP(data.get("email"),data.get("pwd"));
		CartPage cp=pp.selectproduct("$ 231500");
	    cp.proceedToCheckout();

	}
	
	@DataProvider(name="data")
	public Object[][] getdata()
	{
		//return new Object[][]{{"opentext123@gmail.com","Opentext@123"},{"john2024@gmail.com","John@123"}};
		HashMap<String,String> data = new HashMap<String,String>();
		data.put("email", "opentext123@gmail.com");
		data.put("pwd", "Opentext@123");
		return new Object[][]{{data}};
	}
	


}
