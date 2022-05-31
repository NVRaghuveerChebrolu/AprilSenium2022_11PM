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

import java.awt.Toolkit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Window;
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

public class ValidatingDataDrivenFrameWork extends LibraryFunctions{
	HashMap<String,String> Hmap = new HashMap<String,String>();
	@Test(priority = 1)
	public void ValidatingDatDrivenTesting() throws InterruptedException {
		System.out.println("inside ValidatingDatDrivenTesting");
		driver.navigate().to(objProp.getProperty("AutomationRegister"));
		waitForPageToLoad();
		try {
			File ObjFile = new File(System.getProperty("user.dir")+"//src//test//resources//AutomationDemoSIte.xlsx");
			//FileInputStream for readng purpose
			FileInputStream ObjFileInputStream = new FileInputStream(ObjFile);
			//Use XSSFWorkbook and XSSFSheet if the excel file extemsion is .xlsx
			//use HSSFWorkbook and HSSFSheet if the excel file extension is .xls
			XSSFWorkbook objXSSFWorkbook = new XSSFWorkbook(ObjFileInputStream);
			XSSFSheet ObjXSSFSheet = objXSSFWorkbook.getSheet("TestData");
			int Rows = ObjXSSFSheet.getLastRowNum();
			System.out.println("Rows in excel is "+Rows);
			
			for (int RowNumber=1 ; RowNumber<=Rows; RowNumber++) {
				Hmap = ReadExcelFile(ObjXSSFSheet,RowNumber);
				
				System.out.println("-------------------");
				for (Map.Entry map : Hmap.entrySet()) {
					System.out.println(map.getKey() + ":" + map.getValue());
				}
				System.out.println("-------------------");

				if(Hmap.get("RunMode").equalsIgnoreCase("yes")) {
					System.out.println("Validating Row Number:"+RowNumber);
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenFirstName).clear();
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenFirstName).sendKeys(Hmap.get("FirstName"));
				
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenLastName).clear();
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenLastName).sendKeys(Hmap.get("LastName"));
				
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenAddress).clear();
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenAddress).sendKeys(Hmap.get("Address"));
				
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenEmailAddress).clear();
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenEmailAddress).sendKeys(Hmap.get("EmailAddress"));
				
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenPhoneNumber).clear();
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenPhoneNumber).sendKeys(Hmap.get("PhoneNumber"));
				
				if(Hmap.get("Gender").equalsIgnoreCase("Male")) {
					LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenMale).click();
				}else if(Hmap.get("Gender").equalsIgnoreCase("FeMale")) {
					LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenFeMale).click();
				}
				
				if(Hmap.get("Hobbies").equalsIgnoreCase("Cricket")) {
					LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenCricket).click();
				}else if(Hmap.get("Hobbies").equalsIgnoreCase("movies")) {
					LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenMovies).click();
				}else if(Hmap.get("Hobbies").equalsIgnoreCase("hockey")) {
					LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenHockey).click();
				}
				
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,1000)");
				
				if(RowNumber>1) {
					LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenCloseIconOfSelectedLanguage).click();
				}
				
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenLanguages).click();
				List<WebElement> AllLanaguages = LibraryFunctions.FindElementsByLocator(ObjectRepository2.DataDrivenAllLanguages);
				SelectValueFromDropDown(AllLanaguages,Hmap.get("Languages"));
				
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenSkillsField).click();
				
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenSkills).click();
				List<WebElement> AllSkills = LibraryFunctions.FindElementsByLocator(ObjectRepository2.DataDrivenAllSkills);
				SelectValueFromDropDown(AllSkills,Hmap.get("Skills"));
				
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenSelectCountry).click();
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenTextBoxOfSelectCountry).sendKeys(Hmap.get("SelectCountry"));
				
				Robot objRobot = new Robot();
				objRobot.delay(250);
				objRobot.keyPress(KeyEvent.VK_ENTER);
				objRobot.keyRelease(KeyEvent.VK_ENTER);
				
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenDOB_Years).click();
				List<WebElement> AllYears = LibraryFunctions.FindElementsByLocator(ObjectRepository2.DataDrivenDOB_AllYears);
				SelectValueFromDropDown(AllYears,Hmap.get("DOB_YY"));
				
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenDOB_Months).click();
				List<WebElement> AllMonths = LibraryFunctions.FindElementsByLocator(ObjectRepository2.DataDrivenDOB_AllMonths);
				SelectValueFromDropDown(AllMonths,Hmap.get("DOB_MM"));
				
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenDOB_Day).click();
				List<WebElement> AllDays = LibraryFunctions.FindElementsByLocator(ObjectRepository2.DataDrivenDOB_AllDays);
				SelectValueFromDropDown(AllDays,Hmap.get("DOB_DD"));
				
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenDOB_Pwd).clear();
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenDOB_Pwd).sendKeys(Hmap.get("Password"));
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenDOB_ConformPwd).clear();
				LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenDOB_ConformPwd).sendKeys(Hmap.get("confirmPwd"));
				
				//FileOutputStream for readng purpose
				FileOutputStream ObjFileOutputStream = new FileOutputStream(ObjFile);
				WriteToExcelFile(ObjXSSFSheet,RowNumber);
				objXSSFWorkbook.write(ObjFileOutputStream);
				}else {
					
					System.out.println("Run mode is not marked as yes for rowNumber:"+RowNumber+1);
				}
				
			}
			objXSSFWorkbook.close();
			ObjFileInputStream.close();
		}catch (Exception e) {
			e.printStackTrace();
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

	
	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}

}
