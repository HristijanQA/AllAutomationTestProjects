package pageMethods;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageObjects.CreateAccObjects;

public class CreateAccountMethods extends CreateAccObjects {

	WebDriver driver;

	public CreateAccountMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void NewUserPageValidation() {
		Assert.assertEquals(
				driver.findElement(CreateAccObjects.informationAcc).getText().contains("ENTER ACCOUNT INFORMATION"),
				true);
	}

	public void SelectGender(String Title) {
		System.out.println(Title);

		if (Title != "Male") {
			driver.findElement(CreateAccObjects.Mr).click();
		} else {
			driver.findElement(CreateAccObjects.Mrs).click();
		}
	}

	public void EnterPass(String Password) {
		driver.findElement(CreateAccObjects.password).sendKeys(Password);
	}

	public void EnterBDay(String Day) {
		driver.findElement(CreateAccObjects.days).sendKeys(Day);
	}

	public void EnterBMonth(String Month) {
		driver.findElement(CreateAccObjects.months).sendKeys(Month);
	}

	public void EnterBYear(String Year) {
		driver.findElement(CreateAccObjects.year).sendKeys(Year);
	}

	public void EnterFirstName(String FirstName) {
		driver.findElement(CreateAccObjects.first_name).sendKeys(FirstName);
	}

	public void EnterLastName(String LastName) {
		driver.findElement(CreateAccObjects.last_name).sendKeys(LastName);
	}

	public void EnterAddress(String Address) {
		driver.findElement(CreateAccObjects.address).sendKeys(Address);
	}

	public void EnterContry(String Contry) {
		driver.findElement(CreateAccObjects.country).sendKeys(Contry);
	}

	public void EnterState(String State) {
		driver.findElement(CreateAccObjects.state).sendKeys(State);
	}

	public void EnterCity(String City) {
		driver.findElement(CreateAccObjects.city).sendKeys(City);
	}

	public void EnterZipcode(String Zipcode) {
		driver.findElement(CreateAccObjects.zipcode).sendKeys(Zipcode);
	}

	public void EnterMobile(String Mobile) {
		driver.findElement(CreateAccObjects.mobile_number).sendKeys(Mobile);
	}

	public void create_account() throws InterruptedException {
		WebElement createAccount = driver.findElement(CreateAccObjects.subscribe);

		new Actions(driver).scrollToElement(createAccount).perform();
		Thread.sleep(2000);
		driver.findElement(CreateAccObjects.createAccount).click();
	}

	public void account_created() throws InterruptedException {
		String Account = driver.findElement(CreateAccObjects.createAccounth2).getText();
		System.out.println(Account);

		Assert.assertEquals(
				driver.findElement(CreateAccObjects.createAccounth2).getText().contains("Account Created!123"), false);
		driver.close();
	}
}
