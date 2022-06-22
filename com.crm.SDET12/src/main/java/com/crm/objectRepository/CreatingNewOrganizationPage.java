package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutilities.webDriverUtilities;

public class CreatingNewOrganizationPage extends webDriverUtilities {
	@FindBy(name = "accountname")
	private WebElement organisationTextEdt;

	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name="industry")
	private WebElement industryDropdown;

	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement selectOrgLupimg;
	
	@FindBy(name = "search_text")
	private WebElement searchTxtEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//a[.='Qspiders']")
	private WebElement selectOrgName;
	
	@FindBy(name = "phone")
	private WebElement phonenumbtext;
	
	
	//initialization

	public CreatingNewOrganizationPage(WebDriver driver){
		PageFactory.initElements(driver, this);

	}
	//initialization


	public WebElement getOrganisationTextEdt() {
		return organisationTextEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	
	public WebElement getSelectOrgLupimg() {
		return selectOrgLupimg;
		
	}
	public WebElement getPhonenumbtext() {
		return phonenumbtext;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public WebElement getSearchTxtEdt() {
		return searchTxtEdt;
	}


	public WebElement getSelectOrgName() {
		return selectOrgName;
	}


	/**
	 * Utilization
	 */
	public void enterOrgInfo(String OrganisationName,WebDriver driver,String phonenum ) {
		organisationTextEdt.sendKeys(OrganisationName);
		phonenumbtext.sendKeys(phonenum);
		selectOrgLupimg.click();
        switchToWindow(driver, "Popup&popuptype");
        searchTxtEdt.sendKeys("Qspiders");
        searchBtn.click();
        selectOrgName.click();
        switchToAlertPopupAndAccept(driver);
        switchToWindow(driver, "Administrator - Organizations");
        saveBtn.click();
	}
	
	public void setOrganisationTextEdt(WebElement organisationTextEdt) {
		this.organisationTextEdt=organisationTextEdt;
		
	}
	public void selectIndustry(String Industry) {
		selectDropDown(industryDropdown,Industry);
	}
	public void selectType(String Type) {
		selectDropDown(typeDropDown,Type);
		
	}
}
