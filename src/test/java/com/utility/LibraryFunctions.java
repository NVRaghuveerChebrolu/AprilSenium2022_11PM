package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	
	public static void ReadPropertiesFile() throws Exception {
		try {
			FileInputStream objFileinputStream = new FileInputStream(new File(System.getProperty("user.dir")+
					"//src//test//resources//ConfigurationProperty.properties"));
			objProp = new Properties();
			objProp.load(objFileinputStream);
			System.out.println(objProp.getProperty("browser"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void LaunchBrowser() {
		String browser = objProp.getProperty("browser");
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
		break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver= new OperaDriver();
		break;	
		}
		
		driver.get("https://www.google.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//implicit wait is global waiting mechanism which is applicable for all Web Elements that 
		//are declared under this.
		
		
	}
	
	public static WebElement FindElementByLocator(String OrepLocator) {
		System.out.println("OrepLocator:"+OrepLocator);
		String locator = OrepLocator.split("&")[0];
		String value = OrepLocator.split("&")[1];
		System.out.println("locator:"+locator);
		System.out.println("value:"+value);
		By Obj = null ;
		switch(locator) {
		case "id":
			Obj=By.id(value);
			break;
		case "xpath":
			Obj=By.xpath(value);
			break;
		case "name":
			Obj=By.name(value);
			break;
		case "linkText":
			Obj=By.linkText(value);
			break;
		case "className":
			Obj=By.className(value);
			break;
		case "cssSelector":
			Obj=By.cssSelector(value);
			break;	
		case "partialLinkText":
			Obj=By.partialLinkText(value);
			break;		
		case "tagName":
			Obj=By.tagName(value);
			break;	
		}
		return driver.findElement(Obj);
		
	}
	
	public static List<WebElement> FindElementsByLocator(String OrepLocator) {
		System.out.println("OrepLocator:"+OrepLocator);
		String locator = OrepLocator.split("&")[0];
		String value = OrepLocator.split("&")[1];
		System.out.println("locator:"+locator);
		System.out.println("value:"+value);
		By Obj = null ;
		switch(locator) {
		case "id":
			Obj=By.id(value);
			break;
		case "xpath":
			Obj=By.xpath(value);
			break;
		case "name":
			Obj=By.name(value);
			break;
		case "linkText":
			Obj=By.linkText(value);
			break;
		case "className":
			Obj=By.className(value);
			break;
		case "cssSelector":
			Obj=By.cssSelector(value);
			break;	
		case "partialLinkText":
			Obj=By.partialLinkText(value);
			break;		
		case "tagName":
			Obj=By.tagName(value);
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


}
