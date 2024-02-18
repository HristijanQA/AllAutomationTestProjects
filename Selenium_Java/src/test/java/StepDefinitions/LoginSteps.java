package StepDefinitions;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pageMethods.CreateAccountMethods;
import pageMethods.HomePageMethods;
import pageMethods.SignupMethods;
import environment.Environment;
import io.cucumber.java.en.*;

public class LoginSteps extends Environment {

	WebDriver driver = setDriver();

	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
		String url = webUrl;
		Assert.assertTrue(driver.getCurrentUrl().contains(url));
	}

	@And("click on the Log in button")
	public void click_on_the_log_in_button() {
		HomePageMethods homePageMethods = new HomePageMethods(driver);
		homePageMethods.HomePageSignUp();
	}

	@When("^enters (.*) and (.*) in the New User Signup$")
	public void enters_name1_and_testing_test_com_in_the_new_user_signup(String name, String email) throws InterruptedException {
		
		Thread.sleep(7000);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));
	    
	    Thread.sleep(2000);
	    
	    Actions act = new Actions(driver); act.sendKeys(Keys.F5).perform();
		
	    Thread.sleep(2000);
		
		SignupMethods signup = new SignupMethods(driver);
		signup.PopulateNameAndEmail(name, email);
	}

	@And("clicks on Sigup button")
	public void clicks_on_sigup_button() {
		SignupMethods SignupMethods = new SignupMethods(driver);
		SignupMethods.ClickSignUp();

	}

	@When("user is on account information")
	public void user_is_on_account_information() {
		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.NewUserPageValidation();

	}

	@And("^populates (.*)$")
	public void populates_title(String Title) {
		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.SelectGender(Title);

	}

	@And("^populatesP (.*)$")
	public void populates_password(String Password) {
		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.EnterPass(Password);

	}

	@And("^populatesD (.*)$")
	public void populates_day(String Day) {
		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.EnterBDay(Day);

	}

	@And("^populatesM (.*)$")
	public void populates_month(String Month) {
		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.EnterBMonth(Month);

	}

	@And("^populatesY (.*)$")
	public void populates_year(String Year) {
		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.EnterBYear(Year);
	}

	@And("^populatesF (.*)$")
	public void populates_first_name(String FirstName) {
		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.EnterFirstName(FirstName);
	}

	@And("^populatesL (.*)$")
	public void populates_last_name(String LastName) {
		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.EnterLastName(LastName);
	}

	@And("^populatesA (.*)$")
	public void populates_address(String Address) {
		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.EnterAddress(Address);
	}

	@And("^populatesC (.*)$")
	public void populates_contry(String Contry) {
		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.EnterContry(Contry);
	}

	@And("^populatesS (.*)$")
	public void populates_state(String State) {
		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.EnterState(State);
	}

	@And("^populatesCi (.*)$")
	public void populates_city(String City) {
		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.EnterCity(City);
	}

	@And("^populatesZ (.*)$")
	public void populates_zipcode(String Zipcode) {
		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.EnterZipcode(Zipcode);
	}

	@And("^populatesMob (.*)$")
	public void populates_mobile(String Mobile) {
		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.EnterMobile(Mobile);
	}

	@And("click on create account")
	public void click_on_create_account() throws InterruptedException {

		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.create_account();
	}

	@Then("user account should be created")
	public void user_account_should_be_created() throws InterruptedException {

		CreateAccountMethods createAccountMethods = new CreateAccountMethods(driver);
		createAccountMethods.account_created();
		driver.quit();
	}
}
