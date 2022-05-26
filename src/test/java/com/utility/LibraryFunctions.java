package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibraryFunctions {
	public static WebDriver driver;
	public static Properties objProp;
	HashMap<String,String> Hmap = new HashMap<String,String>();

	public static void ReadPropertiesFile() throws Exception {
		try {
			FileInputStream objFileinputStream = new FileInputStream(new File(
					System.getProperty("user.dir") + "//src//test//resources//ConfigurationProperty.properties"));
			objProp = new Properties();
			objProp.load(objFileinputStream);
			System.out.println(objProp.getProperty("browser"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void LaunchBrowser() {
		String browser = objProp.getProperty("browser");
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			ChromeOptions objChromeOptions = new ChromeOptions();
			objChromeOptions.setAcceptInsecureCerts(true);
			// driver= new ChromeDriver(objChromeOptions);
			Map<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.prompt_for_download", false);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
			objChromeOptions.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(objChromeOptions);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		}

		driver.get("https://www.google.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// implicit wait is global waiting mechanism which is applicable for all Web
		// Elements that
		// are declared under this.

	}

	public static WebElement FindElementByLocator(String OrepLocator) {
		System.out.println("OrepLocator:" + OrepLocator);
		String locator = OrepLocator.split("&")[0];
		String value = OrepLocator.split("&")[1];
		System.out.println("locator:" + locator);
		System.out.println("value:" + value);
		By Obj = null;
		switch (locator) {
		case "id":
			Obj = By.id(value);
			break;
		case "xpath":
			Obj = By.xpath(value);
			break;
		case "name":
			Obj = By.name(value);
			break;
		case "linkText":
			Obj = By.linkText(value);
			break;
		case "className":
			Obj = By.className(value);
			break;
		case "cssSelector":
			Obj = By.cssSelector(value);
			break;
		case "partialLinkText":
			Obj = By.partialLinkText(value);
			break;
		case "tagName":
			Obj = By.tagName(value);
			break;
		}
		return driver.findElement(Obj);

	}

	public static List<WebElement> FindElementsByLocator(String OrepLocator) {
		System.out.println("OrepLocator:" + OrepLocator);
		String locator = OrepLocator.split("&")[0];
		String value = OrepLocator.split("&")[1];
		System.out.println("locator:" + locator);
		System.out.println("value:" + value);
		By Obj = null;
		switch (locator) {
		case "id":
			Obj = By.id(value);
			break;
		case "xpath":
			Obj = By.xpath(value);
			break;
		case "name":
			Obj = By.name(value);
			break;
		case "linkText":
			Obj = By.linkText(value);
			break;
		case "className":
			Obj = By.className(value);
			break;
		case "cssSelector":
			Obj = By.cssSelector(value);
			break;
		case "partialLinkText":
			Obj = By.partialLinkText(value);
			break;
		case "tagName":
			Obj = By.tagName(value);
			break;
		}
		return driver.findElements(Obj);

	}

	public static void waitForPageToLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		// explicit wait -> Applicable for one webEllement
		WebDriverWait wait = new WebDriverWait(driver, 60);// 60 seconds
		wait.until(pageLoadCondition);
	}

	public static void ScrollIntoViewWithWebElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
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
	
	public void SelectValueFromDropDown(List<WebElement> AllDropDownItems, String DropDownValue) {
		int NumberOfDropDownItems = AllDropDownItems.size();
		for(int i=0 ; i<NumberOfDropDownItems ; i++) {
			String IndividualDropDownValue = AllDropDownItems.get(i).getText();
			if(IndividualDropDownValue.equalsIgnoreCase(DropDownValue)) {
				AllDropDownItems.get(i).click();
				break;
			}
		}
	}

}
