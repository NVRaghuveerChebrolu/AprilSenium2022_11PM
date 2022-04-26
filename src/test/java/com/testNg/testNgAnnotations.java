package com.testNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testNgAnnotations {
	
	@Test()
	public void TestCase0() {
		  System.out.println("inside testCase0");
		  Assert.assertEquals(true, false);
	  }
	 
  @Test()
  public void testCase1() {
	  System.out.println("inside testCase1");
  }
  
  @Test(priority=-5)
  public void testCase2() {
	  System.out.println("inside testCase2");
	
  }
  
  @Test(invocationCount=4,dependsOnMethods= {"testCase2","TestCase0"})
  public void TestCase3() {
	  System.out.println("inside testCase3");
	  Assert.assertEquals(true, true);
  }
  
  @Test(priority=2,invocationCount=3)
  public void testCase4() {
	  System.out.println("inside testCase4");
  }
  
  @Test(enabled=false)
  public void testCase5() {
	  System.out.println("inside testCase5");
	  
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
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside afterSuite");
  }

}
