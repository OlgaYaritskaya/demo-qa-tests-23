package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {
    private final SelenideElement SEARCH_ICON = $("#head-search-btn");
    private final SelenideElement SEARCH_INPUT = $("#head-search-input");
    public MainPage openAndVerifyPage() {
        open("");
        webdriver().shouldHave(url("https://sport-marafon.ru/"));
        return this;
    }

    public SearchResultsPage setSearchQuery(String value) {
        SEARCH_ICON.click();
        SEARCH_INPUT.setValue(value).pressEnter();
        return new SearchResultsPage();
    }
}

