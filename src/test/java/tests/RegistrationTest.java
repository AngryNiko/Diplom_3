package tests;

import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.RegisterPage;

import java.time.Duration;
import java.util.UUID;

@Epic("Stellar Burgers UI")
@Feature("Регистрация")
public class RegistrationTest extends BaseTest {

    @Test
    @Story("Успешная регистрация")
    @Description("Проверяем успешную регистрацию пользователя и возможность авторизации")
    public void registerSuccessTest() {

        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegister();

        RegisterPage registerPage = new RegisterPage(driver);

        String email = "user" + UUID.randomUUID() + "@mail.com";
        String password = "123456";

        registerPage.register("User", email, password);

        mainPage.clickProfile();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogin();

        mainPage.clickProfile();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains("/account/profile"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/account/profile"));
    }

    @Test
    @Story("Ошибка короткого пароля")
    @Description("Проверяем ошибку регистрации при коротком пароле")
    public void registerWrongPasswordTest() {

        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegister();

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.register(
                "User",
                "test" + UUID.randomUUID() + "@mail.com",
                "123"
        );

        Assert.assertTrue(driver.getPageSource().contains("Некорректный пароль"));
    }
}