package tek.sdet.framework.steps;


import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities​​​​​​​.CommonUtility;

public class RetailOrderSteps extends CommonUtility {
	
	POMFactory pomFactory = new POMFactory();

	@And("User change the category to {string}")
	public void userChangeTheCategoryTo(String categories) {
		if(categories.contains("Smart Home")) {
			click(pomFactory.order().category);
			click(pomFactory.order().smartHomeBtn);	
			logger.info("Changed category to Smart Home");
		}
		if(categories.contains("Electronics")) {
			click(pomFactory.order().category);
			click(pomFactory.order().electronicsBtn);
			logger.info("Changed category to Electronics");
			
		}
	}
	
	@And("User search for an item {string}")
	public void userSearchForAnItem(String input) {
		if(input.contains("kasa outdoor smart plug")) {
			click(pomFactory.order().searchBar);
			pomFactory.order().searchBar.sendKeys("kasa outdoor smart plug");
			logger.info("Searched kasa outdoor smart plug");
		}
		if(input.contains("Apex Legends")) {
			click(pomFactory.order().searchBar);
			pomFactory.order().searchBar.sendKeys("Apex Legends");
			logger.info("Searched Apex Legends");
		}
		
	}
	
	@And("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(pomFactory.order().searchBtn);
		logger.info("Clicked on search button");
	}
	
	@And("User click on item")
	public void userClickOnItem() {
		waitTillPresence(pomFactory.order().itemBtn);
		click(pomFactory.order().itemBtn);
	}
	
	@And("User select quantity {string}")
	public void userSelectQuantity(String quantity) {
		if(quantity.contains("2")) {
			click(pomFactory.order().quantity);
			click(pomFactory.order().quantity2);
			logger.info("Selected quantity 2");
		}
		if(quantity.contains("5")) {
			click(pomFactory.order().quantity);
			click(pomFactory.order().quantity5);
			logger.info("Selected quantity 5");
		}
	}
	
	@And("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(pomFactory.order().addToCartBtn);
		logger.info("Clicked on Add to Cart button");
	}
	
	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String quantity) {
		Assert.assertTrue(pomFactory.order().cartQuantity2.isDisplayed());
	}
	
	@And("User click on Cart option")
	public void userClickOnCartOption() {
		click(pomFactory.order().addToCartBtn);
		click(pomFactory.order().cartBtn);
		logger.info("Clicked on cart option");
	}
	
	@And("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(pomFactory.order().proceedBtn);
		logger.info("Clicked on Proceed to Checkout option");
	}
	
	@And("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(pomFactory.order().placeOrderBtn);
		logger.info("Clicked on Place your Order");
	}
	
	@Then("Then a message should be displayed {string}")
	public void thenAMessageShouldBeDisplayed(String displayMessage) {
		Assert.assertEquals(displayMessage, pomFactory.order().orderPlaceSuccess.getText());
		logger.info("Displayed message is correct: " + displayMessage.equals(pomFactory.order().orderPlaceSuccess.getText()));
	}
	
	@And("User click on Orders Section")
	public void userClickOnOrdersSection() {
		click(pomFactory.order().orderLink);
		logger.info("Clicked on Orders Section");
	}
	
	@And("User click on first order in list")
	public void userClickOnFirstOrderInList() {
			click(pomFactory.order().buyAgainBtn);
			click(pomFactory.order().placeOrderBtn);
			click(pomFactory.order().orderLink);
			click(pomFactory.order().orderLink);
			click(pomFactory.order().orderLink);
			click(pomFactory.order().orderLink);
			click(pomFactory.order().orderLink);
			click(pomFactory.order().orderLink);
			
			Assert.assertTrue(pomFactory.order().cancelBtn.isDisplayed());
			logger.info("Clicked on first order in list");
	}

	
	@And("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(pomFactory.order().orderLink);
		click(pomFactory.order().cancelBtn);
		logger.info("Clicked on Cancel Order button");
				
	}
	
	@And("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String bWI) throws InterruptedException {
		click(pomFactory.order().reasonInput);
		click(pomFactory.order().boughtWrongItem);
		logger.info("selected cancelation reason: " +bWI);
	}
	
	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String cancelMessage) {
		if(cancelMessage.contains("Your Order Has Been Cancelled")) {
			Assert.assertEquals(cancelMessage, pomFactory.order().cancelSuccess.getText());
			logger.info("Displayed message is correct: " + cancelMessage.equals(pomFactory.order().cancelSuccess.getText()));
		}
		if(cancelMessage.contains("Return was successful")) {
			Assert.assertEquals(cancelMessage, pomFactory.order().returnSuccess.getText());
			logger.info("Displayed message is correct: " + cancelMessage.equals(pomFactory.order().returnSuccess.getText()));
		}
	}
	
	@And("user click on Cancel Order button on cancellation page")
	public void userClickOnCancelOrderButtonOnCancellationPage() {
		click(pomFactory.order().finalCancelBtn);
		logger.info("Clicked on Cancel Order button");
	}
	
	@And("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(pomFactory.order().returnBtn);
		logger.info("Clicked on Return Items button");
	}
	
	@And("User select the Return Reason {string}")
	public void userSelectTheReturnReason (String bWI) {
		click(pomFactory.order().reasonInput);
		click(pomFactory.order().boughtWrongItem);
		logger.info("Selected Return reason: " + bWI);
	}
	
	@And("User select the drop off service {string}")
	public void userSelectTheDropOffService(String fE) {
		click(pomFactory.order().fedEx);
		logger.info("Selected drop off service: " + fE);
	}
	
	@And("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(pomFactory.order().orderSubmitBtn);
		logger.info("Clicked on Return Order button");
	}
	
	@And("User click on Review button")
	public void userClickOnReviewButton() {
		click(pomFactory.order().reviewBtn);
		logger.info("Clicked on Review button");
	}

	@And("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String reviewHeadline, String reviewText) {
		sendText(pomFactory.order().headlineInput, reviewHeadline);
		sendText(pomFactory.order().descriptionInput, reviewText);
		logger.info("Review headline and text successfully written");
	}
	
	@And("User click Add your Review button")
	public void userClickAddYourReviewButton() throws InterruptedException {
		click(pomFactory.order().reviewSubmitBtn);
		logger.info("Clicked on Add your Review button");
		Thread.sleep(2000);
	}
	
	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayed(String reviewMessage) throws InterruptedException {
		Assert.assertEquals(reviewMessage, pomFactory.order().reviewSuccess.getText());
		logger.info("Displayed message is correct: " + reviewMessage.equals(pomFactory.order().reviewSuccess.getText()));
		click(pomFactory.order().cartBtn);
		Thread.sleep(2000);
		click(pomFactory.order().deleteBtn);
		Thread.sleep(2000);
		click(pomFactory.order().deleteBtn);
		
	}
}
