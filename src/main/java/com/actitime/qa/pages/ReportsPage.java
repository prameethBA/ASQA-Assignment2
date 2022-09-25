package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage extends TestBase  {

    @FindBy(xpath = "//div[@class='type-title']")
    WebElement reportType;

    @FindBy(xpath = "//div[@class='config-name']")
    WebElement reportName;

    @FindBy(xpath = "//div[@class='pagetitle']")
    WebElement reportPageTitle;

    @FindBy(xpath = "//div[@class='reportName']")
    WebElement reportPageName;

    @FindBy(xpath = "//span[text()='New Report']")
    WebElement newReportBtn;

    @FindBy(xpath = "//div[text()='Choose Report to Create']")
    WebElement newReportPopUpTitle;


    //initialization

    public ReportsPage() {

        PageFactory.initElements(driver, this);
    }

    //Action/Methods

    public void clickReport(){
        reportName.click();
    }

    public String getReportType(){
        return reportType.getText();
    }

    public String getReportName(){
        return reportName.getText();
    }

    public String getReportPageTitle(){
        return reportType.getText();
    }

    public String getReportPageName(){
        return reportName.getText();
    }

    public void clickNewReportBtn(){
        newReportBtn.click();
    }

    public boolean isNewReportTitleDisplayed(){
        return newReportPopUpTitle.isDisplayed();
    }
}
