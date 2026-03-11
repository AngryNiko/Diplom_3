package tests;

import config.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;

    @Before
    public void setUp() {

        driver = DriverFactory.createDriver();

        driver.get("https://stellarburgers.education-services.ru/");

        mainPage = new MainPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}