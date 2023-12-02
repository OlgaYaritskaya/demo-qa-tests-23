package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.SearchResultsPage;

public class NonAuthorizedSearchTests extends BaseTest {

    @ValueSource(strings = {
            "губная помада", "шампунь от перхоти", "варежки  из мериноса"
    }
    )
    @ParameterizedTest(name = "Результат поискового запроса {0} не должен быть пустым")
    void searchResultShouldNotBeEmptyTest(String searchQuery) {
        MainPage mainPage = new MainPage();
        mainPage
                .openAndVerifyPage()
                .setSearchQuery(searchQuery);

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.verifyTheListIsNotEmpty();


    }

}
