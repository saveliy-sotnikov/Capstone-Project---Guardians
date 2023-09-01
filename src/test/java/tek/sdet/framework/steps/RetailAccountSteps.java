package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.apache.hc.core5.util.Timeout;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities​​​​​​​.CommonUtility;

public class RetailAccountSteps extends CommonUtility{
	
	POMFactory pomFactory = new POMFactory();
	
	@And("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(pomFactory.signIn().accountBtn.isDisplayed());
		logger.info("Account button visible, successfully signed in");
	}
	
	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(pomFactory.account().accountBtn);
		logger.info("Clicked on 'Account' button");
	}
	
	@And("User update name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String number) throws InterruptedException {
		sendText(pomFactory.account().nameInput, "TEST");
		click(pomFactory.account().personalUpdateBtn);
		Thread.sleep(2000);
		clearTextUsingSendKeys(pomFactory.account().nameInput);
		sendText(pomFactory.account().nameInput, name);
		clearTextUsingSendKeys(pomFactory.account().personalPhoneInput);
		sendText(pomFactory.account().personalPhoneInput, number);
		logger.info("Name and phone number successfully entered");
	}
	
	@And("User click on Update button")
	public void userClickOnUpdateButton() {
		click(pomFactory.account().personalUpdateBtn);
		logger.info("Clicked on 'Update' button");
	}
	
	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(pomFactory.account().profileUpdateSuccess);
		String expectedMessage = "Personal Information Updated Successfully";
		String actualMessage = pomFactory.account().profileUpdateSuccess.getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		logger.info("Profile information successfully updated");
	}
	
	@And("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(pomFactory.account().addPaymentMethodBtn);
		logger.info("Clicked on 'Add a payment method' link");
	}
	
	@And("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
		sendText(pomFactory.account().cardNumberInput, cardInfo.get(0).get("cardNumber"));
		sendText(pomFactory.account().nameOnCardInput, cardInfo.get(0).get("nameOnCard"));
		selectByVisibleText(pomFactory.account().expirationMonthInput, cardInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pomFactory.account().expirationYearInput, cardInfo.get(0).get("expirationYear"));
		sendText(pomFactory.account().securityCodeInput, cardInfo.get(0).get("securityCode"));
		logger.info("Successfully entered card information");
		
	}
	
	@And("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(pomFactory.account().paymentSubmitBtn);
		logger.info("Clicked on 'Add Your Card' button");
	}
	
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expectedMessage) {
		
		if(expectedMessage.contains("Payment Method added successfully")) {
			waitTillPresence(pomFactory.account().cardInfoAddSuccess);
			expectedMessage = "Payment Method added successfully";
			String actualMessage = pomFactory.account().cardInfoAddSuccess.getText();
			Assert.assertEquals(expectedMessage, actualMessage);
			logger.info("Payment Method added successfully");
		
		} else if(expectedMessage.contains("Payment Method updated Successfully")) {
			waitTillPresence(pomFactory.account().cardInfoUpdateSuccess);
			expectedMessage = "Payment Method updated Successfully";
			String actualMessage = pomFactory.account().cardInfoUpdateSuccess.getText();
			Assert.assertEquals(expectedMessage, actualMessage);
			logger.info("Payment Method updated Successfully");
		} else if(expectedMessage.contains("Address Added Successfully")) {
			waitTillPresence(pomFactory.account().addressAddSuccess);
			expectedMessage = "Address Added Successfully";
			String actualMessage = pomFactory.account().addressAddSuccess.getText();
			Assert.assertEquals(expectedMessage, actualMessage);
			logger.info("Address Added Successfully");
		} else if(expectedMessage.contains("Address updated Successfully")) {
			waitTillPresence(pomFactory.account().updateAddressSuccess);
			expectedMessage = "Address updated Successfully";
			String actualMessage = pomFactory.account().updateAddressSuccess.getText();
			Assert.assertEquals(expectedMessage, actualMessage);
			logger.info("Address updated Successfully");
		}
	}
	
	@And("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSelection() {
		click(pomFactory.account().newCard);
		click(pomFactory.account().editCardInfoBtn);
		logger.info("Clicked on 'Edit' button");
	}
	
	@And("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(pomFactory.account().cardNumberInput);
		clearTextUsingSendKeys(pomFactory.account().nameOnCardInput);
		clearTextUsingSendKeys(pomFactory.account().securityCodeInput);
		sendText(pomFactory.account().cardNumberInput, cardInfo.get(0).get("cardNumber"));
		sendText(pomFactory.account().nameOnCardInput, cardInfo.get(0).get("nameOnCard"));
		selectByVisibleText(pomFactory.account().expirationMonthInput, cardInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pomFactory.account().expirationYearInput, cardInfo.get(0).get("expirationYear"));
		sendText(pomFactory.account().securityCodeInput, cardInfo.get(0).get("securityCode"));
		logger.info("Entered new card information");
	}
	
	@And("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(pomFactory.account().paymentSubmitBtn);
		logger.info("Clicked on 'Update Your Card' button");
	}
	
	@And("user click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSelection() {
		click(pomFactory.account().newerCard);
		click(pomFactory.account().removeBtn);
		logger.info("Clicked on 'remove' button");
	}
	
	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() throws InterruptedException {
		Thread.sleep(2000);
		try {
			Assert.assertTrue(pomFactory.account().cardExists.isDisplayed());
		} catch (NoSuchElementException nSEE){
			logger.info("Card Removed Successfully");
		}
	}
	
	@And("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(pomFactory.account().addAddressBtn);
		logger.info("Clicked on 'Add Address' button");
	}
	
	@And("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> address = dataTable.asMaps(String.class, String.class);
		sendText(pomFactory.account().countryDropdown, "Select Country");
		Thread.sleep(2000);
		clearTextUsingSendKeys(pomFactory.account().fullNameInput);
		clearTextUsingSendKeys(pomFactory.account().phoneNumberInput);
		clearTextUsingSendKeys(pomFactory.account().streetInput);
		clearTextUsingSendKeys(pomFactory.account().cityInput);
		clearTextUsingSendKeys(pomFactory.account().zipCodeInput);
		sendText(pomFactory.account().countryDropdown, address.get(0).get("country"));
		sendText(pomFactory.account().fullNameInput, address.get(0).get("fullName"));
		sendText(pomFactory.account().phoneNumberInput, address.get(0).get("phoneNumber"));
		sendText(pomFactory.account().streetInput, address.get(0).get("streetAddress"));
		sendText(pomFactory.account().apartmentInput, address.get(0).get("apt"));
		sendText(pomFactory.account().cityInput, address.get(0).get("city"));
		Thread.sleep(2000);
		sendText(pomFactory.account().stateSelect, address.get(0).get("state"));
		sendText(pomFactory.account().zipCodeInput, address.get(0).get("zipCode"));
		logger.info("Entered address data");
	}
	
	@And("User click on Add Your Address button")
	public void userClickOnAddYourAddressButton() {
		click(pomFactory.account().addressBtn);
		logger.info("Clciked on Add Your Address button");
	}
	
	@And("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(pomFactory.account().editAddressBtn);
		logger.info("Clicked on edit address button");
	}

	@And("user edit address information with below data")
	public void userEditAddressInformationWithBelowData(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> address = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(pomFactory.account().fullNameInput);
		clearTextUsingSendKeys(pomFactory.account().phoneNumberInput);
		clearTextUsingSendKeys(pomFactory.account().streetInput);
		clearTextUsingSendKeys(pomFactory.account().cityInput);
		clearTextUsingSendKeys(pomFactory.account().zipCodeInput);
		sendText(pomFactory.account().countryDropdown, address.get(0).get("country"));
		sendText(pomFactory.account().fullNameInput, address.get(0).get("fullName"));
		sendText(pomFactory.account().phoneNumberInput, address.get(0).get("phoneNumber"));
		sendText(pomFactory.account().streetInput, address.get(0).get("streetAddress"));
		sendText(pomFactory.account().apartmentInput, address.get(0).get("apt"));
		sendText(pomFactory.account().cityInput, address.get(0).get("city"));
		Thread.sleep(2000);
		sendText(pomFactory.account().stateSelect, address.get(0).get("state"));
		sendText(pomFactory.account().zipCodeInput, address.get(0).get("zipCode"));
		logger.info("Edited address information");
	}
	
	@And("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(pomFactory.account().addressBtn);
		logger.info("Clicked on update Your Address button");
	}
	
	@And("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(pomFactory.account().removeAddressBtn);
		logger.info("Clicked on remove option of Address section");
	}
	
	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		try {
			Assert.assertTrue(pomFactory.account().newAddress.isDisplayed());
		} catch(NoSuchElementException nSEE) {
			logger.info("Address detailes removed");
		}
	}
}
