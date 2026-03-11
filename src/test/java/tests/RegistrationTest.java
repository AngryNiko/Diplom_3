package tests;

import io.qameta.allure.*;
import org.junit.Test;
import pages.LoginPage;
import pages.RegisterPage;

import java.util.UUID;

@Epic("Stellar Burgers UI")
@Feature("Регистрация")
public class RegistrationTest extends BaseTest {

    @Test
    @Story("Успешная регистрация")
    @Description("Проверяем успешную регистрацию")
    public void registerSuccessTest() {

        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegister();

        RegisterPage registerPage = new RegisterPage(driver);

        String email = "user" + UUID.randomUUID() + "@mail.com";

        registerPage.register(
                "User",
                email,
                "123456"
        );
    }

    @Test
    @Story("Ошибка при регистрации")
    @Description("Проверяем ошибку при регистрации с неправильным паролем")
    public void registerWrongPasswordTest() {

        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegister();

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.register(
                "User",
                "test@mail.com",
                "123"
        );
    }
}