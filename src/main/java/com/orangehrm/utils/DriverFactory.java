package com.orangehrm.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Reporter;
import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        if (getDriver() == null) {
            String browser = ConfigReader.getProperty("browser");
            String headless = ConfigReader.getProperty("headless");

            WebDriver webDriver;

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--window-size=1920,1080");

                    // Try getting version from TestNG parameter first
                    String chromeVersion = null;
                    try {
                        chromeVersion = org.testng.Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
                                .getParameter("chromeVersion");
                    } catch (Exception e) {
                        // Ignore if not running via TestNG XML or context unavailable
                    }

                    // Fallback to config.properties
                    if (chromeVersion == null || chromeVersion.isEmpty()) {
                        chromeVersion = ConfigReader.getProperty("chromeVersion");
                    }

                    if (chromeVersion != null && !chromeVersion.isEmpty()) {
                        options.setBrowserVersion(chromeVersion);
                    }

                    if (Boolean.parseBoolean(headless)) {
                        options.addArguments("--headless");
                    }
                    webDriver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                    break;
                default:
                    throw new RuntimeException("Browser not supported: " + browser);
            }

            webDriver.manage().window().maximize();
            webDriver.manage().deleteAllCookies();

            long implicitWait = Long.parseLong(ConfigReader.getProperty("implicitWait"));
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

            driver.set(webDriver);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
