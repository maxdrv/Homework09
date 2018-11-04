package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPage extends BasePage {

    public CartPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public boolean isPageLoaded() {
        return false;
    }

    @FindBy(xpath = "//div/h2")
    WebElement header;

    @FindBy(xpath = "//span[@class = 'price']//span[@id = 'cartPrice']")
    WebElement cartPrice;

    @FindBy(xpath = "//a[@class = 'btn-remove underline']")
    List<WebElement> deleteButtons;


    public void checkCart(HashMap<String, Integer> mapItems) {
        int sum = 0;
        String text;
        for (Map.Entry<String, Integer> entry : mapItems.entrySet()) {
            sum += entry.getValue();
        }
        int cartSum = Integer.parseInt(getText(cartPrice));

        Assert.assertEquals("CartPrice is not equal", sum, cartSum);

        for (Map.Entry<String, Integer> entry : mapItems.entrySet()) {
            text = entry.getKey();
            List<WebElement> itemCost = BaseSteps.getDriver().findElements(By.xpath("//tr[@class = 'cart-item']/td[@class = 'product-name']/a[contains(text(), '"+text+"')]"));
            Assert.assertEquals("Item not found in cart", 1, itemCost.size());
        }

        System.out.println("items ok");
    }

    public void deleteAll() {
        int size = deleteButtons.size();
        for (int i = 0; i < size; i++) {

            List<WebElement> deleteButton = BaseSteps.getDriver().findElements(By.xpath("//tbody//tr[1]/td[@class = 'a-left remove-td']//span"));
            Assert.assertEquals("Cant find delete button", 1, deleteButton.size());

            click(deleteButton.get(0));
        }
    }

    public void checkForEmpty() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Cart is not empty", "Ваша корзина пуста", getText(header));
    }
}
