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
		ObjActions.contextClick(element).build().perform();
		Thread.sleep(8000);
		WebElement DeleteElement = LibraryFunctions.FindElementByLocator(ObjectRepository2.SelectDeleteOptionInRightClick);
		ObjActions.click(DeleteElement).build().perform();
		Alert ObjAlert = driver.switchTo().alert();
		String AlertText = ObjAlert.getText();
		System.out.println("AlertText:"+AlertText);
		Assert.assertEquals(AlertText, objProp.getProperty("mouseOpeartionRightclickDeleteActionText"));
		ObjAlert.accept();
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

	