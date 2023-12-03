package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {
    private final SelenideElement SEARCH_ICON = $("href='/search/'");
    public MainPage openAndVerifyPage() {
        open("");
        webdriver().shouldHave(url("https://sport-marafon.ru/"));
        return this;
    }

    public SearchPage navigateTo() {
        SEARCH_ICON.click();
        webdriver().shouldHave(url("https://sport-marafon.ru" + "/search"));
        return new SearchPage();
    }
}

