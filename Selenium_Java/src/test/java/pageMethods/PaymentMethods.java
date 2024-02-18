package pageMethods;

import org.openqa.selenium.WebDriver;

import pageObjects.PaymetnObjects;

public class PaymentMethods extends PaymetnObjects {
	
	WebDriver driver;

	public PaymentMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public void EnterCardDetails (String CardName, String CardNumber, String CardCVC, String CardM, String CardY) {
		
		driver.findElement(PaymetnObjects.cardName).sendKeys(CardName);
		driver.findElement(PaymetnObjects.cardNumber).sendKeys(CardNumber);
		driver.findElement(PaymetnObjects.cardCVC).sendKeys(CardCVC);
		driver.findElement(PaymetnObjects.cardMonth).sendKeys(CardM);
		driver.findElement(PaymetnObjects.cardYear).sendKeys(CardY);
		
	}
	
	public void CompleteOrder() {
		driver.findElement(PaymetnObjects.paymentButton).click();
	}

}
