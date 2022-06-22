package com.crm.CreateOrganization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutilities.BaseClass;
import com.crm.objectRepository.CreatingNewOrganizationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.OrganisationInfoPage;
import com.crm.objectRepository.OrganisationsPage;

public class CreateOrganizationByUsingIndustryTest extends BaseClass {
	//public static void main(String[] args) throws Throwable {
	@Test(groups= "smokeTest")
	public void createOrganizationByUsingIndustryTest() throws Throwable {

		//public WebDriver driver;
		/*FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		webDriverUtilities wLib = new webDriverUtilities();

		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");

		if(BROWSER.equalsIgnoreCase("firefox")) {
			System.setProperty(IpathConstants.firefoxkey, IpathConstants.firefoxpath);
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("chrome")) {
			System.setProperty(IpathConstants.chromekey, IpathConstants.chromepath);
			WebDriverManager.firefoxdriver().setup();
			driver=new ChromeDriver();

		}else {
			driver=new ChromeDriver();
		}*/

		//it will give the random number
		int randNum = jLib.getRandomNumber();

		//it will wait for the page to Load
		wLib.waitForPageToLoad(driver);

		//Loing in to the application and enter username and password
	/*	driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(USERNAME, PASSWORD);*/

		// navigate to home page and click on Organization link
		HomePage homepage = new HomePage(driver);
		homepage.getOrganizationlink().click();

		//click on Create new Organization Lookup button
		OrganisationsPage orgpage = new OrganisationsPage(driver);
		orgpage.clickOnCreateOrgLkp();
		Thread.sleep(2000);

		//enter the organization name and phone number and click on orglookup page
		String productname = eLib.getExcelUtility("Organization", 1, 2);
		String phonenum = eLib.getExcelUtility("Organization", 1, 3);
		CreatingNewOrganizationPage createorgname = new CreatingNewOrganizationPage(driver);
		createorgname.enterOrgInfo(productname+randNum, driver, phonenum+randNum);


		//select the industry Dropdown and select Biotechnology
		String industrydropdown = eLib.getExcelUtility("Organization", 4, 6);
		createorgname.selectIndustry(industrydropdown);

		//select the type dropdown and select Analyst
		String typedropdown = eLib.getExcelUtility("Organization", 2, 5);
		createorgname.selectType(typedropdown);


		//verify the Organization name is present or not
		OrganisationInfoPage orginfopage = new OrganisationInfoPage(driver);
		String ele3 = orginfopage.getOgnHeaderTxt().getText();
		SoftAssert ass = new SoftAssert();
		ass.assertTrue( ele3.contains(productname));
		System.out.println("Contact is present ");
		ass.assertAll();

	/*	if(ele3.contains(productname)) {
			System.out.println("Organization is present industry");
		}else {
			System.out.println("Organization is not present industry");
		}
		//mouse over on Administrator and click on logout
	//	homepage.logOut(driver);

		//close the driver
	//	driver.close();*/

	}
}

