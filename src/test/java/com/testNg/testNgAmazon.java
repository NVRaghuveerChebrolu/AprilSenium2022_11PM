package com.testNg;

import org.testng.annotations.Test;

import com.utility.LibraryFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testNgAmazon {

  @Test(priority=-1)
  public void ValidateAmazonLaunching() {
	  System.out.println("inside ValidateAmazonLaunching");
		/*
		 * WebDriverManager.chromedriver().setup(); 
		 * WebDriver driver = new
		 * ChromeDriver();
		 */
	  LibraryFunctions.driver.get("https://www.amazon.co.in");
	  LibraryFunctions.driver.manage().window().maximize();
	  String title = LibraryFunctions.driver.getTitle();
	  System.out.println("title:"+title);
	  Assert.assertEquals(title, "Online site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	  
  }
  
  @Test(priority=2)
  public void testcase2() {
	  System.out.println("inside testcase2");
	  
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
	  LibraryFunctions.LaunchBrowser();
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside beforeSuite");
	  try {
		  LibraryFunctions.ReadPropertiesFile();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside afterSuite");
  }

}
