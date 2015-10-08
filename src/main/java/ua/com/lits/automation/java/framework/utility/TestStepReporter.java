package ua.com.lits.automation.java.framework.utility;

import org.testng.Reporter;

public class TestStepReporter {
	public static void report(String stepText, String stepDetails) {
		Reporter.log("<b>" + stepText + "</b>" + " " + stepDetails + "<p>", true);
	}

	public static void reportln(String stepText, String stepDetails) {
		Reporter.log("<p>" + "<b>" + stepText + "</b>" + " " + stepDetails + "<p>", true);
	}

	public static void report(String stepText) {
		Reporter.log("<b>" + stepText + "</b>" + "<p>", true);
	}

	public static void reportln(String stepText) {
		Reporter.log("<p>" + "<b>" + stepText + "</b>" + " " + "<p>", true);
	}
}
