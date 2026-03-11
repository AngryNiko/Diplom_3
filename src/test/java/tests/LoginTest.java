package tests;

import io.qameta.allure.*;
import org.junit.Test;
import pages.LoginPage;
import pages.RegisterPage;
import pages.ForgotPasswordPage;

@Epic("Stellar Burgers UI")
@Feature("Авторизация")
public class LoginTest extends BaseTest {

    @Test
    @Story("Вход через кнопку «Войти в аккаунт»")
    @Description("Проверяем вход через кнопку на главной странице")
    public void loginFromMainPageTest() {

        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputEmail("test@mail.com");
        loginPage.inputPassword("123456");

        loginPage.clickLogin();
    }

    @Test
    @Story("Вход через кнопку «Личный кабинет»")
    @Description("Проверяем вход через кнопку Личный кабинет")
    public void loginFromProfileTest() {

        mainPage.clickProfile();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputEmail("test@mail.com");
        loginPage.inputPassword("123456");

        loginPage.clickLogin();
    }

    @Test
    @Story("Вход через кнопку в форме регистрации")
    @Description("Проверяем вход через кнопку в форме регистрации")
    public void loginFromRegisterPageTest() {

        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLogin();

        loginPage.inputEmail("test@mail.com");
        loginPage.inputPassword("123456");

        loginPage.clickLogin();
    }

    @Test
    @Story("Вход через кнопку в форме восстановления пароля")
    @Description("Проверяем вход через кнопку в форме восстановления пароля")
    public void loginFromForgotPasswordTest() {

        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToForgotPassword();

        ForgotPasswordPage forgotPasswordPage =
                new ForgotPasswordPage(driver);

        forgotPasswordPage.clickLogin();

        loginPage.inputEmail("test@mail.com");
        loginPage.inputPassword("123456");

        loginPage.clickLogin();
    }
}