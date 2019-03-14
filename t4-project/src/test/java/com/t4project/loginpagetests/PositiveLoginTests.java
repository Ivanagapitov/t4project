package com.t4project.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.t4project.base.TestUtilities;
import com.t4project.pages.ExplorerPage;
import com.t4project.pages.LoginPage;

public class PositiveLoginTests extends TestUtilities {

	@Test
	public void loginTest() throws InterruptedException {

		log.info("Starting login test");

		// Open the page
		LoginPage loginPage = new LoginPage(wd, log);
		loginPage.openPage();
		wd.manage().window().maximize();

		// Execute log in
		ExplorerPage homePage = loginPage.logIn("ivanagapitov@gmail.com", "5Mk&ml1C*s");
		Thread.sleep(2500);

		// Verifications
		// New URL
		Assert.assertEquals(homePage.getCurrentUrl(), homePage.getPageUrl());

		// Search is visible
		Assert.assertTrue(homePage.isExplorerHeaderVisible(), "Explorer Page Header is not visible");

	}

}
