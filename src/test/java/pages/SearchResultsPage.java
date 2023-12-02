package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {
    private final SelenideElement
            PAGINATOR_CONTENT_LOCATOR = $("#paginatorContent"),
            SEARCH_RESULTS_LINK = $("[href*='/product/']");


    public SearchResultsPage verifyTheListIsNotEmpty() {
        SEARCH_RESULTS_LINK.shouldBe(Condition.visible);
        return this;
    }
}
