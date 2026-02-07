package com.orangehrm.steps;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ConfigReader;
import com.orangehrm.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    private LoginPage loginPage;

    @Before
    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    // Need a local driver reference for setup/teardown if needed,
    // but PageObjects handle driver via DriverFactory.
    // Making it explicit.
    private org.openqa.selenium.WebDriver driver;

    @Given("I am on the OrangeHRM login page")
    public void i_am_on_the_orange_hrm_login_page() {
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("I enter valid username {string} and password {string}")
    public void i_enter_valid_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    // Reusing the same step for invalid/valid as the action is the same
    @When("I enter invalid username {string} and password {string}")
    public void i_enter_invalid_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "Dashboard is not displayed!");
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMessage) {
        Assert.assertEquals(loginPage.getErrorMessage(), expectedMessage);
    }
}
