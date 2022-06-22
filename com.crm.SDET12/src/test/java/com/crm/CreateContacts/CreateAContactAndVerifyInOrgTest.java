package com.crm.CreateContacts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutilities.BaseClass;
import com.crm.objectRepository.ContactsInfoPage;
import com.crm.objectRepository.ContactsPage;
import com.crm.objectRepository.CreatingNewContactPage;
import com.crm.objectRepository.HomePage;
@Listeners(com.crm.comcast.genericutilities.ItestListernerImtn.class)
public class CreateAContactAndVerifyInOrgTest extends BaseClass{
	
	//	public static void main(String[] args) throws Throwable {
	
	@Test(retryAnalyzer=com.crm.comcast.genericutilities.RetryImpClass.class)
			public void createAContactAndVerifyInOrgTest() throws Throwable {
			/*WebDriver driver=null;
			ExcelUtility eLib = new ExcelUtility();
			JavaUtility jLib = new JavaUtility();
			FileUtility fLib = new FileUtility();
			webDriverUtilities wLib = new webDriverUtilities();
			
			
		//fetching.........	
	        //fetch the data from property file
	        String URL = fLib.getPropertyKeyValue("url");
	        String USERNAME = fLib.getPropertyKeyValue("username");
	        String PASSWORD = fLib.getPropertyKeyValue("password");
	        String BROWSER = fLib.getPropertyKeyValue("browser");

			
	       //To launch the browser
	        if(BROWSER.equalsIgnoreCase("firefox")) {
	        	System.setProperty(IpathConstants.firefoxkey, IpathConstants.firefoxpath);
				
				driver=new FirefoxDriver();
			}else if(BROWSER.equalsIgnoreCase("chrome")) {
				System.setProperty(IpathConstants.chromekey, IpathConstants.chromepath);
				
				driver=new ChromeDriver();
			}else {
				driver=new ChromeDriver();
			}
	        
	        //it will wait for the page to load
				wLib.waitForPageToLoad(driver);
	        
			//pass the url
			driver.get(URL);
			
			//Login to the application and click on submit button
			LoginPage login = new LoginPage(driver);
			login.loginToApplication(USERNAME, PASSWORD);*/
				
				
			 //create the contact click on contacts link
			HomePage home = new HomePage(driver);
			home.getContactslink().click();
			//driver.findElement(By.xpath("//a[.='Contacts']")).click();
			
			
			ContactsPage ccontact = new ContactsPage(driver);
			ccontact.clickonCreateContactBtn();
			//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			
			
			//fetch the data from the excel sheet
			 int radnum = jLib.getRandomNumber();
			String contactname = eLib.getExcelUtility("Contacts",1, 2)+radnum;
			String lastname = eLib.getExcelUtility("Contacts", 2, 2)+radnum;
			String titlename=eLib.getExcelUtility("Contacts", 1, 4)+radnum;
			Assert.fail();

			CreatingNewContactPage cnewContact = new CreatingNewContactPage(driver);
			cnewContact.creatingNewContact(contactname, lastname, titlename, driver);
          

			ContactsInfoPage cnameverify = new ContactsInfoPage(driver);
			String ele3 = cnameverify.getContactHeadTxt().getText();
			
		    Assert.assertTrue(ele3.contains(contactname));
		    System.out.println("createAContactAndVerifyInOrgTest is pass");
			
		/*	if(ele3.contains(contactname)) {
				System.out.println("Contact is present in Org");
			}else {
				System.out.println("Contact is not present in Org");
			}
		//	driver.close();*/
		}
		
	}


