package environment;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Environment {
	public static WebDriver driver;
	public static String webUrl = "https://automationexercise.com/";
	public static String browser = "chrome";

	protected static WebDriver setDriver() {

		if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions opt = new ChromeOptions();
			opt.addExtensions(new File("D:\\Eclipse\\eclipse-workspace\\EdukativenCucamber\\Exstations\\AdBlock.crx"));

			driver = new ChromeDriver(opt);
			driver.get(webUrl);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.get(webUrl);
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.get(webUrl);
			driver.manage().window().maximize();

		}
		return driver;
	}

}