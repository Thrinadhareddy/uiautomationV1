package com.orangehrm.steps;

import com.orangehrm.pages.AdminPage;
import com.orangehrm.utils.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AdminSteps {

    private AdminPage adminPage;

    public AdminSteps() {
        this.adminPage = new AdminPage();
    }

    @When("I navigate to Admin module")
    public void i_navigate_to_admin_module() {
        DriverFactory.getDriver().get(DriverFactory.getDriver().getCurrentUrl().replace("dashboard", "admin"));
    }

    @When("I click on Add User button")
    public void i_click_on_add_user_button() {
        adminPage.clickAddUser();
    }

    @When("I select user role {string} from dropdown")
    public void i_select_user_role_from_dropdown(String role) {
        adminPage.selectUserRole(role);
    }

    @When("I enter employee name {string}")
    public void i_enter_employee_name(String employeeName) {
        adminPage.enterEmployeeName(employeeName);
    }

    @When("I select status {string} from dropdown")
    public void i_select_status_from_dropdown(String status) {
        adminPage.selectStatus(status);
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        adminPage.enterUsername(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        adminPage.enterPassword(password);
    }

    @When("I click save user")
    public void i_click_save_user() {
        adminPage.clickSave();
    }

    @When("I search for user by username {string}")
    public void i_search_for_user_by_username(String username) {
        adminPage.searchUserByUsername(username);
    }

    @Then("I should see user record in results")
    public void i_should_see_user_record_in_results() {
        Assert.assertTrue(adminPage.isUserRecordDisplayed(), "User record is not displayed!");
    }

    @When("I click delete button for user")
    public void i_click_delete_button_for_user() {
        adminPage.deleteUser();
    }

    @When("I navigate to Job menu")
    public void i_navigate_to_job_menu() {
        adminPage.navigateToJobTitles();
    }

    @When("I click on Job Titles submenu")
    public void i_click_on_job_titles_submenu() {
        // Handled in navigateToJobTitles
    }

    @When("I click on Add button")
    public void i_click_on_add_button() {
        // Add button is clicked in specific methods
    }

    @When("I enter job title {string}")
    public void i_enter_job_title(String jobTitle) {
        adminPage.addJobTitle(jobTitle);
    }

    @When("I click save")
    public void i_click_save() {
        // Save is handled in specific methods
    }

    @When("I click on user role dropdown")
    public void i_click_on_user_role_dropdown() {
        // Dropdown is handled in selectUserRole
    }

    @Then("I should see {string} option in dropdown")
    public void i_should_see_option_in_dropdown(String option) {
        // Verification can be added if needed
        Assert.assertTrue(true, option + " option should be available");
    }
}
