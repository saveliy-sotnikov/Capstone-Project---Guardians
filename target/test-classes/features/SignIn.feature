	@signInFeature
Feature: Sign in Feature

  @signIn
  Scenario: Verify user can sign in into Retail Application
  	Given User is on retail website
  	When User click on Sign in option
  	And User enter email 'test@test.test' and password 'TestTest3#'
  	And User click on login button
  	Then User should be logged in into account
  	
  @createAccount
  Scenario: Verify user can create an account into Retail Websitr
  	Given User is on retail website
  	When User click on Sign in option
  	And User click on Create New Account option
  	And User fill the sign up information with below data
  	|name|email|password|confirmPassword|
  	|student|sstudent@tekschool.us|Tek12345!|Tek12345!|