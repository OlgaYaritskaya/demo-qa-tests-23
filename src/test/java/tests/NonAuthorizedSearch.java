package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

public class NonAuthorizedSearch {

    @ValueSource(strings = {
            "губная помада", "шампунь от перхоти", "варежки  из мериноса"
    }
    )
    @ParameterizedTest(name = "Результат поискового запроса {0} не должен быть пустым")
    void searchResultShouldNotBeEmpty(String searchQuery) {
        MainPage maiPage = new MainPage();


    }

}
