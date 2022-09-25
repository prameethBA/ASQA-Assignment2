package com.actitime.qa.testcases;

import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.ReportsPage;
import com.actitime.qa.pages.UsersPage;
import org.testng.Assert;
import com.actitime.qa.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportsPageTest extends TestBase{

    LoginPage loginPage;
    HomePage homePage;
    UsersPage userPage;
    ReportsPage reportsPage;
    public ReportsPageTest() {
        super();
    }


    @BeforeMethod
    public void setup() {
        initialization();
        reportsPage = new ReportsPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        homePage.clickOnReportsLink();
    }

    @Test(priority = 1)
    public void homePageReportLinkTest() throws InterruptedException {
        Assert.assertTrue(homePage.reportPageTitleIsDisplayed());
    }

    @Test(priority = 2)
    public void isProperReportDisplayedTest() {
        String reportType = reportsPage.getReportType();
        String reportName = reportsPage.getReportName();
        reportsPage.clickReport();
        Assert.assertEquals(reportsPage.getReportPageTitle(),reportType);
        Assert.assertEquals(reportsPage.getReportPageName(),reportName);

    }

    @Test(priority = 3)
    public void newReportBtnTest() {
        reportsPage.clickNewReportBtn();
        Assert.assertTrue(reportsPage.isNewReportTitleDisplayed());

    }
}
