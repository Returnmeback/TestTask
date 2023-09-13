package sberleasing.ui.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SberLeasingPage {
    public void selectInputByText(String text) {
        $(byText(text)).click();
    }

    public void enterValue(String text, String setValue) {
        $x("//span[contains(text(),'%s')]".formatted(text)).click();
        $x("//label[contains(text(), '%s')]".formatted(setValue)).click();
    }

    public void setSliderInCategory(String category) {
        $(byText(category)).parent().scrollTo().find((byClassName("el-slider__runway"))).click();
    }

    public void invokeCarColorFilter() {
        $x("//div[@class='sbl-filter-block__selector']").click();
    }

    public void clickButtonShowAllOffers() {
        $x("//a[@class='sbl-btn sbl-btn_medium w-100 sbl-btn_detail']").click();
    }

    public void checkIfOptionsPageHasCarMake(String carMake) {
        SelenideElement carModel = $x("//div[@class='car-card__item-mark']");
        carModel.shouldHave(text(carMake));
    }

    public void checkIfSelectedOptionHasCarMake(String carMake) {
        SelenideElement carModelAndMake = $x("//h1[@class='h2']");
        carModelAndMake.shouldHave(text(carMake));
    }
}
