package com.cashkaro.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cashkaro.base.TestBase;
import com.cashkaro.pages.HomePage;
import com.cashkaro.pages.LoginPage;

public class TestCases extends TestBase {

	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;

	@BeforeClass
	public void setUp() {
		this.driver = initialization("browser");
		homePage = new HomePage(driver);
		loginPage= new LoginPage(driver);
	}

	@Test
	public void loginApp() {
		homePage.clickJinFree().joinFB().getAllWinodws().loginSwithto();
		

	}

	

}
