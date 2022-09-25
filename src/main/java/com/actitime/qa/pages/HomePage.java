package com.actitime.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;

public class HomePage extends TestBase {

	
	//Page Factory - Object Repository
	
		@FindBy(xpath = "//a[@class='content tasks']")
		WebElement taskLink;
		
		@FindBy(xpath = "//a[@class='content reports']")
		WebElement reportsLink;

		@FindBy(xpath = "//a[@class='content users']")
		WebElement userLink;

		@FindBy(xpath = "//a[@class='content selected tt']")
		WebElement homePage;

		@FindBy(xpath = "//div[@id='logo_aT']")
		WebElement actitimeLogo;

		@FindBy(xpath = "//a[@id = 'logoutLink']")
		WebElement logoutBtn;

		@FindBy(xpath = "//div[text() = 'Customers & Projects']")
		WebElement taskPageTitle;

		@FindBy(xpath = "//td[text()='Reports Dashboard']")
		WebElement reportsPageTitle;

		@FindBy(xpath = "//span[text() ='List of Users']")
		WebElement userPageTitle;

		@FindBy(xpath = "//span[text()='Me']")
		WebElement dropDown;

		@FindBy(xpath = "//div[@class ='changeStatusButton approveButton']")
		WebElement approveBtn;

		@FindBy(xpath = "//td[@class ='currentStatusCell statusText' and text() = 'Approved']")
		WebElement approveStatus;


		//initialization
		
		public HomePage() {
			
			PageFactory.initElements(driver, this);
		}
		
		
		//Action/Methods
		
		public Boolean validateActiTimeLogo() {
			return actitimeLogo.isDisplayed();
		}
		
		
		
		public TasksPage clickOnTaskLink() {
			
			taskLink.click();
			return new TasksPage();
			
		}

		public HomePage clickOnHomeLink() {

			homePage.click();
			return new HomePage();

		}


		public ReportsPage clickOnReportsLink() {

				 reportsLink.click();
				 return new ReportsPage();

			}

		public UsersPage clickOnUsersLink() {

			userLink.click();
			return new UsersPage();

		}

		public LoginPage clickOnLogoutBtn() {

			logoutBtn.click();
			return new LoginPage();

		}

		public boolean taskPageTitleIsDisplayed(){
			taskPageTitle.isDisplayed();
			return false;
		}

		public boolean reportPageTitleIsDisplayed(){
			taskPageTitle.isDisplayed();
			return false;
		}

		public boolean userPageTitleIsDisplayed(){
			taskPageTitle.isDisplayed();
			return false;
		}

		public void clickDropDown(){
			dropDown.click();
		}

		public void selectEmployee(String userName){
			WebElement employeeName = driver.findElement(By.xpath("//span[text()='+userName+']"));
			employeeName.click();

		}

		public void changeEmployeeTimeSheet(String userName){
			this.clickDropDown();
			this.selectEmployee(userName);
		}

		public String getEmployeeName(){
			return dropDown.getText();
		}

		public void clickApproveBtn(){
			approveBtn.click();
		}

		public boolean isApproveStatusDisplayed(){
			approveStatus.isDisplayed();
			return false;
		}
}
