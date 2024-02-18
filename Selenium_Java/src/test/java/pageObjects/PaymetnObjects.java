package pageObjects;

import org.openqa.selenium.By;

public class PaymetnObjects {
	
	
		public static By cardName = By.xpath("//input[@data-qa='name-on-card']");
		public static By cardNumber = By.xpath("//input[@data-qa='card-number']");
		public static By cardCVC = By.xpath("//input[@data-qa='cvc']");
		public static By cardMonth = By.xpath("//input[@data-qa='expiry-month']");
		public static By cardYear = By.xpath("//input[@data-qa='expiry-year']");
		public static By paymentButton = By.xpath("//button[@data-qa='pay-button']");
}
