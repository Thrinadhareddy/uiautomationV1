# OrangeHRM Web UI Automation Framework

## Overview
This is a robust **Test Automation Framework** built using **Java**, **Selenium WebDriver**, **Cucumber (BDD)**, and **Allure Reporting**, designed to test the [OrangeHRM Demo Site](https://opensource-demo.orangehrmlive.com/).

It features a **Page Object Model (POM)** architecture, **Thread-Safe Parallel Execution**, and support for **Multi-Version Browser Testing**.

## Key Features
- **Page Object Model (POM)**: separation of test logic and page objects for better maintainability.
- **BDD with Cucumber**: Readable Gherkin feature files.
- **Thread-Safe Parallel Execution**: Uses `ThreadLocal<WebDriver>` to ensure safe parallel runs.
- **Multi-Browser Support**: Chrome (with specific version support), Firefox, Edge.
- **Robust Reporting**: Integrated Allure Reports for detailed execution insights.
- **Singleton Driver Management**: Efficient Webdriver lifecycle management.
- **Automatic Browser Management**: Uses Selenium Manager (Selenium 4.x) to automatically download and manage browser binaries.

## Tech Stack
- **Language**: Java 11+
- **Web Automation**: Selenium WebDriver 4.27.0
- **BDD Framework**: Cucumber 7.20.1
- **Test Runner**: TestNG 7.10.2
- **Reporting**: Allure Report 2.29.0
- **Build Tool**: Maven

## Project Structure
```
ui-automation
├── src
│   ├── main
│   │   └── java
│   │       └── com.orangehrm
│   │           ├── pages        # Page Classes (Locators & Actions)
│   │           └── utils        # Utilities (DriverFactory, ConfigReader)
│   └── test
│       ├── java
│       │   └── com.orangehrm
│       │       ├── runners      # TestNG Runners
│       │       └── steps        # Cucumber Step Definitions
│       └── resources
│           ├── features         # Gherkin Feature Files (.feature)
│           ├── allure.properties# Allure Configuration
│           └── config.properties# Framework Configuration
├── target                       # Build artifacts and Reports
├── pom.xml                      # Maven Dependencies
├── testng.xml                   # TestNG Suite Configuration
└── README.md                    # Documentation
```

## Prerequisites
- Java JDK 11 or higher
- Maven 3.6+
- Chrome/Firefox/Edge Browser

## Configuration
Configure the framework via `src/test/resources/config.properties`:

```properties
browser=chrome
url=https://opensource-demo.orangehrmlive.com/
implicitWait=0
headless=false
# Optional: Specify exact Chrome version (e.g., 120, 121). Leave empty for latest.
chromeVersion=
```

## How to Run Tests

### Standard Execution
Run all tests using Maven:
```bash
mvn clean test
```

### Multi-Version Parallel Execution
The framework is configured (via `testng.xml`) to run tests on multiple Chrome versions (Latest & v120) in parallel.
```bash
mvn clean test
```
*Note: Ensure `testng.xml` is referenced in your `pom.xml` configuration.*

### Running Specific Browser Version
You can override the version in `config.properties`:
```properties
chromeVersion=119
```

## Viewing Reports
Generate and view the Allure report:

```bash
mvn allure:serve
```

The report will show separate suites for each browser version if running in multi-version mode.

## Troubleshooting
- **AbstractTestNGCucumberTests error**: Ensure your `TestRunner` extends `AbstractTestNGCucumberTests`.
- **Driver not found**: Selenium Manager should handle this automatically. If issues persist, check your internet connection or firewall.
- **AspectJ Weaving Error**: Ensure you are using a JDK compatible with the AspectJ version defined in `pom.xml`. (Currently AspectJ 1.9.25 for Java 25 support).
