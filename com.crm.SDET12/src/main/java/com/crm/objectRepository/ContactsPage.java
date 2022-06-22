package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	//declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactBtn;

	// initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization
	public void clickonCreateContactBtn() {
		createContactBtn.click();
	}

}
