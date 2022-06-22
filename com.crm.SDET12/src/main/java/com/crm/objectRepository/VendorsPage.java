package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {

	@FindBy(xpath ="//img[@ src='themes/softed/images/btnL3Add.gif']")
	private WebElement createVendorLink;

	public VendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnCreateVendorBtn() {
		createVendorLink.click();

	}
}

