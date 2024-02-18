package pageMethods;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObjects.OrderConfirmationObjects;

public class OrderConfirmationMethods extends OrderConfirmationObjects {

	
	WebDriver driver;

	public OrderConfirmationMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ValidatedOrderComfirmation() throws InterruptedException {
		
		Thread.sleep(3000); 
		String OrderConfirmation = driver.findElement(OrderConfirmationObjects.orderCompleteText).getText();
		 String Text = "ORDER PLACED!";
		 Assert.assertEquals(OrderConfirmation, Text);
	}
	

	
}
