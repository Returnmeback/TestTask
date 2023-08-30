import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SberLeasingPage {
    public void clickParameters() {
        $x("//a[contains(text(),'Подобрать по параметрам')]").click();
    }
    public void clicker (String text) {
        $(byText(text)).click();
    }
    public void enterValue(String text, String setValue) {
        $x("//span[contains(text(),'" + text + "')]").click();
        $x("//label[contains(text(),'" + setValue + "')]").click();
    }
    private final By slider = byClassName("el-slider__runway");
    public void setSliderInCategory(String category){
        $(byText(category)).parent().scrollTo().find(slider).click();
    }
    public void colorSelection () {
        $(byXpath("//label[@class='sbl-filter-block__selector-current-value']")).click();
    }
    public void carSelection () {
        $(byXpath("//img[@class='car-card__item-description__image img-fluid rounded-16']")).click();
    }
}
