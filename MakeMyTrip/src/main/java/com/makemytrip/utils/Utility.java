package com.makemytrip.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static Properties p;

	public static String getDataFromPropertyFile(String url) throws IOException {

		FileInputStream file = null;
		try {

			file = new FileInputStream(
					"C:\\Users\\ramko\\git\\MakeMyTripp\\MakeMyTrip\\Configuration\\config.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		p = new Properties();
		p.load(file);

		String value = p.getProperty(url);
		return value;
	}

	public static void captureScreenshot(WebDriver driver, int testID) throws IOException {

		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd HH mm ss");
		LocalDateTime now = LocalDateTime.now();

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("test-output//Screenshot//Test-" + testID + " " + date.format(now) + ".jpeg");
		FileHandler.copy(source, dest);
	}

}
