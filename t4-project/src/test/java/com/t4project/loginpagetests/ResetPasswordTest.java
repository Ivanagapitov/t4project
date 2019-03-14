package com.t4project.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.t4project.base.TestUtilities;
import com.t4project.pages.LoginPage;
import com.t4project.pages.ResetPasswordPage;

public class ResetPasswordTest extends TestUtilities {

	private String email = "ivanagapitov@gmail.com";
	private String invalidEmail = "invalidEmailemail.com";
	private String expectedInvalidEmailMessage = "An account with this email does not exist.";
	
	@Test
	public void positiveResetPasswordTest() {
		
		// Open page
		LoginPage loginPage = new LoginPage(wd, log);
		loginPage.openPage();
		
		// Perform reset password
		log.info("Perform password resetting");
		ResetPasswordPage resetPasswordPage = loginPage.resetPassword(email);
		
		// Verifications
		Assert.assertEquals(resetPasswordPage.getCurrentUrl(), resetPasswordPage.getPageUrl()); // URL
		Assert.assertTrue(resetPasswordPage.isCheckEmailMessageVisible(), "'Check email' message is not visible"); // Message
	}
	
	@Test
	public void negativeResetPasswordTest() {
		
		// Open page
		LoginPage loginPage = new LoginPage(wd, log);
		loginPage.openPage();
		
		// Perform an attempt to reset a password with invalid email
		log.info("Verifying invalid email");
		ResetPasswordPage resetPasswordPage = loginPage.resetPassword(invalidEmail);
		
		// Verification
		Assert.assertEquals(resetPasswordPage.getInvalidEmailErrorMessage(), expectedInvalidEmailMessage);
	}
}
