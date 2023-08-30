import static com.codeborne.selenide.Selenide.*;

import org.junit.Test;
public class SberTest {
    @Test
    public void userSearchSber() {
        String carMake = "KIA";
        SberLeasingPage sberLeasingPage = new SberLeasingPage();
        open("https://google.com");
        new GooglePage().searchFor("СберЛизинг");
        GooglePage.selectSite("СберЛизинг — официальный сайт");
        sberLeasingPage.selectInputByText("Закрыть");
        sberLeasingPage.clickParameters();
        sberLeasingPage.enterValue("Город", "Москва");
        sberLeasingPage.enterValue("Марка", "KIA");
        sberLeasingPage.enterValue("Модель", "Sorento");
        sberLeasingPage.setSliderInCategory("Мощность двигателя");
        sberLeasingPage.selectInputByText("полный");
        sberLeasingPage.selectInputByText("автомат");
        sberLeasingPage.selectInputByText("кроссовер");
        sberLeasingPage.selectInputByText("бензин");
        sberLeasingPage.invokeCarColorFilter();
        sberLeasingPage.selectInputByText("черный");
        sberLeasingPage.setSliderInCategory("Объём двигателя");
        sberLeasingPage.selectInputByText("Показать все предложения");
        sberLeasingPage.checkIfOptionsPageHasCarMake(carMake);
        sberLeasingPage.clickButtonShowAllOffers();
        sberLeasingPage.checkIfSelectedOptionHasCarMake(carMake);
    }
}
