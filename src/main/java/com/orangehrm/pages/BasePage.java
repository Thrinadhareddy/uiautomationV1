package com.orangehrm.pages;

import com.orangehrm.utils.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // ========== Basic Interactions ==========

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
        } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
    }

    public void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ========== Dropdown Handling ==========

    public void selectDropdownByText(WebElement dropdown, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    public void selectDropdownByValue(WebElement dropdown, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public void selectDropdownByIndex(WebElement dropdown, int index) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    public String getSelectedDropdownText(WebElement dropdown) {
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }

    public List<String> getAllDropdownOptions(WebElement dropdown) {
        Select select = new Select(dropdown);
        List<String> options = new ArrayList<>();
        for (WebElement option : select.getOptions()) {
            options.add(option.getText());
        }
        return options;
    }

    // ========== Alert/Popup Handling ==========

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void sendKeysToAlert(String text) {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(text);
    }

    // ========== Window Handling ==========

    public void switchToWindow(int windowIndex) {
        Set<String> windows = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windows);
        if (windowIndex < windowList.size()) {
            driver.switchTo().window(windowList.get(windowIndex));
        }
    }

    public void switchToNewWindow() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void closeCurrentWindowAndSwitchBack() {
        driver.close();
        switchToWindow(0);
    }

    public int getWindowCount() {
        return driver.getWindowHandles().size();
    }

    // ========== Advanced Waits ==========

    public void waitForElementToDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForTextToBePresentInElement(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForUrlContains(String urlFragment) {
        wait.until(ExpectedConditions.urlContains(urlFragment));
    }

    // ========== JavaScript Executor ==========

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickViaJavaScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    // ========== File Upload ==========

    public void uploadFile(WebElement fileInput, String filePath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@type='file' or contains(@class, 'file')]")));
        fileInput.sendKeys(filePath);
    }
}
