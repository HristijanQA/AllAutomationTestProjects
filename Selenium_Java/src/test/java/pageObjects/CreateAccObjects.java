package pageObjects;

import org.openqa.selenium.By;

public class CreateAccObjects {

	public static By informationAcc = By.xpath("//h2[@class='title text-center']//b");
	public static By Mr = By.xpath("//*[@value='Mr']");
	public static By Mrs = By.xpath("//*[@value='Mrs']");
	public static By password = By.xpath("//input[@type='password']");
	public static By days = By.xpath("//select[@data-qa='days']");
	public static By months = By.xpath("//select[@data-qa='months']");
	public static By year = By.xpath("//select[@data-qa='years']");
	public static By first_name = By.xpath("//input[@data-qa='first_name']");
	public static By last_name = By.xpath("//input[@data-qa='last_name']");
	public static By address = By.xpath("//input[@data-qa='address']");
	public static By country = By.xpath("//select[@data-qa='country']");
	public static By state = By.xpath("//input[@data-qa='state']");
	public static By city = By.xpath("//input[@data-qa='city']");
	public static By zipcode = By.xpath("//input[@data-qa='zipcode']");
	public static By mobile_number = By.xpath("//input[@data-qa='mobile_number']");
	public static By subscribe = By.xpath("//button[@id='subscribe']//i[1]");
	public static By createAccount = By.xpath("//button[@data-qa='create-account']");
	public static By createAccounth2 = By.xpath("//h2[@data-qa='account-created']//b[1]");

}
