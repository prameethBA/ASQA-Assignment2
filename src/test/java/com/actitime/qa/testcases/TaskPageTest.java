package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TasksPage;
import com.actitime.qa.testdata.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskPageTest extends TestBase{
    LoginPage loginPage;
    HomePage homePage;
    TasksPage tasksPage;
    public TaskPageTest() {
        super();
    }


    @BeforeMethod
    public void setup() {
        initialization();
        tasksPage = new TasksPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        homePage = loginPage.loging(Constants.USERNAME, Constants.PASSWORD);
        homePage.clickOnTaskLink();
    }

    @Test(priority = 1)
    public void homePageTaskLinkTest() throws InterruptedException {
        Thread.sleep(5000);
        boolean flag = homePage.taskPageTitleIsDisplayed();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void checkAddNewBtnTest(){
        tasksPage.clickAddNewBtn();
        tasksPage.clickAddNewCustomer();
        Assert.assertTrue(tasksPage.isAddNewPopUpDisplayed());
    }

}
