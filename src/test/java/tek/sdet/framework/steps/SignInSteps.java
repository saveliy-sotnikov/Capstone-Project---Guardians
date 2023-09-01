package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities​​​​​​​.CommonUtility;

public class SignInSteps extends CommonUtility {
	
	POMFactory pomFactory = new POMFactory();
	
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		Assert.assertTrue(pomFactory.signIn().tekSchoolLogo.isDisplayed());
		logger.info("TEKSCHOOL logo is displayed");
	}
	
	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(pomFactory.signIn().signInBtn);
		logger.info("Clicked on 'Sign in' button");
	}
	
	@And("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		pomFactory.signIn().emailInput.sendKeys("test@test.test");
		pomFactory.signIn().passwordInput.sendKeys("TestTest3#");
		logger.info("Email and password filled in");
	}
	
	@And("User click on login button")
	public void userClickOnLoginButton() {
		click(pomFactory.signIn().loginBtn);
		logger.info("Clicked 'Login' button");
	}
	
	@Then("User should be logged in into account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(pomFactory.signIn().accountBtn.isDisplayed());
		logger.info("Account button visible, successfully signed in");
	}
	
	@And("User click on Create New Account option")
	public void userClickOnCreateNewAccountOption() {
		click(pomFactory.signIn().createNewAccountBtn);
		logger.info("Clicked on 'Create New Account' button");
	}
	
	@And("User fill the sign up information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> createAccount = dataTable.asMaps(String.class, String.class);
		int min = 1;
		int max = 100;
		int range = max - min + 1;
		int r = 0;
		String random = "";
		for(int i = 0; i < max; i++) {
			r = (int)(Math.random() * range) + min;
			random = "" + r;
		}
		sendText(pomFactory.signIn().nameInput, createAccount.get(0).get("name"));
		sendText(pomFactory.signIn().signUpEmailInput, random);
		sendText(pomFactory.signIn().signUpEmailInput, createAccount.get(0).get("email"));
		Thread.sleep(2000);
		sendText(pomFactory.signIn().signUpPasswordInput, createAccount.get(0).get("password"));
		sendText(pomFactory.signIn().confirmPasswordInput, createAccount.get(0).get("confirmPassword"));
		logger.info("Sign up information successfully filled in");
		
	}
	
}
