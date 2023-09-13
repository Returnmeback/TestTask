package sberleasing.ui.steps;

import io.qameta.allure.Step;
import sberleasing.ui.page.GooglePage;
import sberleasing.ui.page.SberLeasingPage;

public class GoogleSearchSteps {
    private final GooglePage googlePage = new GooglePage();

    @Step("Ищем в гугле текст {text}")
    public void googleSearch(String text) {
        googlePage.searchFor(text);
    }

    @Step("Открываем ссылку с текстом {text}")
    public void openSiteFromGoogleSearch(String text) {
        googlePage.selectSite(text);
    }
}
