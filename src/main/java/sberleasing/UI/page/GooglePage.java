package sberleasing.ui.page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class GooglePage {
    public  void selectSite(String linkName) {
        $x("//h3[contains(text(), '%s')]".formatted(linkName)).click();
    }
    public void searchFor(String text) {
        $(By.name("q")).val(text).pressEnter();
    }
}