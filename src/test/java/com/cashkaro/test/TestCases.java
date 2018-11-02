package com.cashkaro.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cashkaro.base.TestBase;
import com.cashkaro.pages.HomePage;
import com.cashkaro.pages.LoginPage;
import com.cashkaro.pages.UserPage;



public class TestCases extends TestBase {

	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
    public UserPage userPage;
	@BeforeClass
	public void setUp() {
		this.driver = initialization("browser");
		homePage = new HomePage(driver);
		loginPage= new LoginPage(driver);
		userPage= new UserPage(driver);
	}

	@Test
	public void loginApp() {
		homePage.clickJinFree().joinFB().performLoginPopupWindow(prop.getProperty("userEmail"), prop.getProperty("userPassword")).getEmail();
        Assert.assertEquals(prop.getProperty("fullName"), userPage.txtUserEmail.getAttribute("value"));
	}

	@Test
	public void forgotPassword()
	{
	 userPage.logOut().forgetPasswordClick();
		
	}
	

}
