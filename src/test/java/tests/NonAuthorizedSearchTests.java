package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

public class NonAuthorizedSearchTests extends BaseTest {

    @ValueSource(strings = {"лыжи"})
    @ParameterizedTest(name = "Результат поискового запроса {0} не должен быть пустым")
    void searchResultShouldNotBeEmptyTest(String searchQuery) {
        MainPage mainPage = new MainPage();
        mainPage
                .openAndVerifyPage();

        var searchPage = mainPage.navigateTo();

        var searchResultsPage = searchPage.setSearchFieldData(searchQuery);

                searchResultsPage.verifyTheListIsNotEmpty();
    }

//@ValueSource(strings = {"брус"})
//@ParameterizedTest(name = "запрос на отсутствующий товар ваозвращает заглушку")


}
