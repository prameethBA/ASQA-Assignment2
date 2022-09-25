package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.util.TestUtil;
import com.actitime.qa.testdata.Constants;

public class LogonPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	String sheetName = "Users";
	TestUtil testUtil;
	
	
	
	public LogonPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		
	}
	
	
	@Test(priority = 1)
	public void loginPageLogoTest() {
		
	boolean flag= loginPage.validateActiTimeLogo();
	Assert.assertTrue(flag);
		
	}

	@Test(priority = 2)
	public void LoginTest() {
		homePage = loginPage.loging(Constants.USERNAME, Constants.PASSWORD);
	}

	@Test(priority = 3)
	public void InvalidUserLoginTest() throws InterruptedException {
		homePage = loginPage.loging(Constants.INVALID_USERNAME, Constants.PASSWORD);
		Thread.sleep(3000);
		Assert.assertEquals(loginPage.getErrorMeg(),Constants.ERROR_MSG);
	}

	@Test(priority = 4)
	public void InvalidPwdLoginTest() throws InterruptedException {
		homePage = loginPage.loging(Constants.USERNAME, Constants.INVALID_PASSWORD);
		Thread.sleep(3000);
		Assert.assertEquals(loginPage.getErrorMeg(),Constants.ERROR_MSG);
	}

	@Test(priority = 5)
	public void InvalidPwdAndUsernameLoginTest() throws InterruptedException {
		homePage = loginPage.loging(Constants.INVALID_USERNAME, Constants.INVALID_PASSWORD);
		Thread.sleep(3000);
		Assert.assertEquals(loginPage.getErrorMeg(),Constants.ERROR_MSG);
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
