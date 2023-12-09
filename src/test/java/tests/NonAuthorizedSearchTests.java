package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

public class NonAuthorizedSearchTests extends BaseTest {

    @ValueSource(strings = {"лыжи", "термобелье"})
    @ParameterizedTest(name = "Результат поискового запроса {0} не должен быть пустым")
    @Tag("Web")
    @Severity(SeverityLevel.BLOCKER)
    void searchResultShouldNotBeEmptyTest(String searchQuery) {
        MainPage mainPage = new MainPage();

        mainPage.openAndVerifyPage();

        var searchResultsPage = mainPage.setSearchQuery(searchQuery);

        searchResultsPage.verifyTheSearchResultsListIsNotEmpty();
    }

    @EmptySource
    @ParameterizedTest(name = "При пустом запросе показывается баннер с преимуществами")
    @Tag("Web")
    @Severity(SeverityLevel.MINOR)
    void emptySearchQueryShouldReturnAdvantagesBanner(String searchQuery) {
        MainPage mainPage = new MainPage();
        mainPage.openAndVerifyPage();

        var searchResults = mainPage.setSearchQuery(searchQuery);
        searchResults.verifyAdvantagesBannerIsShown();
    }

    @Test
    @DisplayName("На странице Возврат товара есть заявление на возврат и обмен товара")
    void returnInstructionsPageContainsRefundAndReturnSampleFormsTest() {
        MainPage mainPage = new MainPage();
        mainPage.openAndVerifyPage();
        var dostavkaIOplataPage = mainPage.navigateTo(mainPage.DOSTAVKA_I_OPLATA_PAGE);
        var returnPage = dostavkaIOplataPage.navigateTo(dostavkaIOplataPage.RETURN_PAGE);

        returnPage.shouldContainRefundRequestSample();
    }

}
