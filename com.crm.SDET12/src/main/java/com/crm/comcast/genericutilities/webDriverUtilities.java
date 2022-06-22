package com.crm.comcast.genericutilities;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * Contains all reusable Actions of Webdriver
 * @author indir
 *
 */
public class webDriverUtilities {
	/*
	 * it's an implicitly wait Always wait for Element in DOM document & release the control if element available
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * it's an Explicitly wait Always wait for page to be loaded & available In GUI
	 * @param driver
	 */

	public void waitForPageToLoadForJSElement(WebDriver driver) 
	{
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	/**
	 * its an Explicitly wait always wait for page to be loaded & available In GUI
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	/**
	 * used to switch to any window based on window title
	 * @param driver
	 * @param title
	 */
	public void waitForTitleContains(WebDriver driver, String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * Here we can change the polling from default time 500ms to any polling Time
	 * @param driver
	 * @param pollingTime
	 * @param element
	 */
	public void waitForElementToCustom(WebDriver driver,int pollingTime,WebElement element)
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	/**
	 * here we are giving custom timeout 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException 
	{
		int count=0;
		while(count<10) {
			try {
				element.click();
			}catch(Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * used to switch to any window based on window title
	 * @param driver
	 * @param partialWindow
	 */
	public void switchToWindow(WebDriver driver,String partialWindow)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String wTle = it.next();	
			driver.switchTo().window(wTle);
			String currentwindow = driver.getTitle();
			if(currentwindow.contains(partialWindow)) 
			{
				break;
			}
		}
	}
	/**
	 * switch from one frame to another Frame by using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * switch from one frame to another Fraom by using id_Attribute
	 * @param driver
	 * @param id_attribute
	 */
	public void switchToFrame(WebDriver driver,String id_attribute)
	{
		driver.switchTo().frame(id_attribute);

	}
	/**
	 * switch from one frame to another frame by using absolute_path
	 * @param driver
	 * @param Element
	 */
	public void switchToFrame(WebDriver driver,WebElement Element)
	{
		driver.switchTo().frame(Element);
	}
	/**
	 * it is used to switch back from one child frame to  parent frame
	 * @param driver
	 */
	public void switchBackToMainPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * used to switch to alert window &click on ok  button
	 * @param driver
	 */
	public void switchToAlertPopupAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * used to switch to alert window &click on cancel button
	 * @param driver
	 */
	public void switchToAlertPopupAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * it is used to select the value from the Drop_down  based on index value
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * it is used to select the value from the Drop_down  based on value
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * it is used to select the value from the Drop_down  based on visible text
	 * @param element
	 * @param Value
	 */
	public void selectDropDownByVisibleText(WebElement element,String Value)
	{
		Select select = new Select(element);
		select.selectByVisibleText(Value);
	}
	/**
	 *used to place the mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverAnElement(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * it is used to right click on the specific element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * pass enter key appertain in to browser
	 * @param driver
	 */
	public void clickOnEnterButton(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * it is used to take the Screen shot when we found any defect
	 * @param driver
	 * @param sheetname
	 * @throws Throwable
	 */
	public void takesScreenShot(WebDriver driver,String sheetname) throws Throwable
	{
		TakesScreenshot tss = (TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+sheetname+".PNG");
		Files.copy(src, dst);
	}
	/**
	 * it is used to Scroll the window using x-axis and y-Axis
	 * @param driver
	 */

	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor javaScript = (JavascriptExecutor)driver;
		javaScript.executeScript("window.scrollBy(0,500)");
	}
	/**
	 * it is used to Maximize the window
	 * @param driver
	 */
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
}
