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

public class SearchResultFilmPage extends Page {

	private static final Logger LOG = LogFactory.getLogger(SearchResultFilmPage.class);
	
	@FindBy(how = How.XPATH, using = ".//div[@id='film-list']//div[1]//b//a")
	public WebElement LinkOnTheDetailedInformationForFoundElement;
	
	public SearchResultFilmPage(WebDriver webDriver) {
		super(webDriver);
		LOG.info("Initialized  Search Result Film Page");
	}
	
	public boolean isLinkSerchDisplay(){
		TestStepReporter.reportln("Checking if link search is really displayed");
		LOG.info("checking if link search is really displayed...");
		return LinkOnTheDetailedInformationForFoundElement.isDisplayed();
	}
	
	public InformationAboutFilmsPage clicOnLinkDetailedInformationForFoundElement(){
		LinkOnTheDetailedInformationForFoundElement.click();
		return PageFactory.initElements(webDriver, InformationAboutFilmsPage.class);
	}
}
