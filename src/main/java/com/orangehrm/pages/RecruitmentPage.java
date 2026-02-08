package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitmentPage extends BasePage {

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "middleName")
    private WebElement middleNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(xpath = "//label[text()='Email']/parent::div/following-sibling::div/input")
    private WebElement emailInput;

    @FindBy(xpath = "//label[text()='Vacancy']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
    private WebElement vacancyDropdown;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement resumeUpload;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement candidateNameSearch;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='oxd-table-card']")
    private WebElement candidateRecordRow;

    @FindBy(xpath = "//a[text()='Vacancies']")
    private WebElement vacanciesTab;

    @FindBy(xpath = "//label[text()='Vacancy Name']/parent::div/following-sibling::div/input")
    private WebElement vacancyNameInput;

    @FindBy(xpath = "//label[text()='Job Title']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
    private WebElement jobTitleDropdown;

    @FindBy(xpath = "//label[text()='Hiring Manager']/parent::div/following-sibling::div//input")
    private WebElement hiringManagerInput;

    @FindBy(xpath = "//div[contains(@class, 'oxd-toast--success')]")
    private WebElement successToast;

    @FindBy(xpath = "//button[normalize-space()='Shortlist']")
    private WebElement shortlistButton;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveStatusButton;

    public void clickAddCandidate() {
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

    public void enterEmail(String email) {
        sendKeys(emailInput, email);
    }

    public void selectVacancy(String vacancy) {
        click(vacancyDropdown);
        // Note: Dynamic selection would require finding the element by text
    }

    public void uploadResume(String filePath) {
        uploadFile(resumeUpload, filePath);
    }

    public void clickSave() {
        click(saveButton);
    }

    public void addCandidate(String firstName, String middleName, String lastName, String email) {
        clickAddCandidate();
        enterFirstName(firstName);
        enterMiddleName(middleName);
        enterLastName(lastName);
        enterEmail(email);
        clickSave();
    }

    public void searchCandidateByName(String name) {
        sendKeys(candidateNameSearch, name);
        click(searchButton);
    }

    public boolean isCandidateRecordDisplayed() {
        return isDisplayed(candidateRecordRow);
    }

    public void navigateToVacancies() {
        click(vacanciesTab);
    }

    public void addVacancy(String vacancyName, String hiringManager) {
        click(addButton);
        sendKeys(vacancyNameInput, vacancyName);
        sendKeys(hiringManagerInput, hiringManager);
        click(saveButton);
    }

    public void changeCandidateStatus() {
        click(shortlistButton);
        click(saveStatusButton);
    }

    public boolean isSuccessToastDisplayed() {
        return isDisplayed(successToast);
    }
}
