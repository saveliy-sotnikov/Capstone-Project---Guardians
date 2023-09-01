	@accountFeature
Feature: Retail Account Page

Background:
	Given User is on retail website
	When User click on Sign in option
	And User enter email 'test@test.test' and password 'TestTest3#'
	And User click on login button
	And User should be logged in into Account

	@updateProfile
Scenario: Verify User can update Profile Information
	When User click on Account option
	And User update name 'TestTest' and Phone '1234567890'
	And User click on Update button
	Then user profile information should be updated
	
	@addPayment
Scenario: Verify User can add a payment method
	When User click on Account option
	And User click on Add a payment method link
	And User fill Debit or credit card information
	|cardNumber	|nameOnCard|	expirationMonth|	expirationYear|	securityCode|
	|1234567890123456	|Test Test	|8	|2042	|123|
	And User click on Add your card button
	Then a message should be displayed 'Payment Method added successfully'

	@editPayment
Scenario: Verify User can edit Debit or Credit card
	When User click on Account option
	And User click on Edit option of card section
	And user edit information with below data
	|cardNumber	|nameOnCard|	expirationMonth|	expirationYear|	securityCode|
	|9876543210987654	|Testtest McTest	|9	|2041	|321|
	And user click on Update Your Card button
	Then a message should be displayed 'Payment Method updated Successfully'

	@removeCard
Scenario: Verify User can remove Debit or Credit card
	When User click on Account option
	And user click on remove option of card section
	Then payment details should be removed
	
	@addAddress
Scenario: Verify User can add an Address
	When User click on Account option
	And User click on Add address option
	And user fill new address form with below information
	|country	|fullName	|phoneNumber	|streetAddress	|apt	|city	|state	|zipCode	|
	|United States|Test Test	|1234567890	|12345 Street Ave	|3	|Cityville	|California	|12345|
	And User click on Add Your Address button
	Then a message should be displayed 'Address Added Successfully'
	
	@editAddress
Scenario: Verify User can edit an Address added on account
	When User click on Account option
	And User click on edit address option
	And user fill new address form with below information
	|country	|fullName	|phoneNumber	|streetAddress	|apt	|city	|state	|zipCode	|
	|Russian Federation	|Testtest McTest	|9876543210	|54321 Avenue Ave	|2	|Townsville	|Altai Krai	|54321|
	And User click update Your Address button
	Then a message should be displayed 'Address updated Successfully'
	
	@removeAddress
Scenario: Verify User can remove Address from Account
	When User click on Account option
	And User click on remove option of Address section
	Then Address details should be removed