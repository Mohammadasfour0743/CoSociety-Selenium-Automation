package io.cosociety.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;

import java.time.Duration;

public class DashboardPage extends BasePage{
    private By upcomingMeetingsHeader = By.xpath("//p[text()='Upcoming meetings']");
    private By username = By.xpath("//*[text()='Mohammad Asfour']");

    private By QuickEvent = By.xpath("//button[text()=' Create a Quick Event']");
    private By startEventButton = By.xpath("//button[text()='Start an event']");
    private By quickEventHeader = By.xpath("//*[text()='Quick Event']");

    private By troubleshootButton = By.xpath("//p[text()='Troubleshooting Guide']");
    private By troubleshootHeader = By.xpath("//h3[text()='Having issues? Try this first']");

    private By APButton = By.xpath("//button[starts-with(normalize-space(), 'Admin Panel')]");

    private By quickstart = By.xpath("//span[text()='Quickstart Guide']");
    private By quickstartHeader = By.tagName("h2");

    private By systemRequirement = By.xpath("//*[text()=' System Requirements']");
    private By systemRequirementHeader = By.tagName("h2");

    public boolean isUpcomingMeetingsDisplayed(){
        WaitUtils.waitForVisibility(driver, upcomingMeetingsHeader,10);
        return find(upcomingMeetingsHeader).isDisplayed();
    }



    public boolean isUsernameCorrect(){
        WaitUtils.waitForVisibility(driver, username,10);
        return find(username).isDisplayed();
    }


    public void createQuickEvent() throws InterruptedException {
        click(QuickEvent);
        WaitUtils.waitForClickable(driver,startEventButton, 5);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(300));
        click(startEventButton);
    }

    public boolean isQuickEventDisplayed(){
        WaitUtils.waitForVisibility(driver, quickEventHeader,10);
        return find(quickEventHeader).isDisplayed();
    }

    public boolean isTroubleshootCorrect(){
        click(troubleshootButton);
        WaitUtils.waitForVisibility(driver, troubleshootHeader, 5);
        return find(troubleshootHeader).isDisplayed();
    }

    public String getURLAfterAP(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(APButton));
        //WaitUtils.waitForVisibility(driver,APButton,5);
        click(APButton);
        return driver.getCurrentUrl();
    }






    public void clickQuickstart(){
       // WaitUtils.waitForClickable(driver, quickstart, 10);
        click(quickstart);
    }

    public String getQuickstartHeader(){
        return find(quickstartHeader).getText();
    }



    public void clickSystemRequirements(){
        WaitUtils.waitForClickable(driver, systemRequirement, 10);
        click(systemRequirement);
    }

    public String getSystemRequirementHeader(){
        return find(systemRequirementHeader).getText();
    }


}
