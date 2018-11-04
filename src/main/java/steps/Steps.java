package steps;

import io.qameta.allure.Step;
import pages.CartPage;
import pages.CatalogPage;
import pages.MainPage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Steps {
    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    CartPage cartPage = new CartPage();

    HashMap<String, Integer> items = new HashMap<>();

    @Step("Убрать всплывающее окно")
    public void window(){
        mainPage.window();
    }

    @Step("Перейти в меню доставки")
    public void clickMainMenu() {
        new MainPage().clickMainMenu();
    }

    @Step("Нажать на кнопку меню {0}")
    public void clickMenuItem(String text) {
        new MainPage().clickMenu(text);
    }

    @Step("Добавить в корзину {0}")
    public void addToCart(String text) {
        int price = new CatalogPage().addItem(text);
        items.put(text, price);
    }

    @Step("Перейти в корзину")
    public void moveToCart() {
        new MainPage().clickCart();

        System.out.println(items);
    }

    @Step("Проверить содержимое корзины")
    public void checkCart() {
        new CartPage().checkCart(items);
    }

    @Step("Удалить содержимое корзины")
    public void deleteCartItems() {
        new CartPage().deleteAll();
    }

    @Step("Проверить, что корзина пуста")
    public void checkForEmpty() {
        new CartPage().checkForEmpty();
    }
}
