package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutilities.webDriverUtilities;

public class CreatingNewVendorPage extends webDriverUtilities {

	@FindBy(xpath = "//input[@name='vendorname']")
	private WebElement vendorName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreatingNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorName() {
		return vendorName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void enterVendorsInfo(String Vendorname,WebElement element) {
		vendorName.sendKeys(Vendorname);
		selectDropDownByVisibleText(element, "302-Rental-Income");
		
	}
	
	
	
	
	
}
