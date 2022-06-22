package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationsPage {
// declaration
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLkpUpImg;
	
	//initialization
	
	public  OrganisationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public  void clickOnCreateOrgLkp() {
		createOrgLkpUpImg.click();
	}
	
}
