package com.t4project.pages;

import java.util.Random;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	protected WebDriver wd;
	protected Logger log;
	
	public BasePageObject (WebDriver wd, Logger log) {
		this.wd = wd;
		this.log = log;
	}
	// Open page with given URL //
	protected void openUrl (String url) {
		wd.get(url);
	}
	// Get current URL from the browser //
	public String getCurrentUrl() {
		return wd.getCurrentUrl();
	}
	// Find element using given locator //
	protected WebElement find (By locator){
		return wd.findElement(locator);
	}
	// Click on the element with given locator when it's visible//
	protected void click(By locator) {
		waitForVisibilityOf(locator, 10);
		find(locator).click();
	}
	// Type given text into element with given locator when it's visible //
	protected void type(String text, By locator) {
		waitForVisibilityOf(locator, 10);
		find(locator).sendKeys(text);
	}
	// Wait for Expected Condition for given time in seconds //
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(wd, timeOutInSeconds);
		wait.until(condition);
	}
	/*
	 * Wait for given amount of time in seconds for element with given locator to be visible
	 * on the page
	 * */
	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attemps = 0;
		while (attemps < 10) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attemps++;
		}
	}
	protected void waitForClickabilityOf(By locator, Integer... timeOutInSeconds) {
		//wait.until(ExpectedConditions.elementToBeClickable(locator));
		int attemps = 0;
		while (attemps < 10) {
			try {
				waitFor(ExpectedConditions.elementToBeClickable(locator), (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attemps++;
		}
	}
	public String generateRandomTitle() {
		  
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String randomTitle = buffer.toString();
	return randomTitle;
	}
	
	public boolean isElementVisible(By locator) {
		waitForVisibilityOf(locator, 3);
		return wd.findElement(locator).isDisplayed();
	}
	
	public void jse (String script) {
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript(script);
	}
}
