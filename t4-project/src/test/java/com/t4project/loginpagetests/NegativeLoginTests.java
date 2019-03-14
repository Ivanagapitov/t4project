package com.t4project.loginpagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.t4project.base.CsvDataProviders;
import com.t4project.base.TestUtilities;
import com.t4project.pages.LoginPage;

public class NegativeLoginTests extends TestUtilities {

	@Test(priority = 1, groups = { "smokeTest",
			"negativeTests" }, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLoginTest(Map<String, String> testData) throws InterruptedException {

		// Data
		String no = testData.get("no");
		String email = testData.get("email");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		String expectedPageUrl = "https://d2na68m4vgzgx5.cloudfront.net/login";

		log.info("Starting negative Log In test #" + no + " for " + description);

		// Open the page
		LoginPage loginPage = new LoginPage(wd, log);
		loginPage.openPage();
		wd.manage().window().maximize();

		// Logging in
		loginPage.logIn(email, password);

		// URL verification
		Assert.assertEquals(loginPage.getCurrentUrl(), expectedPageUrl);

		// Error message verification
		Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage);

	}
}
