package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement
            searchInput = $("[action='/search']");

public MainPage openAndVerifyPage() {
    open(" ");
}
    public MainPage setSearchQuery(String query) {
        searchInput.sendKeys(query);
        return this;
    }
}

