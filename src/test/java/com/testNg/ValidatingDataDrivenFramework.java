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
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidatingDataDrivenFramework extends LibraryFunctions{

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
				/*
				 * System.out.println("-------------------"); 
				 * for(Map.Entry map :Hmap.entrySet()) 
				 * { System.out.println(map.getKey() + ":"+map.getValue()); }
				 * System.out.println("-------------------");
				 */
				
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
				
				
				//LibraryFunctions.FindElementByLocator(ObjectRepository2.DataDrivenPhoneNumber);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public HashMap<String, String> ReadExcelFile(XSSFSheet ObjXSSFSheet, int rowNumber) {
		DataFormatter ObjFormatter = new DataFormatter();
		Hmap.put("RunMode",ObjXSSFSheet.getRow(rowNumber).getCell(0).getStringCellValue());
		Hmap.put("TestCaseName",ObjXSSFSheet.getRow(rowNumber).getCell(1).getStringCellValue());
		Hmap.put("FirstName",ObjXSSFSheet.getRow(rowNumber).getCell(2).getStringCellValue());
		Hmap.put("LastName",ObjXSSFSheet.getRow(rowNumber).getCell(3).getStringCellValue());
		Hmap.put("Address",ObjXSSFSheet.getRow(rowNumber).getCell(4).getStringCellValue());
		Hmap.put("EmailAddress",ObjXSSFSheet.getRow(rowNumber).getCell(5).getStringCellValue());
		
		Hmap.put("PhoneNumber",ObjFormatter.formatCellValue(ObjXSSFSheet.getRow(rowNumber).getCell(6)));
		
		Hmap.put("Gender",ObjXSSFSheet.getRow(rowNumber).getCell(7).getStringCellValue());
		Hmap.put("Hobbies",ObjXSSFSheet.getRow(rowNumber).getCell(8).getStringCellValue());
		Hmap.put("Languages",ObjXSSFSheet.getRow(rowNumber).getCell(9).getStringCellValue());
		Hmap.put("Skills",ObjXSSFSheet.getRow(rowNumber).getCell(10).getStringCellValue());
		Hmap.put("Country",ObjXSSFSheet.getRow(rowNumber).getCell(11).getStringCellValue());
		Hmap.put("SelectCountry",ObjXSSFSheet.getRow(rowNumber).getCell(12).getStringCellValue());
		
		Hmap.put("DOB_YY",ObjFormatter.formatCellValue(ObjXSSFSheet.getRow(rowNumber).getCell(13)));
		
		Hmap.put("DOB_MM",ObjXSSFSheet.getRow(rowNumber).getCell(14).getStringCellValue());
		
		
		Hmap.put("DOB_DD",ObjFormatter.formatCellValue(ObjXSSFSheet.getRow(rowNumber).getCell(15)));
		
		Hmap.put("Password",ObjXSSFSheet.getRow(rowNumber).getCell(16).getStringCellValue());
		Hmap.put("confirmPwd",ObjXSSFSheet.getRow(rowNumber).getCell(17).getStringCellValue());
		return Hmap;
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
