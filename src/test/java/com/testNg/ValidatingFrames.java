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
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidatingFrames extends LibraryFunctions{


	@Test(priority = 1)
	public void ValidatingFramesInAutomationTesting() {
		System.out.println("inside ValidatingFramesInAutomationTesting");
		driver.navigate().to(objProp.getProperty("FramesURL"));
		waitForPageToLoad();
		driver.switchTo().frame("singleframe");
		//driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Heloo How are you?");
		LibraryFunctions.FindElementByLocator(ObjectRepository2.TextBoxOfSingle_Frame).sendKeys("Heloo How are you?");
		driver.switchTo().defaultContent();// this method is used for bringing the control out of frame
		LibraryFunctions.FindElementByLocator(ObjectRepository2.IframeWithInIframe).click();
		WebElement MultipleframeElement = LibraryFunctions.FindElementByLocator(ObjectRepository2.MultipleFrame);
		driver.switchTo().frame(MultipleframeElement);
		WebElement SingleframeElement = LibraryFunctions.FindElementByLocator(ObjectRepository2.SingleFrame);
		driver.switchTo().frame(SingleframeElement);
		LibraryFunctions.FindElementByLocator(ObjectRepository2.TextBoxOfSingle_Frame).sendKeys(objProp.getProperty("framewithInFrame"));
		driver.switchTo().defaultContent();
		
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
