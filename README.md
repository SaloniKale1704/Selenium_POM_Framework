# Selenium POM Framework

## Overview
This repository contains a Selenium Page Object Model (POM) framework for automating the Sauce Demo website. The framework includes features such as ExtentReports for reporting, screenshot capture, and common utility functions.

## Table of Contents
- Workflow
- Implementation
  - POM Framework
  - ExtentReports
  - Screenshot Functionality
  - Common Functions
- Setup
- Usage
- Execution

## Workflow
1. **Navigate to Sauce Demo Website**: The test script navigates to the Sauce Demo website.
2. **Login**: The script performs login using valid credentials.
3. **Product Selection**: The script selects products to add to the cart.
4. **Checkout**: The script proceeds to checkout and completes the purchase.
5. **Logout**: The script logs out from the application.

## Implementation

### POM Framework
The Page Object Model (POM) design pattern is used to create an object repository for web elements. This improves test maintenance and reduces code duplication.

- **Page Classes**: Each web page is represented by a class, containing web elements and methods to interact with them.
- **Test Classes**: Test scripts use the page classes to perform actions and assertions.

### ExtentReports
ExtentReports is used for generating detailed and visually appealing test reports.

- **Configuration**: The `extent-config.xml` file is used to configure the report.
- **Usage**: The `ExtentManager` class initializes the report, and the `ExtentTestManager` class is used to log test steps.

### Screenshot Functionality
Screenshots are captured for failed test cases to aid in debugging.

- **Implementation**: The `ScreenshotUtil` class contains methods to capture and save screenshots.
- **Integration**: The screenshot functionality is integrated with the test listener to capture screenshots on test failure.

### Common Functions
Common utility functions are created to avoid code duplication and improve reusability.

- **Utilities**: The `CommonFunctions` class contains methods for common actions like clicking, sending keys, and waiting for elements.

## Setup 
1. Download the ZIP folder from the GitHub repository.
2. Extract the ZIP folder to your desired location.
3. Open Eclipse IDE.
4. Import the existing Maven project:
5. Go to File > Import > Existing Maven Projects.
6. Select the extracted folder path.
7. Run the Test01.java file:
8. Navigate to the src/test/java directory.
9. Locate and run the Test01.java file.

## View the report:
1. After execution, go to src/test/java/resources/Reports.
2. Open the latest report in your web browser.
