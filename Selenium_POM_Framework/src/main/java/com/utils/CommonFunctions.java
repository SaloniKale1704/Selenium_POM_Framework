package com.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class CommonFunctions {

	private final WebDriver driver;
	private final ExtentTest test;

	public CommonFunctions(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Created function for implementing common function used in test case

	// Set Explicit wait
	private WebDriverWait getWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Click on element
	public void clickElement(WebElement element, String elementName) {
		try {
			getWait().until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			captureScreenshot(elementName + "Clicked", "Clicked on " + elementName);

		} catch (Exception e) {
			captureScreenshot(elementName + "ClickError", "Failed to click on " + elementName + ": " + e.getMessage());
		}
	}

	// Enter text in field
	public void enterText(WebElement element, String text, String elementName) {
		try {

			getWait().until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(text);
			captureScreenshot(elementName + "TextEntered", "Entered text into " + elementName + ": " + text);

		} catch (Exception e) {
			captureScreenshot(elementName + "TextError",
					"Failed to enter text into " + elementName + ": " + e.getMessage());
		}
	}

	// Select value from dropdown
	public void selectFromDropdownByValue(WebElement element, String value, String elementName) {
		try {

			Select dropdown = new Select(element);
			dropdown.selectByValue(value);
			captureScreenshot(elementName + "ValueSelected", "Value selected from " + elementName);

		} catch (Exception e) {
			captureScreenshot(elementName + "DropdownError",
					"Failed to select value from " + elementName + ": " + e.getMessage());
		}
	}

	// Verify WebElement with expected text
	public void verifyText(WebElement element, String expectedText, String elementName) {
		try {

			String actualText = element.getText();
			if (actualText.equals(expectedText)) {
				captureScreenshot(elementName + "TextVerified", "Text verified in " + elementName);
			} else {
				throw new Exception("Expected: " + expectedText + " but found: " + actualText);
			}
		} catch (Exception e) {
			captureScreenshot(elementName + "VerifyTextError",
					"Failed to verify text in " + elementName + ": " + e.getMessage());
		}
	}

	// Get text from WebElement
	public String getText(WebElement element, String elementName) {
		try {

			String text = element.getText();
			captureScreenshot(elementName + "TextRetrieved", "Text retrieved from " + elementName + ": " + text);
			return text;

		} catch (Exception e) {
			captureScreenshot(elementName + "GetTextError",
					"Failed to get text from " + elementName + ": " + e.getMessage());
			return null;
		}
	}

	// Capture screenshots
	private void captureScreenshot(String screenshotName, String message) {
		String screenshotPath = ScreenshotUtil.takeScreenshot(driver, screenshotName);
		if (screenshotPath != null) {
			test.info(message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else {
			test.info(message + " (Screenshot not available)");

		}
	}
}
