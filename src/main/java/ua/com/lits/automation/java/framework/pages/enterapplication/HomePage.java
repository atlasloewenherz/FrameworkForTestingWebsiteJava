package ua.com.lits.automation.java.framework.pages.enterapplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;

import ua.com.lits.automation.java.framework.pages.Page;
import ua.com.lits.automation.java.framework.utility.LogFactory;
import ua.com.lits.automation.java.framework.utility.TestStepReporter;

public class HomePage extends Page {

	private static final Logger LOG = LogFactory.getLogger(HomePage.class);

	public HomePage(WebDriver webDriver) {
		super(webDriver);
		LOG.info("initialized Home Page");
	}

	@FindBy(how = How.XPATH, using = ".//form [@class and @method and @action]//input")
	public WebElement inputSearch;

	@FindBy(how = How.XPATH, using = ".//div[@class and @role]//form[@class and @method and @action]//button")
	public WebElement buttonSearch;

	public boolean isInputSearchDisplay() {
		TestStepReporter.reportln("Checking if search is really displayed");
		LOG.info("checking if search is really displayed...");
		return inputSearch.isDisplayed();
	}

	public boolean isButtonSearchDisplay() {
		TestStepReporter.reportln("Checking if button search is really displayed");
		LOG.info("checking if button search is really displayed...");
		return buttonSearch.isDisplayed();
	}

	public HomePage sendKeysInInputSearch() {
		inputSearch.sendKeys("Interstellar");
		return PageFactory.initElements(webDriver, HomePage.class);
	}

	public SearchResultFilmPage clickOnButtonSearch() {
		buttonSearch.click();
		return PageFactory.initElements(webDriver, SearchResultFilmPage.class);
	}

}
