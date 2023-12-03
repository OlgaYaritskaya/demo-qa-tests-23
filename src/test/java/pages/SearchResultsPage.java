package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {
    private final SelenideElement
            SEARCH_RESULTS_PRODUCT = $("[href*='/catalog/']");


    public SearchResultsPage verifyTheListIsNotEmpty() {
        SEARCH_RESULTS_PRODUCT.shouldBe(Condition.visible);
        return this;
    }
}
