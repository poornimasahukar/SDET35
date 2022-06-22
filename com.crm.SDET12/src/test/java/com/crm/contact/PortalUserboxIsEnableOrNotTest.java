package com.crm.contact;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutilities.BaseClass;
import com.crm.objectRepository.ContactsPage;
import com.crm.objectRepository.CreatingNewContactPage;
import com.crm.objectRepository.HomePage;

public class PortalUserboxIsEnableOrNotTest extends BaseClass {
	
	

	@Test
	public void portalUserboxIsEnableOrNotTest() throws Throwable{
	/*public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();
		webDriverUtilities wLib=new webDriverUtilities();*/
		
		//to fetch the data from the Property Files
		
		
		/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Properties\\data.properties.txt");
		Properties pres = new Properties();
		pres.load(fis);*/

		//To store the values in Reference variable
	/*	String URL =fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");*/

		//To get random Numbers
		int randnum = jLib.getRandomNumber();
		//Random random = new Random();
		//int randnum = random.nextInt(500);

		//To Fetch the data From Excel sheet
		String contName = eLib.getExcelUtility("Contact", 4, 2)+randnum;
		String titlename=eLib.getExcelUtility("Contacts", 1, 4)+randnum;
		/*FileInputStream fileinput = new FileInputStream(".\\src\\test\\resources\\Excel\\Contact1.xlsx");
		Workbook book = WorkbookFactory.create(fileinput);
		Sheet sheet = book.getSheet("sheet1");
		Row row = sheet.getRow(4);
		Cell cell = row.getCell(2);
		String value = cell.toString();
		String contName = value+randnum;*/
		
		String lastname = eLib.getExcelUtility("Contact", 4, 3)+randnum;
		/*Row row1 = sheet.getRow(4);
		Cell cell1 = row1.getCell(3);
		String value1 = cell1.toString();
		String lastname=value1+randnum;*/

		//To Lanch the Browser
	/*	if(BROWSER.equalsIgnoreCase("firefox")) {
			System.setProperty(IpathConstants.firefoxkey, IpathConstants.firefoxpath);
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("chrome")) {
			System.setProperty(IpathConstants.chromekey, IpathConstants.chromepath);
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else {
			driver=new ChromeDriver();
		}

		//add implicitlyWait statement
		wLib.waitForPageToLoad(driver);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//To login to the application
		driver.get(URL);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApplication(USERNAME, PASSWORD);*/
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).submit();*/

		//To create a contact
		HomePage homepage = new HomePage(driver);
		homepage.getContactslink().click();
	//	driver.findElement(By.xpath("//a[.='Contacts']")).click();
		
		ContactsPage cpage = new ContactsPage(driver);
		cpage.clickonCreateContactBtn();
	//	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		CreatingNewContactPage contactpage = new CreatingNewContactPage(driver);
		contactpage.creatingNewContact(contName, lastname, titlename, driver);
	/*	driver.findElement(By.name("firstname")).sendKeys(contName);
		driver.findElement(By.name("lastname")).sendKeys(lastname);*/
		
        // wLib.takesScreenShot(driver, BROWSER);
         
         
		//To check portalUser Check box and Verify
        WebElement ele = contactpage.clickOnPortalUser();
        Assert.assertTrue(ele.isEnabled());
        System.out.println("Portal opt out Box is Enabled and pass");
	/*	if(ele.isEnabled()) {
			System.out.println("Portal opt out Box is Enabled");
		}else {
			System.out.println("Portal opt out Box is not Enabled");
		}*/

		//mouse over on Administrator and click on Sign Out
		//homepage.logOut(driver);
	
	
		//close the driver
	//	driver.close();

	}
}
