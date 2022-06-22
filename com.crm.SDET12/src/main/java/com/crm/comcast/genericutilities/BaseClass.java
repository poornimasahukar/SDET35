package com.crm.comcast.genericutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {
    public static WebDriver sdriver;
	public static WebDriver driver;
	public DataBaseUtility dLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public webDriverUtilities wLib=new webDriverUtilities();
	
	@BeforeSuite (groups = {"smokeTest","regressionTest"})//this line is used for group execution)
	public void dbConfig() {
		dLib.connectToDB();
		
	}
  //  @Parameters("BROWSER")  //this line is used to do cross browser execution and we add string Browser 
	@BeforeClass (groups = {"smokeTest","regressionTest"})
	
	public void launchTheBrowser() throws Throwable
	{
		String BROWSER=System.getProperty("browser");
		String URL=System.getProperty("url");
			
		//String BROWSER = fLib.getPropertyKeyValue("browser");
		//String  URL= fLib.getPropertyKeyValue("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver",".\\src\\main\\resources\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		//implicitly wait
	    sdriver=driver;
		wLib.waitForPageToLoad(driver);
		//enter the Url to the application
		sdriver.get(URL);
		//to maximize the window
		wLib.maximizeTheWindow(driver);
		
	}
	/**
	 * login to the application
	 * @throws Throwable
	 */
	@BeforeMethod (groups = {"smokeTest","regressionTest"})
	public void loginToApplication() throws Throwable {
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		LoginPage lpage = new LoginPage(driver);
		lpage.loginToApplication(USERNAME, PASSWORD);
		
	}
	/**
	 * logout from the application
	 */
	@AfterMethod (groups = {"smokeTest","regressionTest"})
	public void logoutFromApplication() {
		HomePage hpage = new HomePage(driver);
		hpage.logOut(driver);
	}
	/**
	 * close the browser
	 */
	@AfterClass (groups = {"smokeTest","regressionTest"})
	public void closeTheBrowser() {
		driver.quit();
		
	}
	@AfterSuite (groups = {"smokeTest","regressionTest"})
	public void closeDBconfig() {
		dLib.closeDB();
		
	}
	
}
