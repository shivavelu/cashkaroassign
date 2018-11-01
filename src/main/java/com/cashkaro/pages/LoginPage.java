package com.cashkaro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cashkaro.helper.SeleniumHelper;

public class LoginPage {
	public WebDriver driver;
	public SeleniumHelper selHelp;

	@FindBy(css = "a#close_and_go_fb")
	private WebElement lnkJoinFB;

	@FindBy(css = "input#email")
	private WebElement txtEmailID;

	@FindBy(css = "input[name='login']")
	private WebElement btnLogin;

	@FindBy(css = "input#pass")
	private WebElement txtPass;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		selHelp = new SeleniumHelper(driver);
		PageFactory.initElements(driver, this);
	}

	public LoginPage joinFB() {
		selHelp.waitforElementClickable(lnkJoinFB);
		lnkJoinFB.click();
		return new LoginPage(driver);
	}

	public UserPage performLoginPopupWindow(String userEmail, String userPassword) {
		selHelp.getWinodws(driver).switchTo().window(selHelp.handlesList.get(1));
		txtEmailID.click();
		txtEmailID.clear();
		txtEmailID.sendKeys(userEmail);
		txtPass.click();
		txtPass.clear();
		txtPass.sendKeys(userPassword);
		btnLogin.submit();
		selHelp.getWinodws(driver).switchTo().window(selHelp.handlesList.get(0));
		return new UserPage(driver);
	}

	public LoginPage loginSwithto() {
		System.out.println(selHelp.handlesSet);
		selHelp.swithhToSecondWindow(driver, selHelp.handlesList.get(1));
		txtEmailID.click();
		txtEmailID.clear();
		txtEmailID.sendKeys("shivavelu@gmail.com");
		txtPass.click();
		txtPass.clear();
		txtPass.sendKeys("chakal");
		btnLogin.submit();
		return new LoginPage(driver);
	}

}
