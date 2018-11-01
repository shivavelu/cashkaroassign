package com.cashkaro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cashkaro.helper.SeleniumHelper;

public class HomePage {
	public WebDriver driver;
	public SeleniumHelper selHelp;

	@FindBy(css = "a#link_join")
	private WebElement lnkJoin;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		selHelp = new SeleniumHelper(driver);
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickJinFree() {
		selHelp.waitforElementClickable(lnkJoin);
		lnkJoin.click();
		return new LoginPage(driver);
	}
}
