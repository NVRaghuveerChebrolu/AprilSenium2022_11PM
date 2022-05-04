package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

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
		
	}


}
