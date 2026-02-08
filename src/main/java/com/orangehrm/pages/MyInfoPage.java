package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyInfoPage extends BasePage {

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "middleName")
    private WebElement middleNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(xpath = "//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
    private WebElement nationalityDropdown;

    @FindBy(xpath = "//button[@type='submit'][1]")
    private WebElement savePersonalDetailsButton;

    @FindBy(xpath = "//a[text()='Contact Details']")
    private WebElement contactDetailsTab;

    @FindBy(xpath = "//label[text()='Street 1']/parent::div/following-sibling::div/input")
    private WebElement street1Input;

    @FindBy(xpath = "//label[text()='City']/parent::div/following-sibling::div/input")
    private WebElement cityInput;

    @FindBy(xpath = "//label[text()='Country']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
    private WebElement countryDropdown;

    @FindBy(xpath = "//a[text()='Emergency Contacts']")
    private WebElement emergencyContactsTab;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    @FindBy(name = "name")
    private WebElement emergencyContactNameInput;

    @FindBy(name = "relationship")
    private WebElement relationshipInput;

    @FindBy(xpath = "//label[text()='Home Telephone']/parent::div/following-sibling::div/input")
    private WebElement homeTelephoneInput;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement profilePictureUpload;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class, 'oxd-toast--success')]")
    private WebElement successToast;

    @FindBy(xpath = "//h6[text()='Personal Details']")
    private WebElement personalDetailsHeader;

    public boolean isPersonalDetailsDisplayed() {
        return isDisplayed(personalDetailsHeader);
    }

    public void updatePersonalDetails(String firstName, String middleName, String lastName) {
        sendKeys(firstNameInput, firstName);
        sendKeys(middleNameInput, middleName);
        sendKeys(lastNameInput, lastName);
        click(savePersonalDetailsButton);
    }

    public void selectNationality(String nationality) {
        click(nationalityDropdown);
        // Dynamic selection by text would be implemented
    }

    public void navigateToContactDetails() {
        click(contactDetailsTab);
    }

    public void addContactInformation(String street, String city) {
        sendKeys(street1Input, street);
        sendKeys(cityInput, city);
        click(saveButton);
    }

    public void selectCountry(String country) {
        click(countryDropdown);
        // Dynamic selection by text would be implemented
    }

    public void navigateToEmergencyContacts() {
        click(emergencyContactsTab);
    }

    public void addEmergencyContact(String name, String relationship, String phone) {
        click(addButton);
        sendKeys(emergencyContactNameInput, name);
        sendKeys(relationshipInput, relationship);
        sendKeys(homeTelephoneInput, phone);
        click(saveButton);
    }

    public void uploadProfilePicture(String filePath) {
        uploadFile(profilePictureUpload, filePath);
    }

    public boolean isSuccessToastDisplayed() {
        return isDisplayed(successToast);
    }
}
