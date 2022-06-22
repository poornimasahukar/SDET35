package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutilities.webDriverUtilities;

public class CreatingNewContactPage extends webDriverUtilities {
	
	@FindBy(name = "firstname")
	//@FindBys({@FindBy(xpath = "//input[@style='width:58%;'] "),@FindBy(name = "'firstname'")})
	//input[@style='width:58%;' and @name='firstname']
	private WebElement firstnameTxtEdt;


	@FindBy(name = "lastname")
	private WebElement lastnameTxtEdt;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement selectOrgLkupImg;

	@FindBy(name = "search_text")
	private WebElement searchTxtEdt;

	@FindBy(name = "search")
	private WebElement searchBtn;

	@FindBy(xpath = "//a[.='Qspiders']")
	private WebElement selectOrgName;

	@FindBy(name = "title")
	private WebElement titleTxtEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(tagName = "input")
	private WebElement emailOptOut;

	@FindBy(name = "notify_owner")
	private WebElement notifyOwner;

	@FindBy(name = "portal")
	private WebElement portalUser;

	@FindBy(name = "reference")
	private WebElement referenceBox;


	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstnameTxtEdt() {
		return firstnameTxtEdt;
	}

	public WebElement getLastnameTxtEdt() {
		return lastnameTxtEdt;
	}

	public WebElement getSelectOrgLkupImg() {
		return selectOrgLkupImg;
	}

	public WebElement getSearchTxtEdt() {
		return searchTxtEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSelectOrgName() {
		return selectOrgName;
	}

	public WebElement getTitleTxtEdt() {
		return titleTxtEdt;

	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getEmailOptOut() {
		return emailOptOut;
	}

	public WebElement getNotifyOwner() {
		return notifyOwner;
	}

	public WebElement getPortalUser() {
		return portalUser;
	}

	public WebElement getReference() {
		return referenceBox;
	}
	
	public WebElement clickOnEmailOptOut() {
		emailOptOut.isEnabled();
		return emailOptOut;

	}
	public WebElement clickOnNotifyOwner() {
		notifyOwner.isEnabled();
		return notifyOwner;
	}
	public WebElement clickOnPortalUser() {
		portalUser.isEnabled();
		return portalUser;
	}
	public WebElement clickOnReference() {
		referenceBox.isEnabled();
		return referenceBox;
	}



	public void creatingNewContact(String firstName,String lastName,String titlename,WebDriver driver) {
		firstnameTxtEdt.sendKeys(firstName);
		lastnameTxtEdt.sendKeys(lastName);
		selectOrgLkupImg.click();
		switchToWindow(driver, "Popup&popuptype");
		searchTxtEdt.sendKeys("Qspiders");
		searchBtn.click();
		selectOrgName.click();
		switchToWindow(driver, "Administrator - Organizations");
		titleTxtEdt.sendKeys(titlename);
		saveBtn.click();
		
	}

	
}
