import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
public class SberTest {
    @Test
    public void userSearchSber() {
        SberLeasingPage SberLeasingPage = new SberLeasingPage();
        open("https://google.com");
        new GooglePage().searchFor("СберЛизинг");
        GooglePage.selectSite("СберЛизинг — официальный сайт");
        SberLeasingPage.clicker("Закрыть");
        SberLeasingPage.clickParameters();
        SberLeasingPage.enterValue("Город", "Москва");
        SberLeasingPage.enterValue("Марка", "KIA");
        SberLeasingPage.enterValue("Модель", "Sorento");
        SberLeasingPage.setSliderInCategory("Мощность двигателя");
        SberLeasingPage.clicker("полный");
        SberLeasingPage.clicker("автомат");
        SberLeasingPage.clicker("кроссовер");
        SberLeasingPage.clicker("бензин");
        SberLeasingPage.colorSelection();
        SberLeasingPage.clicker("черный");
        SberLeasingPage.setSliderInCategory("Объём двигателя");
        SberLeasingPage.clicker("Показать все предложения");
        SelenideElement carModel = $x("(//div[@class='tags-filter__item'])[2]");
        carModel.shouldHave(text("KIA"));
        SberLeasingPage.carSelection();
        SelenideElement carModelAndMake = $x("//h1[@class='h2']");
        carModelAndMake.shouldHave(text("KIA"));
    }
}
