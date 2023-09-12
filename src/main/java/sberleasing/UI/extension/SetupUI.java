package sberleasing.UI.extension;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SetupUI implements BeforeAllCallback {
    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        Configuration.baseUrl = "https://google.com";
        Configuration.timeout = 20000L;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
