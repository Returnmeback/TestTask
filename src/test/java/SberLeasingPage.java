import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SberLeasingPage {
    public void clickParameters() {
        $x("//a[contains(text(),'Подобрать по параметрам')]").click();
    }
    public void selectInputByText(String text) {
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
    public void invokeCarColorFilter() {
        $x("//div[@class='sbl-filter-block__selector']").click();
    }
    public void clickButtonShowAllOffers() {
        $x("//a[@class='sbl-btn sbl-btn_medium w-100 sbl-btn_detail']").click();
    }
    public void checkIfOptionsPageHasCarMake (String carMake) {
        SelenideElement carModel = $x("(//div[@class='tags-filter__item'])[2]");
        carModel.shouldHave(text(carMake));
    }
    public void checkIfSelectedOptionHasCarMake (String carMake) {
        SelenideElement carModelAndMake = $x("//h1[@class='h2']");
        carModelAndMake.shouldHave(text(carMake));
    }
}
