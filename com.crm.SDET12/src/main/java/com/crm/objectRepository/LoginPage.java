package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutilities.FileUtility;

public class LoginPage extends FileUtility{
	/**
	 * element declaration
	 */
	@FindBy(name="user_name")
	private WebElement userNametxt;

	@FindBy(name="user_password")
	private WebElement passWordtext;

	@FindBy(id="submitButton")
	private WebElement submitBtn;

	/**
	 * initialization
	 * 
	 */
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	//utilization

	public WebElement getUserNametxt() {
		return userNametxt;
	}

	public WebElement getPassWordtext() {
		return passWordtext;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	/**
	 * business libraries
	 */

	public void loginToApplication(String userName,String passWord) {
		userNametxt.sendKeys(userName);
		passWordtext.sendKeys(passWord);
		submitBtn.click();
	}

}
