package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {
    private final SelenideElement
            SEARCH_INPUT = $("[type = 'text']");

    public MainPage openAndVerifyPage() {
        open(" ");
        webdriver().shouldHave(url("https://www.ozon.ru/"));
        return this;
    }

    public SearchResultsPage setSearchQuery(String query) {
        SEARCH_INPUT.sendKeys(query);
        return new SearchResultsPage();
    }
}

