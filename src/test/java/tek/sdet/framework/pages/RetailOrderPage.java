package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailOrderPage extends BaseSetup {

	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id = "search")
	public WebElement category;
	
	@FindBy(xpath = "//*[@id=\"search\"]/option[4]")
	public WebElement smartHomeBtn;
	
	@FindBy(id = "searchInput")
	public WebElement searchBar;
	
	@FindBy(id = "searchBtn")
	public WebElement searchBtn;
					
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div[3]/div/div/p[1]")
	public WebElement itemBtn;

	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div[3]/div/div[1]/div[3]/div/div/select")
	public WebElement quantity;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div[3]/div/div[1]/div[3]/div/div/select/option[2]")
	public WebElement quantity2;
	
	@FindBy(id = "addToCartBtn")
	public WebElement addToCartBtn;
	
	@FindBy(xpath = "//span[text()=\"2\"]")
	public WebElement cartQuantity2;
	
	@FindBy(xpath = "//*[@id=\"search\"]/option[2]")
	public WebElement electronicsBtn;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div[3]/div/div[1]/div[3]/div/div/select/option[5]")
	public WebElement quantity5;
	
	@FindBy(id = "cartBtn")
	public WebElement cartBtn;
	
	@FindBy(id = "proceedBtn")
	public WebElement proceedBtn;
	
	@FindBy(id = "placeOrderBtn")
	public WebElement placeOrderBtn;
	
	@FindBy(xpath = "//div[text()='Order Placed Successfully']")
	public WebElement orderPlaceSuccess;
	
	@FindBy(id = "orderLink")
	public WebElement orderLink;
	
	@FindBy(id = "cancelBtn")
	public WebElement cancelBtn;
	
	@FindBy(id = "reasonInput")
	public WebElement reasonInput;
	
	@FindBy(xpath = "//option[text()=\"Bought wrong item\"]")
	public WebElement boughtWrongItem;
	
	@FindBy(xpath = "//div[@class=\"order__cancel\"]")
	public WebElement cancelOrderPage;
	
	@FindBy(id = "orderSubmitBtn")
	public WebElement finalCancelBtn;
	
	@FindBy(xpath = "//p[text()=\"Your Order Has Been Cancelled\"]")
	public WebElement cancelSuccess;
	
	@FindBy(id = "buyAgainBtn")
	public WebElement buyAgainBtn;
	
	@FindBy(id = "returnBtn")
	public WebElement returnBtn;
	
	@FindBy(id = "dropOffInput")
	public WebElement dropOffInput;
	
	@FindBy(xpath = "//option[@value=\"fedex\"]")
	public WebElement fedEx;
	
	@FindBy(id = "orderSubmitBtn")
	public WebElement orderSubmitBtn;
	
	@FindBy(xpath = "//p[text()=\"Return was successfull\"]")
	public WebElement returnSuccess;
	
	@FindBy(id = "reviewBtn")
	public WebElement reviewBtn;
	
	@FindBy(id = "headlineInput")
	public WebElement headlineInput;
	
	@FindBy(id = "descriptionInput")
	public WebElement descriptionInput;
	
	@FindBy(id = "reviewSubmitBtn")
	public WebElement reviewSubmitBtn;
	
	@FindBy(xpath = "//div[text()=\"Your review was added successfully\"]")
	public WebElement reviewSuccess;
	
	@FindBy(xpath = "//span[@class=\"cart__item-delete\"]")
	public WebElement deleteBtn;
}
