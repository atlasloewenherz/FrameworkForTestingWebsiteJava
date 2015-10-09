package ua.com.lits.automation.java.framework.pages.enterapplication;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.lits.automation.java.framework.utility.TestStepReporter;

public class InformationAboutActorPage {
	private static final Logger LOG = LoggerFactory.getLogger(InformationAboutActorPage.class);

	@FindBy(how = How.XPATH, using = ".//div[@class and @style]//h4[contains(text(),'Matthew McConaughey')]")
	public WebElement nameActorOnPageInformationAboutActor;

	public boolean isTextNameActorDisplay() {
		TestStepReporter.reportln("Checking if name actor search is really displayed");
		LOG.info("checking if link name actor is really displayed...");
		return nameActorOnPageInformationAboutActor.isDisplayed();
	}

	public String getNameActor() {
		return nameActorOnPageInformationAboutActor.getText().toString();
	}
}
