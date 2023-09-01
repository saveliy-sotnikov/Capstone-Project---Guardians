package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailSignInPage extends BaseSetup {
	
	public RetailSignInPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(linkText = "TEKSCHOOL")
	public WebElement tekSchoolLogo;
	
	@FindBy(linkText = "Sign in")
	public WebElement signInBtn;
	
	@FindBy(id = "email")
	public WebElement emailInput;
	
	@FindBy(id = "password")
	public WebElement passwordInput;
	
	@FindBy(id = "loginBtn")
	public WebElement loginBtn;
	
	@FindBy(linkText = "Account")
	public WebElement accountBtn;
	
	@FindBy(linkText = "Create New Account")
	public WebElement createNewAccountBtn;
	
	@FindBy(id = "nameInput")
	public WebElement nameInput;
	
	@FindBy(id = "emailInput")
	public WebElement signUpEmailInput;
	
	@FindBy(id = "passwordInput")
	public WebElement signUpPasswordInput;
	
	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmPasswordInput;
	
}
