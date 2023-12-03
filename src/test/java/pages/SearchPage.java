package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SearchPage {
    private final SelenideElement searchField = $("#page-search-form");


    public SearchPage openAndVerifyPage(){
        open("/search");
        webdriver().shouldHave(url("https://sport-marafon.ru" + "/search"));
        return this;
    }
    public SearchResultsPage setSearchFieldData(String value){
        searchField.setValue(value).pressEnter();
        return new SearchResultsPage();
    }
}
