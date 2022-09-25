package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends TestBase {

    @FindBy(xpath = "//div[text()='Add New']")
    WebElement addNewBtn;

    @FindBy(xpath = "//div[text()='+ New Customer']")
    WebElement addNewCustomerBtn;

    @FindBy(xpath = "//span[text()='Create New Customer']")
    WebElement addNewCustomerPopup;

    //initialization

    public TasksPage() {

        PageFactory.initElements(driver, this);
    }

    //Action/Methods

    public void clickAddNewBtn(){
        addNewBtn.click();
    }

    public void clickAddNewCustomer(){
        addNewCustomerBtn.click();
    }

    public boolean isAddNewPopUpDisplayed(){
        return addNewCustomerPopup.isDisplayed();
    }
	
}
