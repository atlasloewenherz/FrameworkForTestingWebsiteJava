package ua.com.lits.automation.java.framework.pages.enterapplication;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.testng.annotations.Parameters;

import ua.com.lits.automation.java.framework.pages.Page;
import ua.com.lits.automation.java.framework.utility.LogFactory;
import ua.com.lits.automation.java.framework.utility.SikuliImageRecognition;
import ua.com.lits.automation.java.framework.utility.TestStepReporter;

public class InFormationAboutFilmsPage extends Page {
	public InFormationAboutFilmsPage(WebDriver webDriver) {
		super(webDriver);
		LOG.info("initialized In Formation About Films Page");
	}

}
