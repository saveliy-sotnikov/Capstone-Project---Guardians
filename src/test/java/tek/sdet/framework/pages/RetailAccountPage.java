package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {
	
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(linkText = "Account")
	public WebElement accountBtn;
	
	@FindBy(id= "nameInput")
	public WebElement nameInput;
	
	@FindBy(id = "personalPhoneInput")
	public WebElement personalPhoneInput;
	
	@FindBy(id = "personalUpdateBtn")
	public WebElement personalUpdateBtn;
	
	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement profileUpdateSuccess;
	
	@FindBy(xpath = "//p[text()='Add a payment method']")
	public WebElement addPaymentMethodBtn;
	
	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberInput;
	
	@FindBy(id = "nameOnCardInput")
	public WebElement nameOnCardInput;
	
	@FindBy(id = "expirationMonthInput")
	public WebElement expirationMonthInput;
	
	@FindBy(id = "expirationYearInput")
	public WebElement expirationYearInput;
	
	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeInput;
	
	@FindBy(id = "paymentSubmitBtn")
	public WebElement paymentSubmitBtn;
	
	@FindBy(xpath = "//div[text()='Payment Method added sucessfully']")
	public WebElement cardInfoAddSuccess;
	
	@FindBy(xpath ="//p[@class=\"account__payment__sub-text\"][text()=\"3456\"]")
	public WebElement newCard;
	
	@FindBy(xpath ="//p[@class=\"account__payment__sub-text\"][text()=\"7654\"]")
	public WebElement newerCard;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div[3]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/button[1]")
	public WebElement editCardInfoBtn;
	
	@FindBy(xpath = "//div[text()='Payment Method updated Successfully']")
	public WebElement cardInfoUpdateSuccess;
	
	@FindBy(xpath = "//button[text()='remove']")
	public WebElement removeBtn;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div[3]/div/div[3]/div[1]/div")
	public WebElement addAddressBtn;
	
	@FindBy(id = "countryDropdown")
	public WebElement countryDropdown;
	
	@FindBy(id = "fullNameInput")
	public WebElement fullNameInput;
	
	@FindBy(id = "phoneNumberInput")
	public WebElement phoneNumberInput;
	
	@FindBy(id = "streetInput")
	public WebElement streetInput;
	
	@FindBy(id = "apartmentInput")
	public WebElement apartmentInput;
	
	@FindBy(id = "cityInput")
	public WebElement cityInput;

	@FindBy(xpath = "//*[@id=\"newForm\"]/div[5]/div[2]/div/div/select")
	public WebElement stateSelect;
	
	@FindBy(id = "zipCodeInput")
	public WebElement zipCodeInput;
	
	@FindBy(id = "addressBtn")
	public WebElement addressBtn;
	
	@FindBy(xpath = "//div[text()='Address Added Successfully']")
	public WebElement addressAddSuccess;
	
	@FindBy(xpath = "//p[text()=\"7654\"]")
	public WebElement cardExists;
	
	@FindBy(xpath = "//button[@class=\"account__address-btn\"][1]")
	public WebElement editAddressBtn;
	
	@FindBy(xpath = "//div[text()=\"Address Updated Successfully\"]")
	public WebElement updateAddressSuccess;

	@FindBy(xpath = "//button[@class=\"account__address-btn\"][text()=\"Remove\"]")
	public WebElement removeAddressBtn;
	
	@FindBy(xpath = "//p[text()=\"Russian Federation\"]")
	public WebElement newAddress;
}
