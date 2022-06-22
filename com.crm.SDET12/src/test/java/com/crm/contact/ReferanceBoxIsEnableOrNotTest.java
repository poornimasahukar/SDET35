package com.crm.contact;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutilities.BaseClass;
import com.crm.objectRepository.ContactsPage;
import com.crm.objectRepository.CreatingNewContactPage;
import com.crm.objectRepository.HomePage;

public class ReferanceBoxIsEnableOrNotTest extends BaseClass {
	
	@Test
	public void referanceBoxIsEnableOrNotTest() throws Throwable{
	/*public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		webDriverUtilities wLib=new webDriverUtilities();*/
		
		/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Properties\\data.properties.txt");
		Properties pres = new Properties();
		pres.load(fis);*/

		//To store the values in Reference variable
	/*	String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");*/

		//To get random Numbers
		int randnum = jLib.getRandomNumber();
		//Random random = new Random();
		//int randnum = random.nextInt(500);

		//To Fetch the data From Excel sheet
		String contName = eLib.getExcelUtility("Contact", 2, 2)+randnum;
		String titlename=eLib.getExcelUtility("Contacts", 1, 4)+randnum;
		/*FileInputStream fileinput = new FileInputStream(".\\src\\test\\resources\\Excel\\Contact1.xlsx");
		Workbook book = WorkbookFactory.create(fileinput);
		Sheet sheet = book.getSheet("sheet1");
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(2);
		String value = cell.toString();
		String contName = value+randnum;*/
		
		String lastname = eLib.getExcelUtility("Contact", 2, 3)+randnum;
		/*Row row1 = sheet.getRow(2);
		Cell cell1 = row1.getCell(3);
		String value1 = cell1.toString();
		String lastname=value1+randnum;*/

		//To Lanch the Browser
	/*	if(BROWSER.equalsIgnoreCase("firefox")) {
			System.setProperty(IpathConstants.firefoxkey, IpathConstants.firefoxpath);
		//	WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("chrome")) {
			System.setProperty(IpathConstants.chromekey, IpathConstants.chromepath);
		//	WebDriverManager.chromedriver().setup();
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
		loginpage.loginToApplication(USERNAME, PASSWORD);
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).submit();*/

		//To create a contact
		HomePage hpage = new HomePage(driver);
		hpage.getContactslink().click();
	//	driver.findElement(By.xpath("//a[.='Contacts']")).click();
		
		ContactsPage contactpage = new ContactsPage(driver);
		contactpage.clickonCreateContactBtn();
	//	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		CreatingNewContactPage contactspage = new CreatingNewContactPage(driver);
		contactspage.creatingNewContact(contName, lastname, titlename, driver);
		/*driver.findElement(By.name("firstname")).sendKeys(contName);
		driver.findElement(By.name("lastname")).sendKeys(lastname);*/
		
		//Take screenshot after login to page
		//wLib.takesScreenShot(driver,BROWSER);

		//To check reference Check box and verify 
		WebElement ele = contactspage.clickOnReference();
	//	WebElement ele = driver.findElement(By.name("reference"));
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(ele.isEnabled());
		System.out.println("reference Box is Enabled and pass");
		soft.assertAll();
		/*if(ele.isEnabled()) {
			System.out.println("reference Box is Enabled");
		}else {
			System.out.println("reference Box is not Enabled");
		}*/
		
      //   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//mouse over on Administrator and click on signout
		
		//hpage.logOut(driver);
		//WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Actions action = new Actions(driver);
		//action.moveToElement(ele1).perform();
     //  wLib.mouseOverAnElement(driver, ele1);
		//click on Sign out
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		//close the driver
		//driver.close();

	}
}


