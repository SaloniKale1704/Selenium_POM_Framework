package com.base;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.utils.CSVFileReader;
import com.utils.ExcelReader;
import com.utils.ExtentManager;
import com.utils.ScreenshotUtil;

public class BaseTest {

	protected static WebDriver driver;
	protected static String url;
	protected static String username;
	protected static String password;
	protected static Map<String, String> testData;
	private static ExtentReports extent;
	private static ExtentTest test;

	private static final String FILE_PATH = "src/main/resources/TestData/testData.xlsx";
	private static final String SHEET_NAME = "swagLabs_testData";
	private static final String CSV_FILE_PATH = "src/main/resources/TestData/credentials.csv";

	public static void setUp() throws CsvValidationException {
		try {

			// Read data from CSV file
			String[] data = CSVFileReader.getTestData(CSV_FILE_PATH);
			if (data != null) {
				url = data[0];
				username = data[1];
				password = data[2];
			}

			// Read data from Excel file
			testData = ExcelReader.getRowData(FILE_PATH, SHEET_NAME, 1);

			// Initialize Extent Reports
			extent = ExtentManager.getInstance();
			test = extent.createTest("Test Execution"); // Ensure test is initialized

			// Set up WebDriver
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get(url);

			String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "Setup_completed");
			if (screenshotPath != null) {
				test.info("Browser Launched and Navigated to URL",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}

			// Initialize pages
			PageInitializer.initializePages(driver, test);

		} catch (Exception e) {
			e.printStackTrace();
			if (driver != null) {
				String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "setupError");
				test.fail("Setup failed: " + e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			}
		}
	}

	public static void tearDown() {
		try {
			String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "BeforeClosingBrowser");
			if (screenshotPath != null) {
				test.info("Final Screenshot Before Closing Browser",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}

			driver.quit();
			driver = null;
			test.pass("Browser closed successfully.");

			extent.flush();

		} catch (Exception e) {
			e.printStackTrace();
			String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "tearDownError");
			if (screenshotPath != null) {
				test.fail("Teardown failed: " + e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}

		}
	}
}