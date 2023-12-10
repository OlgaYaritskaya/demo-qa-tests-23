package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://sport-marafon.ru";
        //Configuration.holdBrowserOpen = true;
    }

    @AfterEach
    public void afterEach() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }
}
