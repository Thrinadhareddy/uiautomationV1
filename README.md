# OrangeHRM Web UI Automation Framework

## Overview
This is a robust Test Automation Framework built using **Java**, **Selenium WebDriver**, **Cucumber (BDD)**, and **Allure Reporting**, designed to test the [OrangeHRM Demo Site](https://opensource-demo.orangehrmlive.com/).

## Tech Stack
- **Language**: Java 11+
- **Web Automation**: Selenium WebDriver 4.x
- **BDD Framework**: Cucumber 7.x (TestNG Integration)
- **Test Runner**: TestNG 7.x
- **Reporting**: Allure Report 2.x
- **Build Tool**: Maven

## Project Structure
```
src
├── main
│   └── java
│       └── com.orangehrm
│           ├── pages       # Page Object Model classes (Locators & Actions)
│           └── utils       # Utilities (DriverFactory, ConfigReader)
└── test
    ├── java
    │   └── com.orangehrm
    │       ├── runners     # Test Runners (Cucumber TestNG Runner)
    │       └── steps       # Cucumber Step Definitions
    └── resources
        ├── features        # Gherkin Feature files
        ├── allure.properties # Allure configuration
        └── config.properties # Framework configuration (Browser, URL)
```

## Prerequisites
- Java JDK 11 or higher
- Maven 3.6+
- Chrome/Firefox/Edge Browser

## Configuration
Edit `src/test/resources/config.properties` to change browser or target URL:
```properties
browser=chrome
url=https://opensource-demo.orangehrmlive.com/
implicitWait=10
headless=false
```

## How to Run Tests
Execute the tests using Maven:
```bash
mvn clean test
```

## Viewing Reports
To generate and open the Allure report in your default browser:
```bash
mvn allure:serve
```
*Note: The Allure report is generated in `target/allure-results`.*

## Key Classes
- **DriverFactory**: Manages WebDriver instances using `ThreadLocal` for parallel execution safety.
- **BasePage**: Parent class for all Page Objects, containing common WebDriver actions and waits.
- **config.properties**: Centralized configuration management.
