package UI;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import sberleasing.UI.extension.SetupUI;
import sberleasing.UI.page.GooglePage;
import sberleasing.UI.page.SberLeasingPage;

@ExtendWith(SetupUI.class)
public class SberTest {
    private final SberLeasingPage sberLeasingPage = new SberLeasingPage();

    @Test
    public void userSearchSber() {
        Selenide.open();
        final String carMake = "Sorento";

        new GooglePage().searchFor("СберЛизинг");
        GooglePage.selectSite("СберЛизинг — официальный сайт");
        sberLeasingPage.selectInputByText("Закрыть");
        sberLeasingPage.selectInputByText("Подобрать по параметрам");
        sberLeasingPage.enterValue("Город", "Москва");
        sberLeasingPage.enterValue("Марка", "KIA");
        sberLeasingPage.enterValue("Модель", carMake);
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
