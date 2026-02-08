package com.orangehrm.steps;

import com.orangehrm.pages.RecruitmentPage;
import com.orangehrm.utils.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RecruitmentSteps {

    private RecruitmentPage recruitmentPage;

    public RecruitmentSteps() {
        this.recruitmentPage = new RecruitmentPage();
    }

    @When("I navigate to Recruitment module")
    public void i_navigate_to_recruitment_module() {
        DriverFactory.getDriver().get(DriverFactory.getDriver().getCurrentUrl().replace("dashboard", "recruitment"));
    }

    @When("I click on Add Candidate button")
    public void i_click_on_add_candidate_button() {
        recruitmentPage.clickAddCandidate();
    }

    @When("I enter candidate first name {string}")
    public void i_enter_candidate_first_name(String firstName) {
        recruitmentPage.enterFirstName(firstName);
    }

    @When("I enter candidate middle name {string}")
    public void i_enter_candidate_middle_name(String middleName) {
        recruitmentPage.enterMiddleName(middleName);
    }

    @When("I enter candidate last name {string}")
    public void i_enter_candidate_last_name(String lastName) {
        recruitmentPage.enterLastName(lastName);
    }

    @When("I enter candidate email {string}")
    public void i_enter_candidate_email(String email) {
        recruitmentPage.enterEmail(email);
    }

    @When("I upload resume {string}")
    public void i_upload_resume(String fileName) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + fileName;
        recruitmentPage.uploadResume(filePath);
    }

    @When("I click save candidate")
    public void i_click_save_candidate() {
        recruitmentPage.clickSave();
    }

    @When("I search for candidate by name {string}")
    public void i_search_for_candidate_by_name(String name) {
        recruitmentPage.searchCandidateByName(name);
    }

    @Then("I should see candidate record in results")
    public void i_should_see_candidate_record_in_results() {
        Assert.assertTrue(recruitmentPage.isCandidateRecordDisplayed(), "Candidate record is not displayed!");
    }

    @When("I click on candidate record")
    public void i_click_on_candidate_record() {
        // Click handled in page
    }

    @When("I click on shortlist button")
    public void i_click_on_shortlist_button() {
        recruitmentPage.changeCandidateStatus();
    }

    @When("I click save status")
    public void i_click_save_status() {
        // Handled in changeCandidateStatus
    }

    @When("I navigate to Vacancies tab")
    public void i_navigate_to_vacancies_tab() {
        recruitmentPage.navigateToVacancies();
    }

    @When("I enter vacancy name {string}")
    public void i_enter_vacancy_name(String vacancyName) {
        // Handled in addVacancy
    }

    @When("I enter hiring manager {string}")
    public void i_enter_hiring_manager(String hiringManager) {
        recruitmentPage.addVacancy("", hiringManager);
    }
}
