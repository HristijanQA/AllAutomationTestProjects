package pageObjects;

import org.openqa.selenium.By;

public class SignupObjects {
	
	public static By newUser = By.xpath("//div[@class='signup-form']//h2[1]");
	public static By name = By.xpath("//input[@placeholder='Name']");
	public static By email = By.xpath("(//input[@placeholder='Email Address'])[2]");
	public static By signup = By.xpath("//button[text()='Signup']");
	public static By loginemail = By.xpath("//input[@data-qa='login-email']");
	public static By loginpass = By.xpath("//input[@data-qa='login-password']");
	public static By loginbutton = By.xpath("//button[@data-qa='login-button']");

}
