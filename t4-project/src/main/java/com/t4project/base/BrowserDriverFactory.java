package com.t4project.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> wd = new ThreadLocal<WebDriver>();
	private String browser;
	protected Logger log;

	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}

	public WebDriver createDriver() {
		// Create driver
		log.info("Create driver: " + browser);

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			wd.set(new ChromeDriver());
			break;

		case "firefox":

			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			wd.set(new FirefoxDriver());
			break;
		case "opera":
			String operaBinary = "C:\\Users\\valde\\AppData\\Local\\Programs\\Opera\\launcher.exe";
			System.setProperty("webdriver.opera.driver", "src/main/resources/chromedriver.exe");
			OperaOptions options = new OperaOptions();
			options.setBinary(operaBinary);
			wd.set(new OperaDriver(options));
			break;
		default:
			log.info("Do not know how to start" + browser+ " Starting chrome");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			wd.set(new ChromeDriver());
			break;
		}
	return wd.get();
	}
}
