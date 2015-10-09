package ua.com.lits.automation.java.framework.pages.enterapplication;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.lits.automation.java.framework.pages.Page;
import ua.com.lits.automation.java.framework.utility.SikuliImageRecognition;

public class InformationAboutFilmsPage extends Page {
	private static final Logger LOG = LoggerFactory.getLogger(InformationAboutFilmsPage.class);

	public InformationAboutFilmsPage(WebDriver webDriver) {
		super(webDriver);
		LOG.info("initialized Information About Films Page");
		((JavascriptExecutor) webDriver).executeScript("scroll(0," + webDriver.findElement(By.xpath(".//*[@id='hitplayer_inner']/../../following-sibling::*[1]")).getLocation()
				+ ");");
	}

	public InformationAboutActorPage clickOnImageActor() {
		SikuliImageRecognition imageRecognition = new SikuliImageRecognition();
		imageRecognition.clickOnImage("Matthew_McConaughey.png");
		return PageFactory.initElements(webDriver, InformationAboutActorPage.class);

	}
}
