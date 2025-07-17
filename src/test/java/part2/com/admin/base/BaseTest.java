package part2.com.admin.base;

import io.cosociety.admin.pages.BasePage;
import io.cosociety.admin.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basepage;
    protected LoginPage loginPage;
    public String url = "https://dashboard.cosociety.io/dev/";

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basepage = new BasePage();
        basepage.setDriver(driver);
        loginPage = new LoginPage();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
