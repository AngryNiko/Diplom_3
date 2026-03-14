package tests;

import api.User;
import api.UserClient;
import config.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import utils.Config;

import java.util.UUID;

public class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;

    protected UserClient userClient;

    protected String email;
    protected String password = "123456";
    protected String name = "User";

    protected String accessToken;

    @Before
    public void setUp() {

        userClient = new UserClient();

        email = "user_" + UUID.randomUUID() + "@mail.com";

        User user = new User(email, password, name);

        accessToken = userClient.createUser(user)
                .then()
                .extract()
                .path("accessToken");

        driver = DriverFactory.createDriver();

        driver.get(Config.BASE_URL);

        mainPage = new MainPage(driver);
    }

    @After
    public void tearDown() {

        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }

        driver.quit();
    }
}