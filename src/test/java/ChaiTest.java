
import org.junit.Test;
import steps.BaseSteps;
import steps.Steps;

public class ChaiTest extends BaseSteps {

    Steps steps = new Steps();

    @Test
    public void myTest() {

        //steps.window();

        steps.clickMainMenu();
        steps.clickMenuItem("Бургеры и Шаурма");
        steps.addToCart("Шаурма с курицей");

        steps.clickMainMenu();
        steps.clickMenuItem("Салаты и Закуски");
        steps.addToCart("Ассорти сыров");

        steps.clickMainMenu();
        steps.clickMenuItem("Плов");
        steps.addToCart("Плов Чайханский");

        steps.moveToCart();
        steps.checkCart();
        steps.deleteCartItems();
        steps.checkForEmpty();

    }
}
