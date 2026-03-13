package tests;

import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;

@Epic("Stellar Burgers UI")
@Feature("Авторизация")
public class LoginTest extends BaseTest {

    private void login(LoginPage loginPage) {

        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogin();
    }

    public void checkLoginAndLogout() {

        mainPage.clickProfile();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains("/account/profile"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/account/profile"));

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.logout();
    }

    @Test
    @Story("Вход через кнопку «Войти в аккаунт»")
    public void loginFromMainPageTest() {

        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);

        login(loginPage);

        checkLoginAndLogout();
    }

    @Test
    @Story("Вход через кнопку «Личный кабинет»")
    public void loginFromProfileTest() {

        mainPage.clickProfile();

        LoginPage loginPage = new LoginPage(driver);

        login(loginPage);

        checkLoginAndLogout();
    }

    @Test
    @Story("Вход через кнопку в форме регистрации")
    public void loginFromRegisterPageTest() {

        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLogin();

        login(loginPage);

        checkLoginAndLogout();
    }

    @Test
    @Story("Вход через кнопку в форме восстановления пароля")
    public void loginFromForgotPasswordTest() {

        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToForgotPassword();

        ForgotPasswordPage forgotPage = new ForgotPasswordPage(driver);
        forgotPage.clickLogin();

        login(loginPage);

        checkLoginAndLogout();
    }
}