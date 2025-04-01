package com.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

	private static final String SCREENSHOT_FOLDER = "src/test/resources/Screenshots/";

	public static String takeScreenshot(WebDriver driver, String screenshotName) {
		try {
			//Generate timestamp
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			String filePath = SCREENSHOT_FOLDER + screenshotName + "_" + timeStamp + ".png";

			//Create directory if does not exists
			File directory = new File(SCREENSHOT_FOLDER);
			if (!directory.exists()) {
				directory.mkdirs();
			}

			//Capture screenshot
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File(filePath);
			FileHandler.copy(srcFile, destFile);

			//Convert relative path to absolute path
			return destFile.getAbsolutePath();
		} 
		catch (IOException e) {
			System.out.println("Screenshot capture failed: " + e.getMessage());
			return null;
		}
	}
}
