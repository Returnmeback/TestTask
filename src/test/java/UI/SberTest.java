package UI;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sberleasing.ui.extension.SetupUI;
import sberleasing.ui.steps.GoogleSearchSteps;
import sberleasing.ui.steps.SberLeasingSteps;

@ExtendWith(SetupUI.class)
public class SberTest {
    private final GoogleSearchSteps googleSearchSteps = new GoogleSearchSteps();
    private final SberLeasingSteps sberLeasingSteps = new SberLeasingSteps();

    @Test
    public void userSearchSber() {
//        Selenide.open("https://www.google.com/");
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.get("https://google.com");
        final String carMake = "Sorento";
        googleSearchSteps.googleSearch("СберЛизинг");
        googleSearchSteps.openSiteFromGoogleSearch("СберЛизинг — официальный сайт");
        sberLeasingSteps.selectInputByText("Закрыть");
        sberLeasingSteps.selectInputByText("Подобрать по параметрам");
        sberLeasingSteps.enterValue("Город", "Москва");
        sberLeasingSteps.enterValue("Марка", "KIA");
        sberLeasingSteps.enterValue("Модель", carMake);
        sberLeasingSteps.setSliderByCategoryName("Мощность двигателя");
        sberLeasingSteps.selectInputByText("полный");
        sberLeasingSteps.selectInputByText("автомат");
        sberLeasingSteps.selectInputByText("кроссовер");
        sberLeasingSteps.selectInputByText("бензин");
        sberLeasingSteps.setColor();
        sberLeasingSteps.selectInputByText("черный");
        sberLeasingSteps.setSliderByCategoryName("Объём двигателя");
        sberLeasingSteps.selectInputByText("Показать все предложения");
        sberLeasingSteps.checkIfOptionsPageHasCarMake(carMake);
        sberLeasingSteps.clickButtonShowAllOffers();
        sberLeasingSteps.checkIfSelectedOptionHasCarMake(carMake);
    }
}
