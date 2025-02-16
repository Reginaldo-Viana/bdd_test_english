package page;

import java.io.BufferedReader;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MainPage extends TimePage {

	static final Runtime run = Runtime.getRuntime();
	static Process pro;
	static BufferedReader read;

	WebDriver driver = Browser.getDriver();


	public MainPage() {
		PageFactory.initElements(Browser.getDriver(), this);
	}

	public MainPage(WebDriverManager driver) {
		PageFactory.initElements(Browser.getDriver(), this);
	}

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//input[@id='nav-bb-search']")
	private WebElement searchBox;

	@FindBy(name = "field-keywords")
	private WebElement searchBox2;

	@FindBy(className = "aok-relative")
	private WebElement imagesLink;

	@FindBy(css = "img")
	private List<WebElement> images;

	@FindBy(xpath = "(//img[@data-image-latency='s-product-image'])[1]")
	private WebElement firstLink;

	@FindBy(className = "s-no-outline")
	private WebElement searchResultsContainer;

	@FindBy(id = "nav-link-accountList-nav-line-1")
	private WebElement buttonHelloSignIn;

	@FindBy(id = "ap_email")
	private WebElement emailField;

	@FindBy(id = "continue")
	private WebElement continueButton;

	@FindBy(id = "cvf-input-code")
	private WebElement otpField;

	@FindBy(id = "cvf-submit-otp-button")
	private WebElement otpContinue;

	@FindBy(xpath = "//div[contains(text(),'Invalid OTP. Please check your code and try again.')]")
	private WebElement otpErrorMessage;


	public static void ScrollButton() {
		((org.openqa.selenium.JavascriptExecutor) TimePage.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void navigateTo(String url) {
		Browser.navigate(url);
	}

	public void searchFor(String query) {
		IframeList();
		if (!driver.findElements(By.id("nav-bb-search")).isEmpty() && searchBox.isDisplayed()) {
			waitForElementVisible(searchBox, 20);
			searchBox.sendKeys(query);
			searchBox.submit();
		} else {
			waitForElementVisible(searchBox2, 20);
			searchBox2.sendKeys(query);
			searchBox2.submit();
		}

	}

	public void validateSearchResults(String query) {
		waitForElementVisible(searchResultsContainer, 60);
		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@role='listitem']"));
		boolean isRelevant = searchResults.stream()
				.anyMatch(result -> result.getText().toLowerCase().contains(query.toLowerCase()));

		Assert.assertTrue("Relevant links for " + query + " should be displayed.", isRelevant);
	}

	public void validateImages(String query) {
		waitForElementVisible(imagesLink, 10);
		imagesLink.click();

		Assert.assertFalse("Images related to " + query + " should be displayed.", images.isEmpty());
	}

	public void clickOnFirstLink() {
		waitForElementVisible(firstLink, 10);
		firstLink.click();
	}

	public void validateRedirection(String query) {
		ExpectedConditions.urlContains("iphone");
		String pageTitle = driver.getTitle().toLowerCase();
		Assert.assertTrue("The page title should contain " + query, pageTitle.contains(query.toLowerCase()));
	}

	public void clickOnTab(String tabName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(tabName)));
		driver.findElement(By.linkText(tabName)).click();

		waitForElementVisible(buttonHelloSignIn, 10);
		buttonHelloSignIn.click();

	}

	public void IframeList(){
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of iframes in  page: " + iframes.size());
		for (WebElement iframe : iframes) {
			System.out.println("Iframe src: " + iframe.getAttribute("src"));
		}
	}

	public void enterCredentials(String username, String password) {
		waitForElementVisible(emailField, 10);
		emailField.sendKeys(username);
		continueButton.click();
		continueButton.click();
		waitForElementVisible(otpField, 10);
		otpField.sendKeys(password);
		otpContinue.click();
	}

	public void validateInvalidOtpMessage(String expectedMessage ) {
		waitForElementVisible(otpErrorMessage, 10);
		String actualMessage = otpErrorMessage.getText();
		Assert.assertEquals("The OTP error message is incorrect!", expectedMessage, actualMessage);
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
