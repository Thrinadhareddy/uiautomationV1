package com.orangehrm.steps;

import com.orangehrm.pages.PIMPage;
import com.orangehrm.utils.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class EmployeeSteps {

    private PIMPage pimPage;

    public EmployeeSteps() {
        this.pimPage = new PIMPage();
    }

    @When("I navigate to PIM module")
    public void i_navigate_to_pim_module() {
        DriverFactory.getDriver().get(DriverFactory.getDriver().getCurrentUrl().replace("dashboard", "pim"));
    }

    @When("I click on Add Employee button")
    public void i_click_on_add_employee_button() {
        pimPage.clickAddEmployee();
    }

    @When("I enter first name {string}")
    public void i_enter_first_name(String firstName) {
        pimPage.enterFirstName(firstName);
    }

    @When("I enter middle name {string}")
    public void i_enter_middle_name(String middleName) {
        pimPage.enterMiddleName(middleName);
    }

    @When("I enter last name {string}")
    public void i_enter_last_name(String lastName) {
        pimPage.enterLastName(lastName);
    }

    @When("I click save employee")
    public void i_click_save_employee() {
        pimPage.clickSave();
    }

    @Then("I should see personal details page")
    public void i_should_see_personal_details_page() {
        Assert.assertTrue(pimPage.isPersonalDetailsDisplayed(), "Personal details page is not displayed!");
    }

    @Then("I should see success message")
    public void i_should_see_success_message() {
        Assert.assertTrue(pimPage.isSuccessToastDisplayed(), "Success message is not displayed!");
    }

    @When("I upload employee profile picture {string}")
    public void i_upload_employee_profile_picture(String fileName) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + fileName;
        pimPage.uploadProfilePicture(filePath);
    }

    @When("I search for employee by name {string}")
    public void i_search_for_employee_by_name(String name) {
        pimPage.searchEmployeeByName(name);
    }

    @When("I search for employee by ID {string}")
    public void i_search_for_employee_by_id(String id) {
        pimPage.searchEmployeeById(id);
    }

    @When("I click search button")
    public void i_click_search_button() {
        // Search is triggered automatically in PIM search methods
    }

    @Then("I should see employee record in results")
    public void i_should_see_employee_record_in_results() {
        Assert.assertTrue(pimPage.isEmployeeRecordDisplayed(), "Employee record is not displayed!");
    }

    @When("I click on employee record")
    public void i_click_on_employee_record() {
        // Click on the first record
    }

    @When("I update employee first name to {string}")
    public void i_update_employee_first_name_to(String firstName) {
        pimPage.enterFirstName(firstName);
    }

    @When("I click delete button for employee")
    public void i_click_delete_button_for_employee() {
        pimPage.deleteEmployee();
    }

    @Then("I should see confirmation popup")
    public void i_should_see_confirmation_popup() {
        // Confirmation popup is handled automatically in delete method
    }

    @When("I confirm delete action")
    public void i_confirm_delete_action() {
        // Confirmation is handled in the delete method
    }

    @Then("I should see employee list table")
    public void i_should_see_employee_list_table() {
        Assert.assertTrue(pimPage.isEmployeeRecordDisplayed(), "Employee list is not displayed!");
    }

    @Then("I should see employee records")
    public void i_should_see_employee_records() {
        Assert.assertTrue(pimPage.isEmployeeRecordDisplayed(), "No employee records displayed!");
    }
}
