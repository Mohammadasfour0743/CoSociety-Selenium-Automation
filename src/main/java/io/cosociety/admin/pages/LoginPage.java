package io.cosociety.admin.pages;

import org.openqa.selenium.By;
import utilities.WaitUtils;

public class LoginPage extends BasePage{

    private By signin = By.xpath("//button[text()='Sign in']");
    private By usernameField = By.id("signInName");
    private By passwordField = By.id("password");
    private By confirmSignIn = By.id("next");
    private By errorMessage = By.xpath("//p[text()='Your password is incorrect.']");

    public void setUsername(String username) throws InterruptedException {
        WaitUtils.waitForVisibility(driver, signin,10);
        find(signin).click();
        WaitUtils.waitForVisibility(driver, usernameField,10);
    set(usernameField, username);
    }
    public void setPassword(String password){
        set(passwordField, password);
    }


    public DashboardPage clickLoginButton(){
        click(confirmSignIn);
        return new DashboardPage();
    }

    public DashboardPage LogIntoAP(String username, String password) throws InterruptedException {
        WaitUtils.waitForVisibility(driver, signin,10);
        find(signin).click();
        WaitUtils.waitForVisibility(driver, usernameField,10);
        set(usernameField, username);
        set(passwordField, password);
        return clickLoginButton();
    }

    public String getErrorMessage(){
        WaitUtils.waitForVisibility(driver,errorMessage,2);
        return find(errorMessage).getText();
    }
}
