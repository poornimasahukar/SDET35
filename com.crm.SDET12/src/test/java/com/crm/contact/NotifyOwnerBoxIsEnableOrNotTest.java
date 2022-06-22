package com.crm.contact;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutilities.BaseClass;
import com.crm.objectRepository.ContactsPage;
import com.crm.objectRepository.CreatingNewContactPage;
import com.crm.objectRepository.HomePage;

public class NotifyOwnerBoxIsEnableOrNotTest extends BaseClass{
	
	@Test
	public void notifyOwnerBoxIsEnableOrNotTest() throws Throwable {
	/*public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		webDriverUtilities wLib=new webDriverUtilities();



		//To store the values in Reference variable
		String URL =fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");*/

		//To get random Numbers.........
		int randnum = jLib.getRandomNumber();


		//To Fetch the data From Excel sheet contactname lastname and title name
		String contName = eLib.getExcelUtility("Contact", 3, 2)+randnum;
		String titlename=eLib.getExcelUtility("Contacts", 1, 4)+randnum;
		String lastname = eLib.getExcelUtility("Contact", 3, 3)+randnum;

		//To Launch the Browser
		/*if(BROWSER.equalsIgnoreCase("firefox")) {
			System.setProperty(IpathConstants.firefoxkey, IpathConstants.firefoxpath);
			//WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("chrome")) {
			System.setProperty(IpathConstants.chromekey, IpathConstants.chromepath);
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else {
			driver=new ChromeDriver();
		}

		//add implicitlyWait statement
		wLib.waitForPageToLoad(driver);

		//it is used to maximize the window
		wLib.maximizeTheWindow(driver);

		//To login to the application and enter user name and password and click on Submit button
		driver.get(URL);

		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApplication(USERNAME, PASSWORD);*/


		//To create a contact click on contacts link in Home page
		HomePage homepage = new HomePage(driver);
		homepage.getContactslink().click();

		//to create new contact click on create new contact button
		ContactsPage clickoncontact = new ContactsPage(driver);
		clickoncontact.clickonCreateContactBtn();


		//Enter Firstname Lastname and Title name And click on organization button		
		CreatingNewContactPage createnewcontact = new CreatingNewContactPage(driver);
		createnewcontact.creatingNewContact(contName, lastname, titlename, driver);

		//it is used to scroll the window
		wLib.scrollBarAction(driver);
		//To click on NotifyOwner Check box and verify 
		WebElement ele = createnewcontact.clickOnNotifyOwner();
		Assert.assertTrue(ele.isEnabled());
		System.out.println("Notify Box is Enabled and pass");
		/*if(ele.isEnabled()) {
			System.out.println("Notify Box is Enabled");
		}else {
			System.out.println("Notify Box is not Enabled");
		}*/
		

		//mouse over on Administrator and click on sign out
	//	homepage.logOut(driver);

		//close the driver
	//	driver.close();

	}
}

