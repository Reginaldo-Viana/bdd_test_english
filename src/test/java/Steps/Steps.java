package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.MainPage;

public class Steps {

	MainPage mainPage = new MainPage();

	@Given("the user navigates to {string}")
	public void theUserNavigatesTo(String url) {
		mainPage.navigateTo(url);
	}

	@When("the user searches for {string}")
	public void theUserSearchesFor(String query) {
		mainPage.searchFor(query);
	}

	@Then("the search results should display relevant links for {string}")
	public void theSearchResultsShouldDisplayRelevantLinks(String query) {
		mainPage.validateSearchResults(query);
	}

	@And("the user should see images related to {string}")
	public void theUserShouldSeeImagesRelatedTo(String query) {
		mainPage.validateImages(query);
	}

	@When("the user clicks on the first link")
	public void theUserClicksOnTheFirstLink() {
		mainPage.clickOnFirstLink();
	}

	@Then("the user should be redirected to a page related to {string}")
	public void theUserShouldBeRedirectedToAPageRelatedTo(String query) {
		mainPage.validateRedirection(query);
	}

	@When("the user clicks on the {string} tab")
	public void theUserClicksOnTheTab(String tabName) {
		mainPage.clickOnTab(tabName);
	}

	@When("searches for {string}")
	public void searchesFor(String searchTerm) {
		mainPage.searchFor(searchTerm);
	}

	@And("clicks on the {string} button")
	public void clicksOnTheButton(String buttonName) {
		mainPage.clickOnTab(buttonName);
	}

	@When("the user enters the username {string} and password {string}")
	public void theUserEntersTheUsernameAndPassword(String username, String password) {
		mainPage.enterCredentials(username, password);
	}

	@Then("the user should see a message {string}")
	public void the_user_should_see_a_message(String string) throws InterruptedException {
		mainPage.validateInvalidOtpMessage(string);
	}
}