package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Register {

		WebDriver driver = new ChromeDriver();
		@Given("User is on homepage")
		public void user_is_on_homepage() {
		    driver.get("https://demo.nopcommerce.com/");
		    driver.manage().window().maximize();
		}

			@When ("Click on Register")
		public void click_on_register() {
			    driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
				
		 
		}

			@Then("Populates all of the required fields")
		public void populates_all_of_the_required_fields() throws InterruptedException {
				driver.findElement(By.xpath("//*[@id=\"gender-male\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("Kristijan");
				driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("Mazevski");
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]")).click();
				driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]/option[8]")).click();
				driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]")).click();
				driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]/option[4]")).click();
				driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]")).click();
				driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]/option[87]")).click();
				driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("kristijan@gmail.com");
				driver.findElement(By.xpath("//*[@id=\"Company\"]")).sendKeys("IW");
				driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("kristijan1");
				driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("kristijan1");
		  
		}

			@And("Click on REGISTER button")
		public void click_on_register_button() {
				driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();		  
		}

			@Then("Account should be created")
		public void account_should_be_created() {
				
			
				
			    
			

			 
			    
		


	}





}
