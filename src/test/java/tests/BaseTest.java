package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://sport-marafon.ru";
        //Configuration.holdBrowserOpen = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options",  Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

    }

    @AfterEach
    public void afterEach() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }
}
