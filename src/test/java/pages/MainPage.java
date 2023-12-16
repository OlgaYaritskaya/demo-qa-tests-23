package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {
    public final String DOSTAVKA_I_OPLATA_PAGE = "/oplata-i-dostavka/";
    private final SelenideElement SEARCH_ICON = $("#head-search-btn");
    private final SelenideElement SEARCH_INPUT = $("#head-search-input");
    private final SelenideElement dostavkaIOplataButton = $(".header-menu__item [href*='/oplata-i-dostavka']");

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

    public DostavkaIOplataPage navigateTo(String value){
        dostavkaIOplataButton.click();
        webdriver().shouldHave(url("https://sport-marafon.ru" + value));
        return new DostavkaIOplataPage();
    }
}

