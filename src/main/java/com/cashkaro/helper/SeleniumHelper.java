package com.cashkaro.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import freemarker.core.ReturnInstruction.Return;

public class SeleniumHelper {
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;

	public static WebDriver driver;
	public Set<String> handlesSet;
	public List<String> handlesList;

	public JavascriptExecutor executor;

	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
		
	}

	public WebDriver switchToFrame(int frameidorindex) {
		driver.switchTo().frame(frameidorindex);
		return driver;
	}

	public SeleniumHelper(WebDriver driver) {
		this.driver = driver;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public WebDriver waitforElementVisable(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.visibilityOf(element));
		return driver;
		

	}

	public WebDriver waitforElementClickable(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 500);
		WebElement elementclick = wait.until(ExpectedConditions.elementToBeClickable(element));
		return driver;
	}

	public void waitforAlertPresent() {

		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void javaScriptElementClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void javaScriptElementScroll(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void dropdownVisbileText(WebElement element, String visibleText) {
		Select sb = new Select(element);
		sb.selectByVisibleText(visibleText);
	}

	public void dropdownValue(WebElement element, String value) {
		Select sb = new Select(element);
		sb.selectByValue(value);
	}

	public void dropdownIndex(WebElement element, int index) {
		Select sb = new Select(element);
		sb.selectByIndex(index);
	}

	public void sendKeyByAction(WebElement element, String key) {
		Actions action = new Actions(driver);
		action.sendKeys(element, key);

	}

	public void sendkeyByJavaScript(WebElement element, String value) {

		executor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public WebDriver getWinodws(WebDriver driver) {
		handlesSet = driver.getWindowHandles();
		handlesList=new ArrayList<String>(handlesSet);
		return driver;
	}
	
	public WebDriver swithTo(WebDriver driver,String windowID)
	{
		driver.switchTo().window(windowID);
		return driver;
		
	}
	public WebDriver swithhToSecondWindow(WebDriver driver, String windowID)
	{
		driver.switchTo().window(windowID);
		return driver;
	}

}
