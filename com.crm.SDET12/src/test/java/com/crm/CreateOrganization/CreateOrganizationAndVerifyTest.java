package com.crm.CreateOrganization;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutilities.BaseClass;
import com.crm.objectRepository.CreatingNewOrganizationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.OrganisationInfoPage;
import com.crm.objectRepository.OrganisationsPage;

public class CreateOrganizationAndVerifyTest extends BaseClass{
	//public static void main(String[] args) throws Throwable {
@Test(groups="regressionTest")
public void createOrganizationAndVerifyTest() throws Throwable {
	
		//WebDriver driver=null;
		/*FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		webDriverUtilities wLib = new webDriverUtilities();*/

		/*	FileInputStream Fis = new FileInputStream(".\\src\\test\\resources\\Properties\\data.properties.txt");
        Properties pres=new Properties();
        pres.load(Fis);*/

		/*String URL = fLib.getPropertyKeyValue("url");
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

		//	String productname = "Qspiders";
		int randNum = jLib.getRandomNumber();

		/*	Random random = new Random();
        int randNum = random.nextInt();*/


		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		//wLib.waitForPageToLoad(driver);
		//  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	driver.get(URL);

	//	LoginPage login = new LoginPage(driver);
		//login.loginToApplication(USERNAME, PASSWORD);
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).submit();*/

		//click on organization link
		HomePage hpage = new HomePage(driver);
		hpage.getOrganizationlink().click();

		//driver.findElement(By.xpath("//a[.='Organizations']")).click();

		OrganisationsPage orgpage = new OrganisationsPage(driver);
		orgpage.clickOnCreateOrgLkp();
		
		//	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		//enter the organization information,phone number and switch to other window
		String productname = eLib.getExcelUtility("Organization", 1, 2);
		String phonenum = eLib.getExcelUtility("Organization", 1, 3);
		CreatingNewOrganizationPage createorgname = new CreatingNewOrganizationPage(driver);
		createorgname.enterOrgInfo(productname+randNum, driver, phonenum );
	

		
		OrganisationInfoPage orginfopage = new OrganisationInfoPage(driver);
		String presentOrgName = orginfopage.getOgnHeaderTxt().getText();
		 Assert.assertTrue(presentOrgName.contains(productname));
		    System.out.println("createOrganizationAndVerifyTest is pass");

		//	String ele3 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	/*	if(presentOrgName.contains(productname)) {
			System.out.println("Organization is present");
		}else {
			System.out.println("Organization is not present");
		}

		//mouse over on Administrator and signOut
	//	hpage.logOut(driver);
		
		//application is closed
	//	driver.close();*/

	}
}
