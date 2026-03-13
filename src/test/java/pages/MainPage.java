package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    private By bunsItem = By.xpath("//p[contains(text(),'Флюоресцентная булка R2-D3')]");
    private By sauceItem = By.xpath("//p[contains(text(),'Соус Spicy-X')]");
    private By fillingItem = By.xpath("//p[contains(text(),'Мясо бессмертных моллюсков Protostomia')]");

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

        WebElement element = driver.findElement(buns);

        scrollToElement(element);
        waitForClick(element);
        element.click();
    }

    @Step("Перейти в раздел Соусы")
    public void openSauces() {

        WebElement element = driver.findElement(sauces);

        scrollToElement(element);
        waitForClick(element);
        element.click();
    }

    @Step("Перейти в раздел Начинки")
    public void openFillings() {

        WebElement element = driver.findElement(fillings);

        scrollToElement(element);
        waitForClick(element);
        element.click();
    }

    public boolean isBunsVisible() {
        return driver.findElement(bunsItem).isDisplayed();
    }

    public boolean isSauceVisible() {
        return driver.findElement(sauceItem).isDisplayed();
    }

    public boolean isFillingVisible() {
        return driver.findElement(fillingItem).isDisplayed();
    }
}