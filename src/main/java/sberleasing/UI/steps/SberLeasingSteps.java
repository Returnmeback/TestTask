package sberleasing.ui.steps;

import io.qameta.allure.Step;
import sberleasing.ui.page.SberLeasingPage;

public class SberLeasingSteps {
    SberLeasingPage sberLeasingPage = new SberLeasingPage();

    @Step("Выбор элемента по тексту")
    public void selectInputByText(String text) {
        sberLeasingPage.selectInputByText(text);
    }

    @Step("В категории {category} выбираем значение {setValue}")
    public void enterValue(String category, String setValue) {
        sberLeasingPage.enterValue(category, setValue);
    }

    @Step("Выставляем значение слайдера в блоке {category}")
    public void setSliderByCategoryName(String text) {
        sberLeasingPage.setSliderInCategory(text);
    }

    @Step("Выбираем цвет")
    public void setColor() {
        sberLeasingPage.invokeCarColorFilter();
    }

    @Step("Проверяем что в списке опций есть марка {carMake}")
    public void checkIfOptionsPageHasCarMake(String carMake) {
        sberLeasingPage.checkIfSelectedOptionHasCarMake(carMake);
    }

    @Step("Проверяем что в выбранной опции есть марка {carMake}")
    public void checkIfSelectedOptionHasCarMake(String carMake) {
        sberLeasingPage.checkIfSelectedOptionHasCarMake(carMake);
    }

    @Step("Нажимаем Показать все варианты")
    public void clickButtonShowAllOffers() {
        sberLeasingPage.clickButtonShowAllOffers();
    }
}
