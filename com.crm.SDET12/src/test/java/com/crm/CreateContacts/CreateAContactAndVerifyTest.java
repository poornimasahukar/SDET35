package com.crm.CreateContacts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutilities.BaseClass;
import com.crm.objectRepository.ContactsInfoPage;
import com.crm.objectRepository.ContactsPage;
import com.crm.objectRepository.CreatingNewContactPage;
import com.crm.objectRepository.HomePage;
@Listeners
public class CreateAContactAndVerifyTest extends BaseClass{
	//public static void main(String[] args) throws Throwable {
	@Test(groups= "smokeTest")
	public void createAContactAndVerifyTest() throws Throwable {
		/*WebDriver driver=null;
		webDriverUtilities wLib = new webDriverUtilities();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();



		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");*/


		// to Fetch the random number for same name
		int radnum = jLib.getRandomNumber();

		/*if(BROWSER.equalsIgnoreCase("firefox")) {
			System.setProperty(IpathConstants.firefoxkey, IpathConstants.firefoxpath);

			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("chrome")) {
			System.setProperty(IpathConstants.chromekey, IpathConstants.chromepath);

			driver=new ChromeDriver();
		}else {
			driver=new ChromeDriver();
		}


		// It will wait for the Page to load
		wLib.waitForPageToLoad(driver);

		//it will maximize the window after login
		wLib.maximizeTheWindow(driver);

		//it will get Url from property
		driver.get(URL);

		//login to the application by entering username and password
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApplication(USERNAME, PASSWORD);*/

		//it will take the screenshot after login
		//wLib.takesScreenShot(driver, BROWSER);

		//home page is opened and click on contact link
		HomePage homepage = new HomePage(driver);
		homepage.getContactslink().click();

		//contact page is opened 
		ContactsPage contLkup = new ContactsPage(driver);
		contLkup.clickonCreateContactBtn();

		//fetch the data from the excel sheet
		String contactname = eLib.getExcelUtility("Contacts",1, 2)+radnum;
		String lastname = eLib.getExcelUtility("Contacts", 2, 2)+radnum;
		String titlename=eLib.getExcelUtility("Contacts", 1, 4)+radnum;

		CreatingNewContactPage cnewContact = new CreatingNewContactPage(driver);
		cnewContact.creatingNewContact(contactname, lastname, titlename, driver);

		//verifing the contact is present or not
		ContactsInfoPage cname = new ContactsInfoPage(driver);
		String ele = cname.getContactHeadTxt().getText();
		SoftAssert ass = new SoftAssert();
		ass.assertTrue(ele.contains(contactname));
		System.out.println("Contact is present ");
		ass.assertAll();



		/*if(ele.contains(contactname)) {
			System.out.println("Contact is present ");
		}else {
			System.out.println("Contact is not present ");

		}
		//application is closed
	//	driver.close();*/
	}
}





