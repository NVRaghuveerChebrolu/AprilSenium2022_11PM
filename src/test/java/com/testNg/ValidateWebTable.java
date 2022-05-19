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

public class ValidateWebTable extends LibraryFunctions {
	@Test(priority = 1)
	public void ValidateExtractiingDataFromWebTable() throws InterruptedException {
		System.out.println("inside ValidateExtractiingDataFromWebTable");
		driver.navigate().to(objProp.getProperty("WebTableURL"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		waitForPageToLoad();
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("window.scrollBy(0,650)");

		List<WebElement> AllRows = LibraryFunctions.FindElementsByLocator(ObjectRepository2.WebTableRows);
		String ProvidedLastName = objProp.getProperty("LastNameInWebTable");
		for (int i = 1; i <= AllRows.size(); i++) {
				String LastName = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[3]")).getText();
				String FirsName = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText();
				String Position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[4]")).getText();
				String Office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[5]")).getText();
				String StartDate = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[6]")).getText();
				String Salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[7]")).getText();
				if(LastName.equalsIgnoreCase(ProvidedLastName)) {
				System.out.println("LastName:"+LastName);
				System.out.println("FirsName:"+FirsName);
				System.out.println("Position:"+Position);
				System.out.println("Office:"+Office);
				System.out.println("StartDate:"+StartDate);
				System.out.println("Salary:"+Salary);
				break;
				}
		}

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
