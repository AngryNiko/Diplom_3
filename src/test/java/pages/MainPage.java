package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By profileButton = By.xpath("//p[text()='Личный Кабинет']");
    private By constructorButton = By.xpath("//p[text()='Конструктор']");

    private By buns = By.xpath("//span[text()='Булки']");
    private By sauces = By.xpath("//span[text()='Соусы']");
    private By fillings = By.xpath("//span[text()='Начинки']");

    @Step("Нажать Войти в аккаунт")
    public void clickLoginButton() {

        WebElement element = driver.findElement(loginButton);

        waitForClick(element);
        element.click();
    }

    @Step("Нажать Личный кабинет")
    public void clickProfile() {

        WebElement element = driver.findElement(profileButton);

        waitForClick(element);
        element.click();
    }

    @Step("Перейти в раздел Булки")
    public void openBuns() {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(buns));

        scrollToElement(element);
        element.click();
    }

    @Step("Перейти в раздел Соусы")
    public void openSauces() {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(sauces));

        scrollToElement(element);
        element.click();
    }

    @Step("Перейти в раздел Начинки")
    public void openFillings() {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(fillings));

        scrollToElement(element);
        element.click();
    }

    public boolean isBunsActive() {
        return waitForTabActive(buns);
    }

    public boolean isSaucesActive() {
        return waitForTabActive(sauces);
    }

    public boolean isFillingsActive() {
        return waitForTabActive(fillings);
    }
}