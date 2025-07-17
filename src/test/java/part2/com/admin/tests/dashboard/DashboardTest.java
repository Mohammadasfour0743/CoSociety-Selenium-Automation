package part2.com.admin.tests.dashboard;

import io.cosociety.admin.pages.DashboardPage;
import static org.testng.Assert.*;
import static utilities.Utils.loginToDashboard;

import io.cosociety.admin.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import part2.com.admin.base.BaseTest;
import utilities.Utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DashboardTest extends BaseTest {

    DashboardPage dashboardPage;

    @BeforeClass
    public void loginBeforeTest() throws InterruptedException {
        dashboardPage = Utils.loginToDashboard("masfour123@proton.me", "masfour123)");
    }



    @Test(priority = 1)
    public void testUsernameIsCorrect(){

        assertTrue(dashboardPage.isUsernameCorrect());
    }

    @Test(priority = 2)
    public void testTroubleshootGuide(){
        assertTrue(dashboardPage.isTroubleshootCorrect());
    }


    @Test(priority = 3)
    public void testQuickMeetings() throws InterruptedException {
        dashboardPage.createQuickEvent();
        assertTrue(dashboardPage.isQuickEventDisplayed());
    }



   @Test(priority=4)
    public void testQuickStartGuide() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        dashboardPage.clickQuickstart();
        String actualHeader = dashboardPage.getQuickstartHeader();
        assertEquals(actualHeader, "Before you get started");
    }

    @Test(priority = 5)
    public void testSystemRequirement() throws InterruptedException {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        dashboardPage.clickSystemRequirements();
        String actualHeader = dashboardPage.getSystemRequirementHeader();
        assertEquals(actualHeader, "System Requirements");
    }

    @Test(priority = 6)
    public void testAPLink(){
        String ActualURLAfterAP = dashboardPage.getURLAfterAP();
        assertEquals(ActualURLAfterAP, "https://admin.cosociety.io/dev/home");
    }
}
