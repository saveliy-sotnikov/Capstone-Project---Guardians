package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup{
	
	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(linkText = "TEKSCHOOL")
	public WebElement tekSchoolLogo;
	
	@FindBy(xpath = "//*[@id=\"hamburgerBtn\"]/span")
	public WebElement allSection;
	
	@FindBy(xpath = "//*[@id=\"sidebar\"]/div[2]//span")
	public List<WebElement> sidebarOptions;
	
	@FindBy(xpath = "//*[@id=\"sidebar\"]/div[2]/div//span")
	public List<WebElement> sidebarAllOptions;

}
