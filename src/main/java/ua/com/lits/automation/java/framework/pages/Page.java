package ua.com.lits.automation.java.framework.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;

import ua.com.lits.automation.java.framework.utility.LogFactory;

public abstract class Page {

	private static final Logger LOG = LogFactory.getLogger(Page.class);
	protected WebDriver webDriver;
	
	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
	
	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
		LOG.info("Initialized Web Driver");
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public String getTitle() {
		return webDriver.getTitle();
	}
	
	public boolean isElementPresent(WebElement element) {
        try {
        	element.isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	
	public void WaitForTextPresent(WebElement webelement, String text) throws InterruptedException
    {
        int waitRetryDelayMs = 100;
        int timeOut = 500; 
        boolean first = true; 

        for (int milliSecond = 0; ; milliSecond += waitRetryDelayMs)
        {
            if (milliSecond > timeOut * 1000)
            {
                System.out.println("Timeout: Text '" + text + "' is not found ");
                break;
            }

            if (webelement.getText().contains(text))
            {
                if (!first) System.out.println("Text is found: '" + text + "'");
                break;
            }

            if (first) System.out.println("Waiting for text is present: '" + text + "'");

            first = false;
            Thread.sleep(waitRetryDelayMs);
        }
    }
	
}
