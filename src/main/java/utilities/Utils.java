package utilities;

import io.cosociety.admin.pages.DashboardPage;
import io.cosociety.admin.pages.LoginPage;


import static io.cosociety.admin.pages.BasePage.driver;

public class Utils {
    public static String url = "https://dashboard.cosociety.io/dev/";

    public static DashboardPage loginToDashboard(String username, String password) throws InterruptedException {
        driver.get(url); // Ensure you're on the login page
        LoginPage loginPage = new LoginPage();
        return loginPage.LogIntoAP(username, password);
    }
}
