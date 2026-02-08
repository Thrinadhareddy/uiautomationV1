package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage {

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    @FindBy(xpath = "//label[text()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
    private WebElement userRoleDropdown;

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminRoleOption;

    @FindBy(xpath = "//span[text()='ESS']")
    private WebElement essRoleOption;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;

    @FindBy(xpath = "//label[text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
    private WebElement statusDropdown;

    @FindBy(xpath = "//span[text()='Enabled']")
    private WebElement enabledStatusOption;

    @FindBy(xpath = "//span[text()='Disabled']")
    private WebElement disabledStatusOption;

    @FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div/input")
    private WebElement usernameInput;

    @FindBy(xpath = "//label[text()='Password']/parent::div/following-sibling::div/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//label[text()='Confirm Password']/parent::div/following-sibling::div/input")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div/input[@class='oxd-input oxd-input--active']")
    private WebElement usernameSearchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='oxd-table-card']")
    private WebElement userRecordRow;

    @FindBy(xpath = "//i[contains(@class, 'bi-trash')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//a[text()='Job ']")
    private WebElement jobMenu;

    @FindBy(xpath = "//a[text()='Job Titles']")
    private WebElement jobTitlesSubMenu;

    @FindBy(xpath = "//label[text()='Job Title']/parent::div/following-sibling::div/input")
    private WebElement jobTitleInput;

    @FindBy(xpath = "//div[contains(@class, 'oxd-toast--success')]")
    private WebElement successToast;

    public void clickAddUser() {
        click(addButton);
    }

    public void selectUserRole(String role) {
        click(userRoleDropdown);
        if (role.equalsIgnoreCase("Admin")) {
            click(adminRoleOption);
        } else {
            click(essRoleOption);
        }
    }

    public void enterEmployeeName(String employeeName) {
        sendKeys(employeeNameInput, employeeName);
    }

    public void selectStatus(String status) {
        click(statusDropdown);
        if (status.equalsIgnoreCase("Enabled")) {
            click(enabledStatusOption);
        } else {
            click(disabledStatusOption);
        }
    }

    public void enterUsername(String username) {
        sendKeys(usernameInput, username);
    }

    public void enterPassword(String password) {
        sendKeys(passwordInput, password);
        sendKeys(confirmPasswordInput, password);
    }

    public void clickSave() {
        click(saveButton);
    }

    public void addUser(String role, String employeeName, String status, String username, String password) {
        clickAddUser();
        selectUserRole(role);
        enterEmployeeName(employeeName);
        selectStatus(status);
        enterUsername(username);
        enterPassword(password);
        clickSave();
    }

    public void searchUserByUsername(String username) {
        sendKeys(usernameSearchInput, username);
        click(searchButton);
    }

    public boolean isUserRecordDisplayed() {
        return isDisplayed(userRecordRow);
    }

    public void deleteUser() {
        click(deleteButton);
        click(confirmDeleteButton);
    }

    public void navigateToJobTitles() {
        click(jobMenu);
        click(jobTitlesSubMenu);
    }

    public void addJobTitle(String jobTitle) {
        click(addButton);
        sendKeys(jobTitleInput, jobTitle);
        click(saveButton);
    }

    public boolean isSuccessToastDisplayed() {
        return isDisplayed(successToast);
    }
}
