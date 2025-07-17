package part2.com.admin.tests.login;

import io.cosociety.admin.pages.BasePage;
import io.cosociety.admin.pages.DashboardPage;
import io.cosociety.admin.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import part2.com.admin.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void resetLogin(){
        driver.get(url);
        loginPage = new LoginPage();
    }
//tests if login with incorrect password throws error
    @Test(priority = 1)
    public void testLoginErrorMessage() throws InterruptedException {
        loginPage.setUsername("masfour123@proton.me");
        loginPage.setPassword("123abc");
        loginPage.clickLoginButton();

        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualErrorMessage.contains("Your password is incorrect."));
    }

    //test login with correct credentials
    @Test(priority = 2)
    public void testCorrectLogin() throws InterruptedException {
        DashboardPage dashboardPage = loginPage.LogIntoAP("masfour123@proton.me" , "masfour123)");
        assertTrue(dashboardPage.isUpcomingMeetingsDisplayed(), " \n Dashboard header is not displayed \n");

    }
}
