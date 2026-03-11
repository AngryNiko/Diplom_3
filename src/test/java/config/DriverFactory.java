package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.Allure;

public class DriverFactory {

    public static WebDriver createDriver() {

        String browser = System.getProperty("browser", "chrome");

        Allure.label("browser", browser);

        if (browser.equals("yandex")) {

            System.setProperty(
                    "webdriver.chrome.driver",
                    "C:/Users/angry/Downloads/yandexdriver.exe"
            );

            return new ChromeDriver();
        }
            return new ChromeDriver();
        }
}