package com.cashkaro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cashkaro.helper.SeleniumHelper;

public class UserPage {
	
	public WebDriver driver;
	public SeleniumHelper selHelp;
	public String email;
    
	@FindBy(css = "a#link_myaccount")
	private WebElement lnkAccount;

	@FindBy(css = "a#idMenuSettings")
	private WebElement txtUserMenu;

	@FindBy(css = "input#fullname")
	public WebElement txtUserEmail;
	
	@FindBy(css = "a#idMenuLogout")
	private WebElement lnkLogout;
	
	public UserPage(WebDriver driver) {
		this.driver = driver;
		selHelp = new SeleniumHelper(driver);
		PageFactory.initElements(driver, this);
	}
	
	public UserPage getEmail()
	{
		selHelp.waitforElementClickable(lnkAccount);
		lnkAccount.click();
		selHelp.waitforElementClickable(txtUserMenu);
		txtUserMenu.click();
		selHelp.waitforElementClickable(txtUserEmail);
		return new UserPage(driver);
	}
	
	public HomePage logOut()
	{
		selHelp.waitforElementClickable(lnkAccount);
		lnkAccount.click();
		selHelp.waitforElementClickable(lnkLogout);
		lnkLogout.click();
		return new HomePage(driver);
	}

	

}
