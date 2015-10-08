package ua.com.lits.automation.java.framework.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebDriverListener implements WebDriverEventListener {

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		TestStepReporter.report("Change was performed on element with locator:",
				getElementDescriptorXPATH(driver, element) + "; Element html tag: "
						+ getElementDescriptorName(driver, element));

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		TestStepReporter.report("Was cliked on webelement with locator:", getElementDescriptorXPATH(driver, element)
				+ "; Element html tag: " + getElementDescriptorName(driver, element));

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		TestStepReporter.report("Navigated to the url:", url);
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		TestStepReporter.reportln("Execution of script performed ", script);

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {

	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		TestStepReporter.reportln("WebDriver Exception throwed:", throwable.getMessage());

	}

	public String getElementDescriptorXPATH(WebDriver driver, WebElement element) {
		return (String) ((JavascriptExecutor) driver).executeScript("gPt=function(c){if(c.id!=='')"
				+ "{return'id(\"'+c.id+'\")'}" + "if(c===document.body){return c.tagName}"
				+ "var a=0;var e=c.parentNode.childNodes;" + "for(var b=0;b<e.length;b++){" + "var d=e[b];if(d===c){"
				+ "return gPt(c.parentNode)+'/'+c.tagName+" + "'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName)"
				+ "{a++}}};return gPt(arguments[0]).toLowerCase();", element);
	}
	
	public String getElementDescriptorName(WebDriver driver, WebElement element) {
		return element.getTagName() + "<p>" + element.getText();
	}

}
