package pageMethods;

import org.openqa.selenium.WebDriver;

import pageObjects.SignupObjects;

public class SignupMethods {
	WebDriver driver;

	public SignupMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public void PopulateNameAndEmail(String name, String email) {

		driver.findElement(SignupObjects.name).sendKeys(name);
		driver.findElement(SignupObjects.email).sendKeys(email);
	}

	public void ClickSignUp() {
		driver.findElement(SignupObjects.signup).click();
	}
	
	public void PopulateEmailAndPass(String email, String pass) {

		driver.findElement(SignupObjects.loginemail).sendKeys(email);
		driver.findElement(SignupObjects.loginpass).sendKeys(pass);
		driver.findElement(SignupObjects.loginbutton).click();;
	}


}
