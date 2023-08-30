import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class GooglePage {
    public static void selectSite(String text) {
        $x("//h3[contains(text(), '%s')]".formatted(text)).click();
    }
    public void searchFor(String text) {
        $(By.name("q")).val(text).pressEnter();
    }
}