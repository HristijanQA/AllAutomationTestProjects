package pageMethods;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPageObjects;
import pageObjects.HomePageObjects;

public class CartPageMethod {

	WebDriver driver;

	public CartPageMethod(WebDriver driver) {
		this.driver = driver;
	}

	public void CartProceed() {

		driver.findElement(CartPageObjects.procced).click();
	}
}