package tests;

import io.qameta.allure.*;
import org.junit.Assert;
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

        Assert.assertTrue(mainPage.isBunsVisible());
    }

    @Test
    @Story("Переход в раздел Соусы")
    @Description("Проверяем переход в раздел Соусы")
    public void openSaucesTest() {
        mainPage.openSauces();

        Assert.assertTrue(mainPage.isSauceVisible());
    }

    @Test
    @Story("Переход в раздел Начинки")
    @Description("Проверяем переход в раздел Начинки")
    public void openFillingsTest() {
        mainPage.openFillings();

        Assert.assertTrue(mainPage.isFillingVisible());
    }
}