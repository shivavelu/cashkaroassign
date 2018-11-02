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

	@FindBy(css = "a#link_signin")
	private WebElement lnkSignin;

	@FindBy(css = "a#lnkLayoutForgotPassword")
	private WebElement lnkForgotPassword;
	
	@FindBy(css = "input#from_email")
	public WebElement txtMailID;
	
	
	@FindBy(css = "iframe.cboxIframe")
	public WebElement frame1;
	

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

	public HomePage forgetPasswordClick() {
		selHelp.waitforElementClickable(lnkSignin);
		lnkSignin.click();
		selHelp.waitforElementClickable(lnkForgotPassword);
        lnkForgotPassword.click();
		return new HomePage(driver);
	}
	
	public HomePage emailClcik()
	{
		driver.switchTo().frame(frame1);
		selHelp.waitforElementVisable(txtMailID);
		txtMailID.click();
		return new HomePage(driver);
	}
	

}
