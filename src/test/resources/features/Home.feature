	@homeFeature
Feature: Retail Home Page

	@departmentSidebar
Scenario: Verify Shop by Department sidebar
	Given User is on retail website
	When User click on All section
	Then below options are present in Shop by Department sidebar
	|Electronics|Computers|Smart Home|Sports|Automative|

	@SidebarOptions
Scenario Outline: Verify department sidebar options
	Given User is on retail website
	When User click on All section
	And User on <department>
	Then below options are present in department
	| <optionOne> | <optionTwo> |
	
Examples:
	|department	|optionOne	|optionTwo|
	|'Electronics'	|TV & Video	|Video Games|
	|'Computers'	|Accessories	|Networking|
	|'Smart Home'|	Smart Home Lighting	|Plugs and Outlets|
	|'Sports'	|Athletic Clothing	|Exercise & Fitness|
	|'Automotive'	|Automative Parts & Accessories	|MotorCycle & Powersports|
	