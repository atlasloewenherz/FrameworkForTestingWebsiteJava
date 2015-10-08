package ua.com.lits.automation.java.framework.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {
	protected WebDriver webDriver;

	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public boolean isElementPresent(WebElement element){
		try{
			element.isEnabled();
			return true;
		}catch (NoSuchElementException e) {
			return false;
		}
	}
}
