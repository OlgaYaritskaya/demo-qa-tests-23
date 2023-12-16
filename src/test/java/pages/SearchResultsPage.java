package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultsPage {
    private final SelenideElement SEARCH_RESULTS_PRODUCT = $x("//a[contains(@class, 'product-list__name')]");
    private final SelenideElement ADVANTAGES_BANNER = $(".advantage");
    private final SelenideElement SEARCH_RESULTS_LYZHI = $(".product-list__item [href*='lyzhi']");

    public SearchResultsPage verifyTheSearchResultsListIsNotEmpty() {
        SEARCH_RESULTS_PRODUCT.exists();
        return this;
    }
    public SearchResultsPage verifyAdvantagesBannerIsShown(){
        ADVANTAGES_BANNER.shouldBe(Condition.visible);
        return this;
    }
public SearchResultsPage verifyResultsPageContainsLyzhiInHref(){
        SEARCH_RESULTS_LYZHI.shouldBe(Condition.visible);
        return this;
}
}
