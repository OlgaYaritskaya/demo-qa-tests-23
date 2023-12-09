package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ReturnInstructionsPage {
    private final SelenideElement TITLE = $(".h1");
    private final SelenideElement refundRequestSample = $("href='https://sport-marafon.ru/upload/medialibrary/sport-marafon_exchange-edit.pdf'");

    public ReturnInstructionsPage verifyUrl() {
        webdriver().shouldHave(url("https://sport-marafon.ru" + "/oplata-i-dostavka/return"));
        return this;
    }

    public ReturnInstructionsPage verifyTitle(String value) {
        TITLE.shouldHave(Condition.text(value));
        return this;
    }
public ReturnInstructionsPage shouldContainRefundRequestSample(){
        refundRequestSample.shouldBe(Condition.visible);
        return this;
}

}
