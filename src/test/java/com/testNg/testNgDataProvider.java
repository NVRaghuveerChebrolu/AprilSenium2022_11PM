package com.testNg;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class testNgDataProvider {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class executed");
	}

	@Test(priority =1 , dataProvider = "dp")
	public void add(String user,String pwd,String name,String email,String hobby) {

		System.out.println("user: " + user);
		
		System.out.println("pwd: " + pwd);
		System.out.println("name: " + name);
		System.out.println("email: " + email);
		System.out.println("hobby: " + hobby);

	}
	
	@Test(dataProvider = "dp2")
	public void mul(String user, String pwd) {
		System.out.println("user: " + user);
		System.out.println("pwd: " + pwd);

	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
				/*
				 * new Object[] { "user1"}, new Object[] { "user2"}, new Object[] { "user3" },
				 * new Object[] { "user4" }
				 */
				new Object[] { "user1", "pwd1", "gopal", "abc1@gmail.com", "cricket" },
				new Object[] { "user2", "pwd2", "venu", "abc2@gmail.com", "movies" },
				new Object[] { "user3", "pwd3", "name3", "abc3@gmail.com", "songs" },
				new Object[] { "user4", "pwd4", "name4", "abc4@gmail.com", "chess" }
			};
	}
	
	@DataProvider
	public Object[][] dp2() {
		return new Object[][] {
				  new Object[] { "user1","pwd1"}, 
				  new Object[] { "user2","pwd2"}, 
				  new Object[] { "user3","pwd3"}
			};
	}
}
