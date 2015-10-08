package ua.com.lits.automation.java.framework.pages.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import ua.com.lits.automation.java.framework.utility.WebDriverListener;

public class WebDriverFactory {
	private static final String CHROME = "chrome";
	private static final String FIREFOX = "firefox";

	private static WebDriver webDriver;
	private static EventFiringWebDriver eventDriver;

	private WebDriverFactory() {

	}

	public static WebDriver getInstance(String browser) throws Exception {
		DesiredCapabilities dc = new DesiredCapabilities();
		if (eventDriver == null) {
			if (eventDriver == null) {
				if (CHROME.equals(browser)) {
					setChromeDriver();
					ChromeOptions options = new ChromeOptions();
					dc.setCapability(ChromeOptions.CAPABILITY, options);
					webDriver = new ChromeDriver(dc);
				} else if (FIREFOX.equals(browser)) {
					FirefoxProfile fp = new FirefoxProfile();
					dc = DesiredCapabilities.firefox();
					dc.setCapability(FirefoxDriver.PROFILE, fp);
					webDriver = new FirefoxDriver(dc);
				} else
					throw new Exception("Invalid browser property set in configuration file");
			}
			eventDriver = new EventFiringWebDriver(webDriver);
			eventDriver.register(new WebDriverListener());
		}
		return eventDriver;
	}
	public static void killDriverInstance() throws Exception{
		webDriver.quit();
		webDriver = null;
		eventDriver.quit();
		eventDriver = null;		
	}
	
	protected static void setChromeDriver() throws Exception{
		String osName = System.getProperty("os.name").toLowerCase();
		StringBuffer chromeBinaryPath = new StringBuffer("src/main/resources/drivers/");
		
		if (osName.startsWith("win")){
			chromeBinaryPath.append("chrome-win/chromedriver.exe");
		} else if (osName.startsWith("lin")){
			chromeBinaryPath.append("chrome-lin/chromedriver");
		} else if (osName.startsWith("mac")){
			chromeBinaryPath.append("chrome-mac/chromedriver");
		} else throw new Exception("Your OS is invalid for webdriver tests");
		
		System.setProperty("webdriver.chrome.driver", chromeBinaryPath.toString());
	}

}
