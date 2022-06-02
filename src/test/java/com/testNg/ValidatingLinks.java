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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
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

public class ValidatingLinks extends LibraryFunctions{
	@Test(priority = 1)
	public void ValidatingLinksWorkingOrNot()   {
		System.out.println("inside ValidatingLinks");
		driver.navigate().to(objProp.getProperty("Links"));
		waitForPageToLoad();
		List<WebElement> AllLinksInLinksPage = LibraryFunctions.FindElementsByLocator(ObjectRepository2.Links);
		IteratingThroughLinksAndValidatingTheStatusCodes(AllLinksInLinksPage);
		JavascriptExecutor  Js = (JavascriptExecutor)driver;
		Js.executeScript("window.scrollBy(0,200)");
		LibraryFunctions.FindElementByLocator(ObjectRepository2.BrokenLinks).click();
		waitForPageToLoad();
		List<WebElement> AllLinksInBrokenLinksPage = LibraryFunctions.FindElementsByLocator(ObjectRepository2.Links);
		IteratingThroughLinksAndValidatingTheStatusCodes(AllLinksInBrokenLinksPage);
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

	
	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}

}
