package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMPage extends BasePage {

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "middleName")
    private WebElement middleNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/input")
    private WebElement employeeIdInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//input[@placeholder='Type for hints...'][1]")
    private WebElement employeeNameSearch;

    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/input")
    private WebElement employeeIdSearch;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='oxd-table-card']")
    private WebElement employeeRecordRow;

    @FindBy(xpath = "//i[contains(@class, 'bi-trash')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement profilePictureUpload;

    @FindBy(xpath = "//h6[text()='Personal Details']")
    private WebElement personalDetailsHeader;

    @FindBy(xpath = "//div[contains(@class, 'oxd-toast--success')]")
    private WebElement successToast;

    public void clickAddEmployee() {
        click(addButton);
    }

    public void enterFirstName(String firstName) {
        sendKeys(firstNameInput, firstName);
    }

    public void enterMiddleName(String middleName) {
        sendKeys(middleNameInput, middleName);
    }

    public void enterLastName(String lastName) {
        sendKeys(lastNameInput, lastName);
    }

    public void enterEmployeeId(String employeeId) {
        sendKeys(employeeIdInput, employeeId);
    }

    public void clickSave() {
        click(saveButton);
    }

    public void addEmployee(String firstName, String middleName, String lastName) {
        clickAddEmployee();
        enterFirstName(firstName);
        enterMiddleName(middleName);
        enterLastName(lastName);
        clickSave();
    }

    public void uploadProfilePicture(String filePath) {
        uploadFile(profilePictureUpload, filePath);
    }

    public void searchEmployeeByName(String name) {
        sendKeys(employeeNameSearch, name);
        click(searchButton);
    }

    public void searchEmployeeById(String id) {
        sendKeys(employeeIdSearch, id);
        click(searchButton);
    }

    public boolean isEmployeeRecordDisplayed() {
        return isDisplayed(employeeRecordRow);
    }

    public void deleteEmployee() {
        click(deleteButton);
        click(confirmDeleteButton);
    }

    public boolean isPersonalDetailsDisplayed() {
        return isDisplayed(personalDetailsHeader);
    }

    public boolean isSuccessToastDisplayed() {
        return isDisplayed(successToast);
    }
}
