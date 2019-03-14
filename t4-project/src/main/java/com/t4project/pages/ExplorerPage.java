package com.t4project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExplorerPage extends BasePageObject {

	private String pageUrl = "https://d2na68m4vgzgx5.cloudfront.net/explorer";

	private By explorerHeader = By.xpath("//h1[contains(text(),'Industry Explorer')]");
	private By searchPageLinkLocator = By.xpath("//a[contains(text(),'Search')]") ;
	
	
	public ExplorerPage(WebDriver wd, Logger log) {
		super(wd, log);
	}

	// Get URL variable from PageObject //
	public String getPageUrl() {
		return pageUrl;
	}

	// Verification if Explorer Page Header is visible on the page //
	public boolean isExplorerHeaderVisible() {
		waitForVisibilityOf(explorerHeader, 10);
		return find(explorerHeader).isDisplayed();
	}
	public SearchPage goToSearchPage() {
		waitForClickabilityOf(searchPageLinkLocator, 5);
		click(searchPageLinkLocator);
		return new SearchPage(wd, log);
	}
}
	

	