package tests;

import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Test;
import pages.*;

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

        ProfilePage profilePage = new ProfilePage(driver);

        Assert.assertTrue(profilePage.isProfilePageOpened());

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