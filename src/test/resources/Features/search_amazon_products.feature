#language:en
@search

Feature: Should search for a product and display relevant results

	Scenario: Should search for a specific product
		Given the user navigates to "https://www.amazon.com/"
		When the user searches for "iPhone 13"
		Then the search results should display relevant links for "iPhone 13"
		And the user should see images related to "iPhone 13"
		When the user clicks on the first link
		Then the user should be redirected to a page related to "iPhone"
