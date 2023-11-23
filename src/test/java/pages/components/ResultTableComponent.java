package pages.components;

import com.codeborne.selenide.SelenideElement;
import pages.StudentRegFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    private SelenideElement tableLocator = $(".table-responsive");

    public ResultTableComponent checkResult(String val1, String val2) {
        tableLocator.$(byText(val1)).parent().shouldHave(text(val2));
        return this;
    }
}