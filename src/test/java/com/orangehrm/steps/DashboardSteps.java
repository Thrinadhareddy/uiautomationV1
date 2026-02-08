package com.orangehrm.steps;

import com.orangehrm.pages.DashboardPage;
import com.orangehrm.utils.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardSteps {

    private DashboardPage dashboardPage;
    private WebDriver driver;

    public DashboardSteps() {
        this.driver = DriverFactory.getDriver();
        this.dashboardPage = new DashboardPage();
    }

    @Then("I should see the dashboard header")
    public void i_should_see_the_dashboard_header() {
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard header is not displayed!");
    }

    @Then("I should see the user dropdown")
    public void i_should_see_the_user_dropdown() {
        Assert.assertFalse(dashboardPage.getUserDropdownText().isEmpty(), "User dropdown is not displayed!");
    }

    @When("I click on PIM menu")
    public void i_click_on_pim_menu() {
        dashboardPage.navigateToPIM();
    }

    @Then("I should be on PIM page")
    public void i_should_be_on_pim_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("pim"), "Not on PIM page!");
    }

    @When("I navigate back to dashboard")
    public void i_navigate_back_to_dashboard() {
        driver.navigate().back();
    }

    @When("I click on Admin menu")
    public void i_click_on_admin_menu() {
        dashboardPage.navigateToAdmin();
    }

    @Then("I should be on Admin page")
    public void i_should_be_on_admin_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"), "Not on Admin page!");
    }

    @Then("I should see the quick launch widget")
    public void i_should_see_the_quick_launch_widget() {
        Assert.assertTrue(dashboardPage.isQuickLaunchWidgetDisplayed(), "Quick launch widget is not displayed!");
    }
}
