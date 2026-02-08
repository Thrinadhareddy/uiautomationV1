package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[contains(@class, 'oxd-alert-content-text')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]")
    private WebElement dashboardHeader;

    @FindBy(xpath = "//span[contains(@class, 'oxd-input-field-error-message')]")
    private WebElement requiredFieldError;

    @FindBy(xpath = "//p[contains(@class, 'orangehrm-login-forgot')]/a")
    private WebElement forgotPasswordLink;

    public void enterUsername(String username) {
        sendKeys(usernameInput, username);
    }

    public void enterPassword(String password) {
        sendKeys(passwordInput, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isDashboardDisplayed() {
        return dashboardHeader.isDisplayed();
    }

    public boolean isRequiredFieldErrorDisplayed() {
        return isDisplayed(requiredFieldError);
    }

    public void clickForgotPassword() {
        click(forgotPasswordLink);
    }
}
