package com.actitime.qa.testcases;

import com.actitime.qa.testdata.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
	}
	
	
	@Test(priority = 1)
	public void homePageLogoTest() {
	boolean flag= homePage.validateActiTimeLogo();
	Assert.assertTrue(flag,"Unable to find Logo");
	}

	@Test(priority = 2)
	public void homePageLogoutTest() {
		homePage.clickOnLogoutBtn();
	}


	@Test(priority = 3)
	public void viewEmployeeTimeSheetsTest() throws InterruptedException {
		homePage.clickOnHomeLink();
		homePage.changeEmployeeTimeSheet(Constants.EMP_USERNAME);
		Assert.assertEquals(homePage.getEmployeeName(),Constants.EMP_USERNAME);

	}

	@Test(priority = 4)
	public void isTimeSheetApprovedTest() throws InterruptedException {
		homePage.clickApproveBtn();
		Assert.assertTrue(homePage.isApproveStatusDisplayed());

	}


	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
}
