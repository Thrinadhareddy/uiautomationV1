package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]")
    private WebElement dashboardHeader;

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminMenu;

    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimMenu;

    @FindBy(xpath = "//span[text()='Leave']")
    private WebElement leaveMenu;

    @FindBy(xpath = "//span[text()='Time']")
    private WebElement timeMenu;

    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement recruitmentMenu;

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenu;

    @FindBy(xpath = "//span[text()='Performance']")
    private WebElement performanceMenu;

    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement dashboardMenu;

    @FindBy(xpath = "//p[contains(@class, 'oxd-userdropdown-name')]")
    private WebElement userDropdown;

    @FindBy(xpath = "//div[@class='oxd-grid-3 orangehrm-quick-launch']")
    private WebElement quickLaunchWidget;

    public boolean isDashboardDisplayed() {
        return isDisplayed(dashboardHeader);
    }

    public String getDashboardHeaderText() {
        return getText(dashboardHeader);
    }

    public void navigateToAdmin() {
        click(adminMenu);
        waitForUrlContains("admin");
    }

    public void navigateToPIM() {
        click(pimMenu);
        waitForUrlContains("pim");
    }

    public void navigateToLeave() {
        click(leaveMenu);
        waitForUrlContains("leave");
    }

    public void navigateToRecruitment() {
        click(recruitmentMenu);
        waitForUrlContains("recruitment");
    }

    public void navigateToMyInfo() {
        click(myInfoMenu);
        waitForUrlContains("myinfo");
    }

    public void navigateToPerformance() {
        click(performanceMenu);
        waitForUrlContains("performance");
    }

    public boolean isQuickLaunchWidgetDisplayed() {
        return isDisplayed(quickLaunchWidget);
    }

    public String getUserDropdownText() {
        return getText(userDropdown);
    }
}
