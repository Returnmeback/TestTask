package UI;

import UI.GooglePage;
import UI.SberLeasingPage;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SberTest {

    @BeforeAll
    static void setupAllureReports() {
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.get("https://google.com");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @Test
    public void userSearchSber() {
        String carMake = "Sorento";
        SberLeasingPage sberLeasingPage = new SberLeasingPage();

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
