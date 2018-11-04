package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class CatalogPage extends BasePage {

    public CatalogPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public boolean isPageLoaded() {
        return false;
    }


    //div[@class = 'product-info']
    //span[@itemprop = 'description' and contains(text(),'шаурма с курицей')]
    //span[@itemprop = 'description' and contains(text(),'шаурма с курицей')]/parent::div//span[@class = 'price']
    //span[@itemprop = 'description' and contains(text(),'шаурма с курицей')]/parent::div//button

    public int addItem(String text) {
        List<WebElement> itemCost = BaseSteps.getDriver().findElements(By.xpath("//div[@class = 'product-info']//h3//span[contains(text(), '"+text+"')]//parent::a/parent::h3/parent::div//span[@class = 'price']"));
        Assert.assertEquals("Cost not found", 1, itemCost.size());
        String price = getText(itemCost.get(0));
        String[] price1 =price.split("\\s+");
        int priceInt = Integer.parseInt(price1[0]);

        List<WebElement> itemOrder = BaseSteps.getDriver().findElements(By.xpath("//div[@class = 'product-info']//h3//span[contains(text(), '"+text+"')]//parent::a/parent::h3/parent::div//button"));
        Assert.assertEquals("Button not fount", 1, itemOrder.size());
        click(itemOrder.get(0));

        return priceInt;
    }



}
