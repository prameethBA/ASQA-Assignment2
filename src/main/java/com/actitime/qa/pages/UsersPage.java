package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage extends TestBase  {

    @FindBy(xpath = "//span[@class='userNameSpan']")
    WebElement userName;

    @FindBy(xpath = "//div[@class='userName nameInfo ellipsis']")
    WebElement profileName;

    @FindBy(xpath = "//div[@class='groupName']")
    WebElement groupName;



    //initialization

    public UsersPage() {

        PageFactory.initElements(driver, this);
    }

    //Action/Methods

    public boolean isUserNameDisplayed(){
        return userName.isDisplayed();
    }

    public boolean isGroupNameDisplayed(){
        return groupName.isDisplayed();
    }

    public void clickUserName(){
        userName.click();
    }

    public String getUserName(){
        return userName.getText();
    }

    public String getProfileName(){
        return profileName.getText();
    }
}
