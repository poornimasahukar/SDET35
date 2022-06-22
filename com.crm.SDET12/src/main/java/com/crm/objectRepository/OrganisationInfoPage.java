package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ognHeaderTxt;

	
	//initialization
	public OrganisationInfoPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//utilization
	public WebElement getOgnHeaderTxt() {
		return ognHeaderTxt;
	}
}