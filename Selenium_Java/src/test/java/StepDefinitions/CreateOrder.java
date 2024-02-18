package StepDefinitions;

import io.cucumber.java.en.*;
import pageMethods.CartPageMethod;
import pageMethods.HomePageMethods;
import pageMethods.OrderConfirmationMethods;
import pageMethods.PaymentMethods;
import pageMethods.SignupMethods;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import environment.Environment;

public class CreateOrder extends Environment {
	
	WebDriver driver = setDriver();
	
	
	@Test
	@Given("User is on the homepage")
	public void user_is_on_the_homepage() {
	 
		String url = webUrl;
		Assert.assertTrue(driver.getCurrentUrl().contains(url));
	}

	@Then("the user clicks on the LogIn option")
	public void the_user_clicks_on_the_log_in_option() {
		
		HomePageMethods homePageMethods = new HomePageMethods(driver);
		homePageMethods.HomePageSignUp();
	}

	@Then("^enters (.*) and (.*) in the LogIn section$")
	public void enters_testing10_test_com_and_testing1_in_the_log_in_section(String email, String pass) throws InterruptedException {
		
		Thread.sleep(4000);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));
	    
	    Actions act = new Actions(driver); act.sendKeys(Keys.F5).perform();
		
	    Thread.sleep(2000);
	    
		SignupMethods signup = new SignupMethods(driver);
		signup.PopulateEmailAndPass(email, pass);
	}

	@Then("the user should be login")
	public void the_user_should_be_login() {
		HomePageMethods homepageactions = new HomePageMethods(driver);
		homepageactions.HomePageLogout();
	   
	}

	@And("^add to cart (.*) and (.*) and (.*)$")
	public void add_to_cart_men_tshirt(String product1, String product2, String product3) throws InterruptedException {
		HomePageMethods homepageactions = new HomePageMethods(driver);
		homepageactions.AddProductsToCart(product1,product2,product3);
	    
	}

	@When("^items in card (.*) and (.*) and (.*)$")
	public void items_in_card_men_tshirt_and_men_tshirt_and_summer_white_top(String product1, String product2, String product3) {
		HomePageMethods homepageactions = new HomePageMethods(driver);
		homepageactions.HomePageClickCart(product1,product2,product3);
	}

	@Then("user continues to check out")
	public void user_continues_to_check_out() {
		CartPageMethod cardactions = new CartPageMethod(driver);
		cardactions.CartProceed();
	}


	@And("addess information")
	public void addess_information() {
	    
		String DeliveryAddress = driver.findElement(By.xpath("(//li[contains(@class,'address_city address_state_name')])[1]")).getText();
		String BillingAddress = driver.findElement(By.xpath("(//li[contains(@class,'address_city address_state_name')])[2]")).getText();
		Assert.assertEquals(DeliveryAddress, BillingAddress);
		driver.findElement(By.xpath("//a[@href='/payment']")).click();
	}

	@And("^user enters (.*) (.*) (.*) (.*) (.*)$")
	public void user_enters_payment(String CardName, String CardNumber, String CardCVC, String CardM, String CardY) {

		PaymentMethods cardInforamtion = new PaymentMethods(driver);
		cardInforamtion.EnterCardDetails(CardName, CardNumber, CardCVC, CardM, CardY);
		
		PaymentMethods completeOrder = new PaymentMethods(driver);
		completeOrder.CompleteOrder();
	}

	@Then("order is completed")
	public void order_is_completed() throws InterruptedException {
		
		OrderConfirmationMethods validatedOrderConfirmed = new OrderConfirmationMethods(driver);
		validatedOrderConfirmed.ValidatedOrderComfirmation();
		driver.quit();
	}

}
