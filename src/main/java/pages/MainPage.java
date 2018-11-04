package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainPage extends BasePage {

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public boolean isPageLoaded() {
        return false;
    }

    @FindBy(xpath = "//*[@id = 'desktopMenuMain']//a[@class = 'type-global-nav-link-1' and contains(text(), 'Меню доставки')]")
    WebElement mainMenu;

    @FindBy(xpath = "//span[@class ='main-menu__category type-global-nav-link-1' and contains(text(), 'Меню доставки')]")
    WebElement deliveryMenu;

    @FindBy(xpath = "//*[@id = 'desktopMenuMain']//a[@href='/catalog']/..//div[@class = 'main-menu__wrap']/ul[contains(@class,'main-menu__list')]/li")
    WebElement menuItems;

    @FindBy(xpath = "//span[@class ='top-cart__total-cost desktop-only']")
    WebElement cartButton;

    @FindBy(xpath = "//div[@id = 'pw-confirm__close']")
    WebElement closeWindow;

    public void window() {
        String parentWindowHandler = BaseSteps.getDriver().getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = BaseSteps.getDriver().getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        BaseSteps.getDriver().switchTo().window(subWindowHandler); // switch to popup window

        click(closeWindow);

        BaseSteps.getDriver().switchTo().window(parentWindowHandler);  // switch back to parent window
    }

    public void clickMainMenu() {
/*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/

        click(mainMenu);

/*        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    public void clickMenu(String text) {
        //li[@class = 'filters-list__item']/a[contains(text(), '"+text+"')]
        //*[@id = 'desktopMenuMain']//li[@class = 'level-2__item']/a[contains(text(), '" + text + "')]
        List<WebElement> href = BaseSteps.getDriver().findElements(By.xpath("//*[@id = 'desktopMenuMain']//li[@class = 'level-2__item']/a[contains(text(), '" + text + "')]"));

        Assert.assertEquals("Menu not found", 1, href.size());
        click(href.get(0));

/*        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    public void clickCart() {
        click(cartButton);

/*        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

}
