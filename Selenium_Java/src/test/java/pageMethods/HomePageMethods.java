package pageMethods;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.HomePageObjects;
import pageObjects.SignupObjects;


public class HomePageMethods {
	
	
	WebDriver driver;

	public HomePageMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public void HomePageSignUp() {

		driver.findElement(HomePageObjects.logInButton).click();

		Assert.assertTrue(driver.findElement(SignupObjects.newUser).getText().contains("New User Signup!"));
	}
	
	public void HomePageLogout() {


		Assert.assertTrue(driver.findElement(HomePageObjects.logout).getText().concat("logout"), true);
	}
	
	public void AddProductsToCart(String product1, String product2, String product3) throws InterruptedException {

		String[] itemsNeeded = { product1, product2, product3 };

		int j = 0;

		List<WebElement> products = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
		System.out.println(products.size());

		for (int i = 0; i < products.size(); i++)

		{

			String name = products.get(i).getText().toString();
			System.out.println(name);
			List itemsNeededList = Arrays.asList(itemsNeeded);
			// System.out.println(itemsNeededList);

			if (itemsNeededList.contains(name))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='single-products']/div/a")).get(i).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
				if (j == itemsNeeded.length)
				{
					break;
				}
			}
		}
	}
	
	
	public void HomePageClickCart(String product1, String product2, String product3) {

		driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
		List<WebElement> productsincart = driver.findElements(By.xpath("//td[@class=\"cart_description\"]/h4"));
		for (WebElement product : productsincart) {
            Assert.assertTrue("Product is not visible on the page.", product.isDisplayed());
        }
	}
	
	
}
