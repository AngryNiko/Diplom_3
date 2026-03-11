package tests;

import io.qameta.allure.*;
import org.junit.Test;

@Epic("Stellar Burgers UI")
@Feature("Конструктор бургеров")
public class ConstructorTest extends BaseTest {

    @Test
    @Story("Переход в раздел Булки")
    @Description("Проверяем переход в раздел Булки")
    public void openBunsTest() {
        mainPage.openSauces();
        mainPage.openBuns();
    }

    @Test
    @Story("Переход в раздел Соусы")
    @Description("Проверяем переход в раздел Соусы")
    public void openSaucesTest() {
        mainPage.openSauces();
    }

    @Test
    @Story("Переход в раздел Начинки")
    @Description("Проверяем переход в раздел Начинки")
    public void openFillingsTest() {
        mainPage.openFillings();
    }
}