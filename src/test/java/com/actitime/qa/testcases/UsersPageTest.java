package com.actitime.qa.testcases;

import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import com.actitime.qa.base.TestBase;
import org.testng.annotations.Test;

public class UsersPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    UsersPage userPage;
    public UsersPageTest() {
        super();
    }


    @BeforeMethod
    public void setup() {
        initialization();
        userPage = new UsersPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        homePage.clickOnUsersLink();
    }


    @Test(priority = 1)
    public void homePageUserLinkTest() throws InterruptedException {
        Assert.assertTrue(homePage.userPageTitleIsDisplayed());
    }

    @Test(priority = 2)
    public void isUserListDisplayedTest() {
        Assert.assertTrue(userPage.isUserNameDisplayed(), "User name is not displayed");
        Assert.assertTrue(userPage.isGroupNameDisplayed(),"Group Name is not displayed");
    }

    @Test(priority = 3)
    public void isUserProfileDisplayedTest() {
        String userName = userPage.getUserName();
        userPage.clickUserName();
        Assert.assertEquals(userPage.getProfileName(),userName);
    }

}
