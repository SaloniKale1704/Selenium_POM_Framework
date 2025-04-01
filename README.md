# Selenium POM Framework

This project is a Selenium-based framework that follows the Page Object Model (POM) design pattern. It is intended for automated testing of web applications. The framework is built using Java, Selenium WebDriver, ExtentReports for reporting, and other utilities for enhanced test automation.

## Created by: **Saloni Kale**

### Project Structure
- **com.base**: Contains base test and setup methods.
- **com.pages**: Contains the page objects (LoginPage, CheckoutPage, etc.).
- **com.utils**: Contains utility classes for handling common functions like taking screenshots and managing reports.
- **com.examples.UiTests**: Contains test cases utilizing the POM.

### Key Features:
- **Page Object Model**: All page interactions are abstracted in page classes.
- **ExtentReports Integration**: All test results are captured in HTML reports with screenshots.
- **CSV and Excel Integration**: Test data is pulled from CSV and Excel files for parameterization.
- **Reusable Utility Functions**: Common functions for actions like clicking elements, entering text, etc.

## Getting Started

### Prerequisites
Ensure you have the following installed:
- **Java** (JDK 11 or higher)
- **Eclipse IDE** for Java Developers
- **Maven** (for dependency management)
- **Selenium WebDriver** dependencies (automatically handled by Maven)
- **ChromeDriver** (if using Google Chrome for tests)
- **ExtentReports** (for reporting)

### Setup Instructions

1. **Clone the repository**:
   If you haven't already cloned the repository, use the following command:
   ```bash
   git clone https://github.com/your-repository-url

2. Import the project into Eclipse:
    1. Open Eclipse IDE.
    2. Go to File -> Import -> Maven -> Existing Maven Projects.
    3. Select the project directory and click Finish.

3. Configure Maven dependencies:
     The pom.xml file contains all necessary dependencies for Selenium, ExtentReports, etc. Maven will automatically fetch the required dependencies when the project is imported into Eclipse.

4. Update ChromeDriver:
     Download the appropriate version of ChromeDriver for your Chrome browser from ChromeDriver Download. Ensure the chromedriver.exe is placed in a known path and that path is set in your system's environment variables or configured in the BaseTest class.

### Running the Tests

1. Configure Test Data:
      The test data (username, password, etc.) is pulled from credentials.csv and testData.xlsx in the src/main/resources/TestData/ folder. Make sure these files are updated with valid data.

2. Execute the Test:
   1. You can run any test class by right-clicking the class (e.g., Test01) and selecting Run As -> Java Application.
   2. Alternatively, you can use Maven to run tests:

### View Reports:
  Test execution reports are generated under the src/test/resources/Reports/ directory. Open the HTML file to view the results.

### Directory Structure

Selenium-POM-Framework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── base/
│   │   │   │   ├── pages/
│   │   │   │   └── utils/
│   │   ├── resources/
│   │   │   ├── TestData/
│   │   │   │   ├── credentials.csv
│   │   │   │   └── testData.xlsx
│   ├── test/
│   │   ├── java/
│   │   │   └── UiTests/
│   │   │       └── Test01/
│   │   ├── resources/
│   │   │   ├── Screenshots/
│   │   │   └── Reports/
└── pom.xml

