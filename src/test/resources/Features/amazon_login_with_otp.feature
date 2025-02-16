# language: en
@Login

Feature: Login to Amazon account

	Scenario: Should not log in with invalid OTP
		Given the user navigates to "https://www.amazon.com/"
		And clicks on the "Your Account" button
		When the user enters the username "testuser@gmail.com" and password "1234"
		Then the user should see a message "Invalid OTP. Please check your code and try again."
