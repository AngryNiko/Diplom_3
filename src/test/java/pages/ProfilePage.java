package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {

    private By logoutButton = By.xpath("//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыта ли страница профиля")
    public boolean isProfilePageOpened() {
        waitForUrl("/account/profile");
        return driver.getCurrentUrl().contains("/account/profile");
    }

    @Step("Выйти из аккаунта")
    public void logout() {
        driver.findElement(logoutButton).click();
    }
}