package page;

import org.junit.rules.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser extends TestWatcher {

	private static WebDriver driver;


	private static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("--incognito");
		options.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--lang=en-US");
		options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.5735.110 Safari/537.36");
		options.addArguments("--headless");
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		options.setExperimentalOption("useAutomationExtension", false);
		return options;
	}


	private static void initDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(getChromeOptions());
			driver.manage().window().maximize();
		}
	}


	public static void navigate(String url) {
		initDriver();
		driver.navigate().to(url);
	}


	public static WebDriver getDriver() {
		initDriver();
		return driver;
	}


	public static void setDriver(WebDriver customDriver) {
		if (driver != null) {
			driver.quit();
		}
		driver = customDriver;
	}
}
