package com.makemytrip.baseclass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.makemytrip.pagelayer.Homepage;
import com.makemytrip.utils.Utility;

public class Baseclass {

	// Base class consist of Mandatory code that run every time like open browser
	// Use extends keyword to inherited Base class
	// Declared Globally

	public static WebDriver driver;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	Homepage Hp;
	int testID;

	@BeforeClass
	public void initializeBrowser() throws IOException {

		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.setProperty(Utility.getDataFromPropertyFile("key"), Utility.getDataFromPropertyFile("value"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Utility.getDataFromPropertyFile("url"));
	}

	@BeforeMethod
	public void beforemethod() throws IOException, InterruptedException {

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {

			Utility.captureScreenshot(driver, testID);

		}
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}

