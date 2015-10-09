package ua.com.lits.automation.java.framework.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import ua.com.lits.automation.java.framework.pages.webdriver.WebDriverFactory;

public class TestExecutionListener extends TestListenerAdapter {

	private static final String SCREENSHOT_FOLDER = "target/screenshots";
	private static final String SCREENSHOT_FORMAT = ".png";

	/**
	 * Prints the test results to report.
	 * 
	 * @param result
	 *            the result
	 */
	private void printTestResults(ITestResult result) {
		if (result.getParameters().length != 0) {
			String params = null;
			for (Object parameter : result.getParameters()) {
				params += parameter.toString() + ",";
			}

			TestStepReporter.reportln("Test Method had the following parameters : ", params);
		}

		String status = null;
		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			status = "Pass";
			break;
		case ITestResult.FAILURE:
			status = "Failed";
			break;
		case ITestResult.SKIP:
			status = "Skipped";
			break;
		}

		TestStepReporter.reportln("Test Status after execution: ", status);
		takeScreenshot(result);
	}

	public void onTestSkipped(ITestResult arg0) {
		printTestResults(arg0);
	}

	public void onTestSuccess(ITestResult arg0) {
		printTestResults(arg0);
	}

	public void onTestFailure(ITestResult arg0) {
		printTestResults(arg0);
	}

	public void takeScreenshot(ITestResult result) {
		// creating screenshot folder for test
		String folder = SCREENSHOT_FOLDER + "/" + result.getName();
		File dir = new File(folder);
		if (!dir.exists()) {
			dir.mkdir();
		}

		try {
			// Pause because sometimes webdriver takes previous page screenshot
			Thread.sleep(3000);
			// Taking webDriver screenshot
			File screenFile = ((TakesScreenshot) WebDriverFactory.getSetDriver()).getScreenshotAs(OutputType.FILE);
			// Setting screenshot file name
			// 'testMethodName_01_12_14_14_11_09.png'
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			String fileName = result.getName() + "_" + formater.format(Calendar.getInstance().getTime())
					+ SCREENSHOT_FORMAT;
			// Put screen file to appropriate folder
			FileUtils.copyFile(screenFile, new File(dir.getAbsoluteFile() + "/" + fileName));
			// Get cannonical screenshot path on disc and link it to reporter
			// output with html code
			// <a
			// href="E:\web.framework/target/screenshots/signInDisapearing/signInDisapearing_30_11_2014_02_48_34.png"
			// target="_blank"><br><img
			// src="file:///E:\web.framework/target/screenshots/signInDisapearing/signInDisapearing_30_11_2014_02_48_34.png"
			// width="600" height="338" alt=""><br></a>
			File directory = new File(".");
			String cannonicalScreenshotsPath = directory.getCanonicalPath();
			Reporter.log(
					"<a href=\"file:///" + cannonicalScreenshotsPath + "/" + folder + "/" + fileName + "\""
							+ " target='_blank' >" + "<p><br/><img src=\"file:///" + cannonicalScreenshotsPath + "/"
							+ folder + "/" + fileName + "\" width=\"600\" height=\"400\" alt=\"\"/>" + "<br/></p></a>",
					true);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}