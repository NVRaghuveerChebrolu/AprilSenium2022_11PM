package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer;
import com.utility.LibraryFunctions;
import com.utility.ObjectRepository;
import com.utility.ObjectRepository2;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidatingMouseOperations extends LibraryFunctions{
	@Test(priority = 1)
	public void ValidateMouseOpeartionRightClick() throws InterruptedException {
		System.out.println("inside ValidateMouseOpeartionRightClick");
		driver.navigate().to(objProp.getProperty("mouseOpeartionRightClick"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		waitForPageToLoad();
		WebElement element = LibraryFunctions.FindElementByLocator(ObjectRepository2.MouseOperationRightClick);
		Actions ObjActions = new Actions(driver);
		ObjActions.contextClick(element).build().perform();  // to perform mouse right click operation 
		Thread.sleep(8000);
		WebElement DeleteElement = LibraryFunctions.FindElementByLocator(ObjectRepository2.SelectDeleteOptionInRightClick);
		ObjActions.click(DeleteElement).build().perform(); // to perform mouse click operation 
		Alert ObjAlert = driver.switchTo().alert();
		String AlertText = ObjAlert.getText();
		System.out.println("AlertText:"+AlertText);
		Assert.assertEquals(AlertText, objProp.getProperty("mouseOpeartionRightclickDeleteActionText"));
		ObjAlert.accept();
	}
	
	@Test(priority = 2)
	public void ValidateMouseOpeartionDoubleClick() throws InterruptedException {
		System.out.println("inside ValidateMouseOpeartionDoubleClick");
		driver.navigate().to(objProp.getProperty("mouseOpeartionDoubleClick"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		waitForPageToLoad();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");// to scroll vertically downward by 500 pixels
		//js.executeScript("window.scrollBy(0,-500)");// to scroll vertically upward by 500 pixels
		//js.executeScript("window.scrollBy(300,0)");// to scroll horizontally right side by 300 pixels
		//js.executeScript("window.scrollBy(-350,0)");// to scroll horizontally left side by 350 pixel
		
		WebElement element = LibraryFunctions.FindElementByLocator(ObjectRepository2.Frame);
		LibraryFunctions.ScrollIntoViewWithWebElement(element);
		driver.switchTo().frame(element);
		Actions objActions = new Actions(driver);
		WebElement DoubleClickBox = LibraryFunctions.FindElementByLocator(ObjectRepository2.BoxInsideFrame);
		objActions.doubleClick(DoubleClickBox).build().perform();//to perform mouse double click operation 
		
		//verify the back ground color of BOX (webElement)
		String BackGroundColorOfBox  = DoubleClickBox.getCssValue("background-color");
		System.out.println("BackGroundColorOfBox"+BackGroundColorOfBox);
		Assert.assertEquals(BackGroundColorOfBox, objProp.getProperty("BoxYellowColor") );
		
	}
	
	@Test(priority = 3)
	public void ValidateMouseOpeartionDrapAndDrop() throws InterruptedException {
		System.out.println("inside ValidateMouseOpeartionDrapAndDrop");
		driver.navigate().to(objProp.getProperty("mouseOperationDragAndDrop"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		waitForPageToLoad();
		WebElement element = LibraryFunctions.FindElementByLocator(ObjectRepository2.Frame);
		driver.switchTo().frame(element);
		Actions objActions = new Actions(driver);
		WebElement source = LibraryFunctions.FindElementByLocator(ObjectRepository2.Draggable);
		WebElement target = LibraryFunctions.FindElementByLocator(ObjectRepository2.Droppable);
		//objActions.dragAndDrop(source, target).build().perform();
		objActions.clickAndHold(source);
		objActions.moveToElement(target);
		objActions.release(target).build().perform();
		
	}
	
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
		LaunchBrowser();
	}

	

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() throws Exception {
		System.out.println("inside beforeSuite");
		ReadPropertiesFile();
	}
} 

	