package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class GmoOnline {
	WebDriver driver;

	@Test(priority = -1)
	public void LaunchGmoOnline() {
		System.out.println("inside LaunchGmoOnline");
		driver.get("http://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("title:" + title);
		Assert.assertEquals(title, "Welcome to Green Mountain Outpost");
	}

	@Test(priority = 0, dependsOnMethods = { "LaunchGmoOnline" })
	public void EnterGmoOnlineAndOrderExternalFrameBackPack() {
		System.out.println("inside EnterGmoOnlineAndOrderExternalFrameBackPack");
		driver.findElement(By.name("bSubmit")).click();
		String EnterGmoOnlineText = driver.findElement(By.xpath("//h1[text()='OnLine Catalog']")).getText();
		System.out.println("titleEnterGmoOnline:" + EnterGmoOnlineText);
		//Assert.assertEquals(EnterGmoOnlineText, "OnLine Catalo");
		
		SoftAssert objsoftAssert = new SoftAssert();
		objsoftAssert.assertEquals(EnterGmoOnlineText, "OnLine Catalo");

		driver.findElement(By.name("QTY_BACKPACKS")).sendKeys("6");
		driver.findElement(By.xpath("//input[@value='Place An Order']")).click();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String titlePaceOrder = driver.getTitle();
		Assert.assertEquals(titlePaceOrder, "Place Order");
		objsoftAssert.assertAll();
		
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
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}

}
