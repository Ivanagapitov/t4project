package com.t4project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePageObject{

	protected By emailInputLocator = By.xpath("//input[@name='email']");
	protected By passwordInputLocator = By.xpath("//input[@name='password']");
	protected By submitButtonLocator = By.name("submit");
	protected By forgotPasswordLocator = By.xpath("//a[contains(text(),'Forgot Password?')]");
	private By errorMessageLocator = By.xpath("//span[@class='Login__error-text']");
	
	private String pageUrl = "https://d2na68m4vgzgx5.cloudfront.net/login";
	public String errorMessage;
	
	public LoginPage(WebDriver wd, Logger log) {
		super(wd, log);
	}
	// Open log in page with it's URL //
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		wd.manage().window().maximize();
		log.info("Page opened!");
	}
	/** Execute log in */
	public ExplorerPage logIn(String email, String password) {
		log.info("Executing log in with email [" + email + "] and password [" + password +"]");	
		type(email, emailInputLocator);
		type(password, passwordInputLocator);
		click(submitButtonLocator);
		return new ExplorerPage (wd, log);
	}
	public ResetPasswordPage resetPassword (String email) {
		log.info("Start resetting a password");
		click(forgotPasswordLocator);
		type(email, emailInputLocator);
		click(submitButtonLocator);
		return new ResetPasswordPage(wd, log);		
	}
	public String getErrorMessage() {
		waitForVisibilityOf(errorMessageLocator, 10);
		WebElement errorMessageElement = find(errorMessageLocator);
		errorMessage = errorMessageElement.getText();
		return errorMessage;
	}
	
}
