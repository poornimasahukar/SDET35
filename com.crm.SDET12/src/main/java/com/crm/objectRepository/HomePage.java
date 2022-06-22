package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutilities.webDriverUtilities;
/**
 * Declaration
 * @author indir
 *
 */
public class HomePage extends webDriverUtilities{
 
	@FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organizationlink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactslink;
	
	@FindBy(linkText = "Products")
	private WebElement productslink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorlink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(xpath = "//a[.='Vendors']")
	private WebElement vendorsLink;
	
	/**
	 * initialization
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
/**
 * Utilization
 * @return
 */
	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getContactslink() {
		return contactslink;
	}

	public WebElement getProductslink() {
		return productslink;
	}

	public WebElement getMoreLink() {
		return moreLink;
		
	}
	public WebElement getAdminitratorlink() {
		return administratorlink;
	}
	
	public WebElement getSignOutBtn() {
		return signOutLink;
	}
	public WebElement getVendorLink() {
		return vendorsLink;
	}
	
	public void moveToAnElement(WebDriver driver) {
		mouseOverAnElement(driver, moreLink);
	}
	
	public void logOut(WebDriver driver) {
		mouseOverAnElement(driver,administratorlink );
		signOutLink.click();
	}
}
