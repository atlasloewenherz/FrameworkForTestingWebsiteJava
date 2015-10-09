package ua.com.lits.automation.java.framework.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import ua.com.lits.automation.java.framework.pages.enterapplication.HomePage;
import ua.com.lits.automation.java.framework.pages.enterapplication.InformationAboutActorPage;
import ua.com.lits.automation.java.framework.pages.enterapplication.InformationAboutFilmsPage;
import ua.com.lits.automation.java.framework.pages.enterapplication.SearchResultFilmPage;
import ua.com.lits.automation.java.framework.pages.webdriver.WebDriverFactory;
import ua.com.lits.automation.java.framework.utility.XmlPropertyLoader;

public class TestBase {

	protected WebDriver webDriver;
	protected String testUrl;
	protected String timeout;
	protected HomePage homePage;
	protected SearchResultFilmPage searchResultFilmPage;
	protected InformationAboutFilmsPage informationAboutFilmsPage;
	protected InformationAboutActorPage informationAboutActorPage;

	@BeforeMethod
	@Parameters({ "browserName" })
	public void setup(String browserName) throws Exception {
		testUrl = XmlPropertyLoader.loadProperty("testsite.url");
		timeout = XmlPropertyLoader.loadProperty("implicit-timeout");
		webDriver = WebDriverFactory.getInstance(browserName);
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Integer.valueOf(timeout), TimeUnit.SECONDS);
		webDriver.manage().timeouts().pageLoadTimeout(Integer.valueOf(timeout), TimeUnit.SECONDS);
		webDriver.get(testUrl);
		homePage = PageFactory.initElements(webDriver, HomePage.class);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		if (webDriver != null) {
			WebDriverFactory.killDriverInstance();
		}
	}

}
