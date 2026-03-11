package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By emailInput = By.xpath("//input[@name='name']");
    private By passwordInput = By.xpath("//input[@name='Пароль']");

    private By loginButton = By.xpath("//button[text()='Войти']");

    private By registerLink = By.xpath("//a[text()='Зарегистрироваться']");
    private By forgotPassword = By.xpath("//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввести email")
    public void inputEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void inputPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажать кнопку Войти")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    @Step("Перейти на регистрацию")
    public void goToRegister() {
        driver.findElement(registerLink).click();
    }

    @Step("Перейти на восстановление пароля")
    public void goToForgotPassword() {
        driver.findElement(forgotPassword).click();
    }
}