package com.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;
	private static final String EXTENT_REPORT_FOLDER = "src/test/resources/Reports/";

	public static ExtentReports getInstance() {
		if (extent == null) {
			createInstance();
		}
		return extent;
	}

	private static void createInstance() {
		try {
			// Ensure Reports Directory Exists
			File reportDir = new File(EXTENT_REPORT_FOLDER);
			if (!reportDir.exists()) {
				boolean dirCreated = reportDir.mkdirs(); // Use mkdirs() instead of Files.createDirectories()
				if (!dirCreated) {
					System.err.println("Failed to create Reports directory!");
					return;
				}
			}

			// Generate unique report filename
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			String reportPath = EXTENT_REPORT_FOLDER + "ExtentReport_" + timeStamp + ".html";

			// Configure Extent Reports
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
			reporter.config().setReportName("Automation Test Report");
			reporter.config().setDocumentTitle("Test Execution Report");
			reporter.config().thumbnailForBase64(true);

			extent = new ExtentReports(); // Initialize ExtentReports
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Saloni Kale");
			extent.setSystemInfo("Environment", "QA");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error creating Extent Report instance: " + e.getMessage());
		}
	}
}