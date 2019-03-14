package com.t4project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPasswordPage extends LoginPage {

	private By resetPasswordMessage = By.xpath("//h2[contains(text(),'Please check your email for a password reset link.')]");
	private By resetPasswordErrorMessage = By.xpath("//span[@class='Login__error-text']");
	private String pageUrl = "https://d2na68m4vgzgx5.cloudfront.net/resetpassword";
	private String message;

	public ResetPasswordPage(WebDriver wd, Logger log) {
		super(wd, log);
	}

	public boolean isCheckEmailMessageVisible() {
		return isElementVisible(resetPasswordMessage);
	}
	
	public String getInvalidEmailErrorMessage() {
		waitForVisibilityOf(resetPasswordErrorMessage, 10);
		WebElement errorMessage = find(resetPasswordErrorMessage);
		message = errorMessage.getText();
		return message;
	}
	
	public String getPageUrl() {
		return pageUrl;
	}
	
}
