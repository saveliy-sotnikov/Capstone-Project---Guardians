package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities​​​​​​​.CommonUtility;

public class HomeSteps extends CommonUtility {
	
	POMFactory pomFactory = new POMFactory();
	
	
	
	@When("User click on All section")
	public void userClickOnAllSection() {
		click(pomFactory.home().allSection);
		logger.info("Clicked on 'All' section");
	}
	
	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> shopByDepartment = dataTable.asLists(String.class);
		for(int i = 0; i < shopByDepartment.get(0).size(); i++) {
			Assert.assertTrue(isElementDisplayed(getDriver().findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]//span[text()='" + shopByDepartment.get(0).get(i) + "']"))));
			logger.info("Option " + shopByDepartment.get(0).get(i) + " is displayed");
		}
		
	}
	
	@And("User on {string}")
	public void userOn(String department) {
		List<WebElement> departments = pomFactory.home().sidebarOptions;
		for(int i = 0; i < departments.size(); i++) {
			if(departments.get(i).getText().equalsIgnoreCase(department)) {
				departments.get(i).click();
				break;
			}
		}
		
	}
	
	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> departmentOptions = dataTable.asLists(String.class);
		List<WebElement> options = pomFactory.home().sidebarAllOptions;
		for(int i = 0; i < departmentOptions.get(0).size(); i++) {
			for(WebElement elements : options) {
				if(elements.getText().equalsIgnoreCase(departmentOptions.get(0).get(i))) {
					Assert.assertTrue(elements.isDisplayed());
					logger.info("'" + elements.getText() + "' option is present");
				}
			}
		}
	}
	

}
