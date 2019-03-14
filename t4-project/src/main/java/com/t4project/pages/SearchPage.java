package com.t4project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePageObject {

	private String pageUrl = "https://d2na68m4vgzgx5.cloudfront.net/search";

	private By searchField = By.xpath("//div[@class='SearchFieldsContainer']");

	public SearchPage(WebDriver wd, Logger log) {
		super(wd, log);
		// TODO Auto-generated constructor stub
	}

	public String getPageUrl() {
		return pageUrl;
	}

	// Verification if Search is visible on the page //
	public boolean isSearchVisible() {
		waitForVisibilityOf(searchField, 10);
		return find(searchField).isDisplayed();

	}
}