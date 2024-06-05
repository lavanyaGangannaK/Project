package testcase;

import org.testng.annotations.Test;

import baseComponents.BaseComponents;
import pageObjectClasses.CartPage;
import pageObjectClasses.ProductPage;

public class Demo1 extends BaseComponents{

	   @Test
	 	public void test2() throws InterruptedException {
			
			ProductPage pp=lp.loginToAPP("john20241@gmail.com", "John@123");
			CartPage cp=pp.selectproduct("$ 231500");
		    cp.proceedToCheckout();
		}


}
