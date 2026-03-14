package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private By nameInput = By.xpath("//label[text()='Имя']/following-sibling::input");
    private By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordInput = By.xpath("//label[text()='Пароль']/following-sibling::input");

    private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By loginLink = By.xpath("//a[text()='Войти']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Регистрация пользователя")
    public void register(String name, String email, String password) {

        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);

        driver.findElement(registerButton).click();
    }

    @Step("Ошибка неверного пароля")
    public boolean isPasswordErrorVisible() {
        return driver.getPageSource().contains("Некорректный пароль");
    }

    @Step("Нажать Войти")
    public void clickLogin() {
        driver.findElement(loginLink).click();
    }
}